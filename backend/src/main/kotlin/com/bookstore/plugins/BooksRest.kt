package com.bookstore.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import model.Book

fun Application.configureBooksRest() {
    install(ContentNegotiation) {
        json()
    }
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
        route("/book") {
            get {
                val books = listOf(Book.TEST_BOOK, Book.TEST_BOOK)
                call.respond(books)
            }
        }
    }
}