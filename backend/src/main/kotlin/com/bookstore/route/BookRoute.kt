package com.bookstore.route

import com.bookstore.data.repository.bookRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.bookRoute() {
    route("/book") {
        get {
            val books = bookRepository.getBooks()
            call.respond(HttpStatusCode.Accepted, books)
        }
        get("/{title}") {
            val title = call.parameters["title"]
                ?: return@get call.respond(HttpStatusCode.BadRequest)

            val book = bookRepository.getBookByTitle(title)
                ?: return@get call.respond(HttpStatusCode.NotFound)

            call.respond(HttpStatusCode.Accepted, book)
        }
    }
}