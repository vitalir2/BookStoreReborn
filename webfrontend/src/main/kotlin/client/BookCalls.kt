package client

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import model.Book

const val DEFAULT_HOST = "http://0.0.0.0:8081"

fun interface GetBooksUseCase {
    suspend operator fun invoke(): List<Book>
}

class GetBooksUseCaseImpl : GetBooksUseCase {
    override suspend fun invoke(): List<Book> {
        val booksResponse: HttpResponse = HttpClient.client.get("$DEFAULT_HOST/book")
        if (booksResponse.status.value !in 400..600) {
            return booksResponse.body()
        }
        return emptyList()
    }
}

// TODO: Change to DI like KodeIn
val getBooksUseCase: GetBooksUseCase = GetBooksUseCaseImpl()
