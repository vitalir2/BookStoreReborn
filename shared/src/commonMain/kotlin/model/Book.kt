package model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val bookId: Long,
    val title: String,
    val year: Int,
    val price: Double,
    val type: Int,
    val pictureUrl: String?,
    val description: String,
    val langCode: String,
    val authors: List<Author>,
    val genres: List<Genre>,
) {
    companion object {
        private var currentId = 1L
        val TEST_BOOK = Book(
            bookId = currentId++,
            title = "Title of the book$currentId",
            year = 1000 + currentId.toInt(),
            // Magic numbers..
            price = 1.5 + currentId.toDouble() / 20,
            type = 1,
            pictureUrl = null,
            description = "The best book of the mankind",
            langCode = "ENG",
            authors = listOf(
                Author(
                    authorId = 1,
                    firstName = "Christopher",
                    lastName = "Jung",
                    123456789,
                    "United Kingdom",
                    "He was the smartest man in his ages"
                )
            ),
            genres = listOf(
                Genre(
                    genreId = 1,
                    name = "Romance",
                    description = "Romance is romance"
                ),
                Genre(
                    genreId = 2,
                    name = "Science Fiction",
                    description = "Something"
                )
            ),
        )
    }
}