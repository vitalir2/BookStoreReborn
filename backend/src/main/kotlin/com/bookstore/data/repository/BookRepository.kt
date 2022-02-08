package com.bookstore.data.repository

import model.Book

interface BookRepository {
    fun getBookByTitle(title: String): Book?
}
