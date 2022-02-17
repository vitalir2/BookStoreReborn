package com.bookstore.route

import com.bookstore.data.repository.bookRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.bookRoute() {
    route("/book") {
        get {
            val queryParameters = call.request.queryParameters
            if (queryParameters.isEmpty()) {
                val books = bookRepository.getBooks()
                call.respond(HttpStatusCode.Accepted, books)
            } else {
                val rawOffset = queryParameters["offset"] ?: "0"
                val offset = rawOffset.toLongOrNull() ?: return@get call.respond(HttpStatusCode.BadRequest)
                val rawLimit = queryParameters["limit"] ?: return@get call.respond(HttpStatusCode.BadRequest)
                val limit = rawLimit.toIntOrNull() ?: return@get call.respond(HttpStatusCode.BadRequest)
                val paginatedBooks = bookRepository.getBooksPaginated(offset, limit)
                call.respond(HttpStatusCode.Accepted, paginatedBooks)
            }
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
