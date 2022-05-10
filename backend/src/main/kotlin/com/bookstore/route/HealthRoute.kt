package com.bookstore.route

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.healthRoute() {
    get("/health/") {
        call.respondText(
            text = "ok",
            status = HttpStatusCode.OK
        )
    }
}
