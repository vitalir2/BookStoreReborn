package com.bookstore.plugins.di

import com.bookstore.data.repository.BookRepository
import com.bookstore.data.repository.BookRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<BookRepository> { BookRepositoryImpl() }
}
