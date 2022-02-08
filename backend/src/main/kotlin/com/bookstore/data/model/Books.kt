package com.bookstore.data.model

import model.Book
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

object Books : IntIdTable() {
    val title = varchar("title", 200)
    val year = integer("year")
    val priceDollars = double("price")
    val type = integer("type") // TODO: change to Enum with many types of books (online, hardcover..)
    val pictureUrl = text("picture_url").nullable()
    val description = text("description")
    val langCode = varchar("lang_code", 3)
}

fun Books.toModel(resultRow: ResultRow): Book =
    Book(
        bookId = resultRow[id].value.toLong(),
        title = resultRow[title],
        year = resultRow[year],
        price = resultRow[priceDollars],
        type = resultRow[type],
        pictureUrl = resultRow[pictureUrl],
        description = resultRow[description],
        langCode = resultRow[langCode],
        authors = emptyList(),
        genres = emptyList()
    )