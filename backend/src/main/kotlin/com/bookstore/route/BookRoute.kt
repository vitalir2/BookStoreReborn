package com.bookstore.route

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.Book

fun Route.bookRoute() {
    route("/book") {
        get {
            val books = listOf(Book.TEST_BOOK, Book.TEST_BOOK)
            call.respond(books)
        }
    }
}