package client

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import model.Book

fun interface GetBooksUseCase {
    suspend operator fun invoke(): Array<Book>
}

class GetBooksUseCaseImpl : GetBooksUseCase {
    override suspend fun invoke(): Array<Book> {
        val booksResponse: HttpResponse = HttpClient.client.get("book")
        if (booksResponse.status.value !in MIN_ERROR_CODE..MAX_ERROR_CODE) {
            return booksResponse.body()
        }
        return emptyArray()
    }
}

fun interface GetPaginatedBooksUseCase {
    suspend operator fun invoke(offset: Long, limit: Int): Array<Book>
}

class GetPaginatedBooksUseCaseImpl : GetPaginatedBooksUseCase {
    override suspend fun invoke(offset: Long, limit: Int): Array<Book> {
        val booksResponse: HttpResponse = HttpClient.client.get(getPaginatedUrl(offset, limit))
        if (booksResponse.status.value !in MIN_ERROR_CODE..MAX_ERROR_CODE) {
            return booksResponse.body()
        }
        return emptyArray()
    }
}

private fun getPaginatedUrl(offset: Long, limit: Int): String = "book?offset=$offset&limit=$limit"
