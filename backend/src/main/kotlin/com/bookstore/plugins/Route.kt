package com.bookstore.plugins

import com.bookstore.route.bookRoute
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1

fun Application.configureMainRoutes() {
    routing {
        route("/") {
            get {
                call.respondHtml {
                    body {
                        h1 {
                            +"Hello world!"
                        }
                    }
                }
            }
        }
        bookRoute()
    }
}