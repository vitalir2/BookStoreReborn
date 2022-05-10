package com.bookstore.data.database

import com.bookstore.config.AppConfig
import com.bookstore.data.model.Books
import com.bookstore.data.repository.BookRepository
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.utils.io.errors.*
import java.io.File
import java.nio.charset.Charset
import javax.sql.DataSource
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.exists
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

fun createDatabase(
    dataSource: DataSource,
    bookRepository: BookRepository,
    baseDbInitPath: String
): Database {
    val database = Database.connect(dataSource)
    tryInitBooksScheme(baseDbInitPath, bookRepository)
    transaction {
        addLogger(StdOutSqlLogger)
    }
    TransactionManager.defaultDatabase = database
    return database
}

private fun tryInitBooksScheme(
    baseDbInitPath: String,
    bookRepository: BookRepository
) {
    val initBooksData = tryReadInitBooksFile(baseDbInitPath)
    transaction {
        if (Books.exists()) return@transaction
        SchemaUtils.create(Books)

        for (initBook in initBooksData) {
            bookRepository.insert(initBook.toMainModel())
        }
    }
}

private fun tryReadInitBooksFile(baseDbInitPath: String): List<BookPrepopulate> {
    val readBooksDataString1: String
    try {
        readBooksDataString1 = File("$baseDbInitPath/books.json").readText(charset = Charset.defaultCharset())
    } catch (ex: IOException) {
        exposedLogger.error("Cannot read $baseDbInitPath/books.json, current dir is ${(File(".").absolutePath)}")
        exposedLogger.error("Error message: ${ex.message}")
        return emptyList()
    }
    return Json.decodeFromJsonElement(
        Json.parseToJsonElement(readBooksDataString1)
    )
}

fun createDataSource(appConfig: AppConfig): DataSource {
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
