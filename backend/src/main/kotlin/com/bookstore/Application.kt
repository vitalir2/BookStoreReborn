package com.bookstore

import com.bookstore.plugins.configureCors
import com.bookstore.plugins.configureHttp
import com.bookstore.plugins.configureMainRoutes
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureHttp()
    configureMainRoutes()
    configureCors()
}
