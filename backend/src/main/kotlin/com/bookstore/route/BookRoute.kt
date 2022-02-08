package com.bookstore.route

import com.bookstore.data.model.Books
import com.bookstore.data.model.toModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.Book
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.bookRoute() {
    route("/book") {
        get {
            val books = listOf(Book.TEST_BOOK, Book.TEST_BOOK)
            call.respond(books)
        }
        get("/{title}") {
            val title = call.parameters["title"]
            if (title == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val book = transaction {
                Books.select { Books.title eq title }.limit(1).map { Books.toModel(it) }.firstOrNull()
            }

            if (book == null) {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }
            call.respond(HttpStatusCode.Accepted, book)
        }
    }
}