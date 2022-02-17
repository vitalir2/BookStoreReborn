package client

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import model.Book

fun interface GetBooksUseCase {
    suspend operator fun invoke(): Array<Book>
}

class GetBooksUseCaseImpl : GetBooksUseCase {
    override suspend fun invoke(): Array<Book> {
        val booksResponse: HttpResponse = HttpClient.client.get("$DEFAULT_HOST/book") {
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
        }
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
        val booksResponse: HttpResponse = HttpClient.client.get(getPaginatedUrl(offset, limit)) {
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
        }
        if (booksResponse.status.value !in MIN_ERROR_CODE..MAX_ERROR_CODE) {
            return booksResponse.body()
        }
        return emptyArray()
    }
}

private fun getPaginatedUrl(offset: Long, limit: Int): String = "$DEFAULT_HOST/book?offset=$offset&limit=$limit"

// TODO: Change to DI like KodeIn
val getBooksUseCase: GetBooksUseCase = GetBooksUseCaseImpl()
val getPaginatedBooksUseCase: GetPaginatedBooksUseCase = GetPaginatedBooksUseCaseImpl()
