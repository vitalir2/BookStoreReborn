package com.bookstore

import com.bookstore.config.AppConfig
import com.bookstore.plugins.KoinPlugin
import com.bookstore.plugins.configureCors
import com.bookstore.plugins.configureHttp
import com.bookstore.plugins.configureMainRoutes
import com.bookstore.plugins.di.databaseModule
import com.bookstore.plugins.di.repositoryModule
import io.ktor.server.application.*
import org.koin.logger.SLF4JLogger

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

// application.conf references the main function. This annotation prevents the IDE from marking it as unused.
@Suppress("unused")
fun Application.module() {
    AppConfig.init(environment.config)
    configureDI()
    configureHttp()
    configureMainRoutes()
    configureCors()
}

private fun Application.configureDI() {
    install(KoinPlugin) {
        SLF4JLogger()
        modules(databaseModule, repositoryModule)
    }
}
