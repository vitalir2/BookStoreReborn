package usecases

import client.HttpClient
import client.MAX_ERROR_CODE
import client.MIN_ERROR_CODE
import io.ktor.client.call.*
import io.ktor.client.request.*
import model.Book

class GetBookByTitleUseCase {

    suspend operator fun invoke(title: String): Book? {
        val result = HttpClient.client.get("book/$title")
        if (result.status.value !in MIN_ERROR_CODE..MAX_ERROR_CODE) {
            return result.body()
        }
        return null
    }
}
