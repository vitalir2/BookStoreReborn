package com.bookstore.data.repository

import com.bookstore.data.model.Books
import com.bookstore.data.model.toModel
import model.Book
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class BookRepositoryImpl : BookRepository {
    override fun getBooks(): List<Book> =
        transaction {
            Books.selectAll().map { Books.toModel(it) }
        }

    override fun getBookByTitle(title: String): Book? =
        transaction {
            Books.select { Books.title eq title }.limit(1).map { Books.toModel(it) }.firstOrNull()
        }

    override fun getBooksPaginated(offset: Long, limit: Int): List<Book> =
        transaction {
            Books.selectAll().limit(
                n = limit,
                offset = offset
            ).map { Books.toModel(it) }
        }

    override fun insert(book: Book): Boolean {
        return transaction {
            Books.insert {
                it[title] = book.title
                it[year] = book.year
                it[type] = book.type
                it[description] = book.description
                it[langCode] = book.langCode
                it[priceDollars] = book.price
                it[pictureUrl] = book.pictureUrl
            }
        }.insertedCount > 0
    }
}

val bookRepository: BookRepository = BookRepositoryImpl()
