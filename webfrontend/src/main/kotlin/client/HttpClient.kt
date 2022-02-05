package client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

object HttpClient {
    val scope: CoroutineScope = CoroutineScope(Job() + Dispatchers.Default)

    val client: HttpClient = HttpClient() {
        install(Logging)
    }
}
