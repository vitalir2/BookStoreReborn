package com.bookstore.data.repository

import com.bookstore.data.model.Books
import com.bookstore.data.model.toModel
import model.Book
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
}

val bookRepository: BookRepository = BookRepositoryImpl()
