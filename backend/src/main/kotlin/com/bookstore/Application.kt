package com.bookstore

import com.bookstore.config.AppConfig
import com.bookstore.data.database.database
import com.bookstore.plugins.configureCors
import com.bookstore.plugins.configureHttp
import com.bookstore.plugins.configureMainRoutes
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.transactions.TransactionManager

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    AppConfig.init(environment.config)
    TransactionManager.defaultDatabase = database

    configureHttp()
    configureMainRoutes()
    configureCors()
}
