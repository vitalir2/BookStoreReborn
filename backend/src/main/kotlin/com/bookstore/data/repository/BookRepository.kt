package com.bookstore.data.repository

import model.Book

interface BookRepository {
    fun getBooks(): List<Book>
    fun getBookByTitle(title: String): Book?
    fun getBooksPaginated(offset: Long, limit: Int): List<Book>
    fun insert(book: Book): Boolean
}
