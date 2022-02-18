package com.bookstore.data.repository

import com.bookstore.plugins.declaration.inject
import model.Book

val bookRepository by inject<BookRepository>()

interface BookRepository {
    fun getBooks(): List<Book>
    fun getBookByTitle(title: String): Book?
    fun getBooksPaginated(offset: Long, limit: Int): List<Book>
    fun insert(book: Book): Boolean
}
