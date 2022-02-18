package com.bookstore

import com.bookstore.plugins.configureCors
import com.bookstore.plugins.configureDI
import com.bookstore.plugins.configureHttp
import com.bookstore.plugins.configureMainRoutes
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

// application.conf references the main function. This annotation prevents the IDE from marking it as unused.
@Suppress("unused")
fun Application.module() {
    configureDI(environment.config)
    configureHttp()
    configureMainRoutes()
    configureCors()
}
