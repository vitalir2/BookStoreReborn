package com.bookstore.plugins

import com.bookstore.plugins.di.configurationModule
import com.bookstore.plugins.di.databaseModule
import com.bookstore.plugins.di.repositoryModule
import com.typesafe.config.ConfigException
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.koin.ktor.plugin.koin
import org.koin.logger.SLF4JLogger

fun Application.configureDI(applicationConfig: ApplicationConfig) {
    koin {
        SLF4JLogger()
        properties(applicationConfig.toProperties())
        modules(configurationModule, databaseModule, repositoryModule)
    }
}

private fun ApplicationConfig.toProperties(): Map<String, String> {
    val result = mutableMapOf<String, String>()
    for (key in keys()) {
        try {
            result[key] = property(key).getString()
        } catch (@Suppress("SwallowedException") ex: ConfigException) {
            // We don't need list of strings from configuration yet
        }
    }
    return result
}
