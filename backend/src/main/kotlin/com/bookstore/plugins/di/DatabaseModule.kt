package com.bookstore.plugins.di

import com.bookstore.data.database.createDataSource
import com.bookstore.data.database.createDatabase
import org.koin.dsl.module

val databaseModule = module {
    single(createdAtStart = true) { createDataSource(get()) }
    single(createdAtStart = true) { createDatabase(get(), get()) }
}
