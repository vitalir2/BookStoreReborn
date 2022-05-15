package client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

object HttpClient {
    val scope: CoroutineScope = CoroutineScope(Job())

    val client: HttpClient = HttpClient() {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
        install(DefaultRequest) {
            url(DEFAULT_HOST)
            header("Content-Type", ContentType.Application.Json)
        }
    }
}
