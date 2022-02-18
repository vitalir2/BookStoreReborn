package com.bookstore.data.database

import com.bookstore.config.AppConfig
import com.bookstore.data.model.Books
import com.bookstore.data.repository.bookRepository
import com.bookstore.plugins.declaration.inject
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.io.File
import java.nio.charset.Charset
import java.time.LocalDate
import javax.sql.DataSource
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import model.Author
import model.Book
import model.Genre
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.exists
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

private const val PREPOPULATE_BOOKS_DATA_PATH = "src/main/resources/books.json"

fun createDatabase(): Database {
    val dataSource by inject<DataSource>()
    val database = Database.connect(dataSource)
    val readBooksDataString = File(PREPOPULATE_BOOKS_DATA_PATH).readText(charset = Charset.defaultCharset())
    val initBooksData = Json.decodeFromJsonElement<List<BookPrepopulate>>(Json.parseToJsonElement(readBooksDataString))
    transaction {
        if (Books.exists()) return@transaction
        SchemaUtils.create(Books)

        for (book in initBooksData) {
            bookRepository.insert(
                Book(
                    title = book.title,
                    description = book.description,
                    pictureUrl = book.imageUrl,
                    authors = book.authors.map { authorName ->
                        Author(
                            firstName = authorName.takeWhile { it != ' ' },
                            lastName = authorName.takeLastWhile { it != ' ' },
                            bornDate = LocalDate.now().toEpochDay(),
                        )
                    },
                    genres = book.genres.map { genreName ->
                        Genre(
                            name = genreName,
                        )
                    }
                )
            )
        }
    }
    transaction {
        addLogger(StdOutSqlLogger)
    }
    TransactionManager.defaultDatabase = database
    return database
}

fun createDataSource(): DataSource {
    val appConfig by inject<AppConfig>()
    val hikariConfig = HikariConfig().apply {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = "jdbc:postgresql://${appConfig.databaseServer}/bookstore_db"
        username = appConfig.databaseUsername
        password = appConfig.databaseUserPassword
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
    return HikariDataSource(hikariConfig)
}
