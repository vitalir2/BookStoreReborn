package com.bookstore.plugins.di

import com.bookstore.config.AppConfig
import org.koin.dsl.module

val configurationModule = module {
    single(createdAtStart = true) {
        AppConfig(
            databaseServer = getProperty("ktor.database.server"),
            databaseUsername = getProperty("ktor.database.username"),
            databaseUserPassword = getProperty("ktor.database.password"),
        )
    }
}
