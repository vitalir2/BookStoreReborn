package com.bookstore.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*

const val DEFAULT_TEST_FRONTEND_HOST = "localhost:8080"

fun Application.configureCors() {
    install(CORS) {
        allowHost(DEFAULT_TEST_FRONTEND_HOST)
        allowHeader(HttpHeaders.ContentType)
    }
}
