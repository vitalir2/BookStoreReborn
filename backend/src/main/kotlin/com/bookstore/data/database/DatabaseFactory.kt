package com.bookstore.data.database

import com.bookstore.config.AppConfig
import com.bookstore.data.model.Books
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

val database by lazy {
    val createdDatabase = createDatabase()
    transaction {
        addLogger(StdOutSqlLogger)

        SchemaUtils.drop(Books)
        SchemaUtils.create(Books)

        Books.insert {
            it[title] = "The Hunger Games"
            it[year] = 2008
            it[priceDollars] = 15.19
            it[type] = 1 // Hardcover
            it[pictureUrl] = "https://images-na.ssl-images-amazon.com/images/I/41V56ye3PrL._SX328_BO1,204,203,200_.jpg"
            it[description] = """
                The first novel in the worldwide bestselling series by Suzanne Collins!
                Winning means fame and fortune. Losing means certain death. The Hunger Games have begun. . . . 
                In the ruins of a place once known as North America lies the nation of Panem,
                a shining Capitol surrounded 
                by twelve outlying districts. The Capitol is harsh and cruel and keeps the districts in line 
                by forcing them all to send one boy and one girl between the ages of twelve and eighteen
                to participate in the annual Hunger Games, a fight to the death on live TV. 
                Sixteen-year-old Katniss Everdeen regards it as a death sentence 
                when she steps forward to take her sister's place in the Games. 
                But Katniss has been close to dead before-and survival, for her, is second nature. 
                Without really meaning to, she becomes a contender. 
                But if she is to win, she will have to start making choices that weigh survival against
                humanity and life against love.
            """.trimIndent()
            it[langCode] = "ENG"
        }

        exposedLogger.debug(Books.selectAll().toString())
    }
    createdDatabase
}

private fun createDatabase(): Database = Database.connect(createDataSource())

private fun createDataSource(): DataSource {
    val appConfig = AppConfig.instance
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
