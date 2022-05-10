package com.bookstore.plugins

import com.bookstore.route.bookRoute
import com.bookstore.route.healthRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureMainRoutes() {
    routing {
        healthRoute()
        bookRoute()
    }
}
