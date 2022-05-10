package com.bookstore.route

import com.bookstore.data.repository.BookRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.bookRoute() {
    route("/book") {
        getBooks()
        getBookByTitle()
    }
}

private fun Route.getBooks() {
    val bookRepository by inject<BookRepository>()
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
}

private fun Route.getBookByTitle() {
    val bookRepository by inject<BookRepository>()
    get("/{title}") {
        val title = call.parameters["title"]
            ?: return@get call.respond(HttpStatusCode.BadRequest)

        val book = bookRepository.getBookByTitle(title)
            ?: return@get call.respond(HttpStatusCode.BadRequest)

        call.respond(HttpStatusCode.Accepted, book)
    }
}
