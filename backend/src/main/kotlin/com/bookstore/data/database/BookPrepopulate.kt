@file:Suppress("ImportOrdering")

package com.bookstore.data.database

import java.time.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.Author
import model.Book
import model.Genre

@Serializable
data class BookPrepopulate(
    val title: String,
    val authors: List<String>,
    @SerialName("image_url")
    val imageUrl: String,
    val description: String,
    val language: String?,
    @SerialName("book_format")
    val format: String?,
    val edition: String?,
    val genres: List<String>,
)

internal fun BookPrepopulate.toMainModel(): Book =
    Book(
        title = title,
        description = description,
        pictureUrl = imageUrl,
        authors = authors.map(::createAuthorFromName),
        genres = genres.map { genreName ->
            Genre(
                name = genreName
            )
        }
    )

// FirstName.LastName
private fun createAuthorFromName(authorName: String): Author =
    Author(
        firstName = authorName.takeWhile { it != ' ' },
        lastName = authorName.takeLastWhile { it != ' ' },
        bornDate = LocalDate.now().toEpochDay()
    )
