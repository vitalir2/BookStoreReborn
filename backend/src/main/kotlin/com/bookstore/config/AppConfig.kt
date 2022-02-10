package com.bookstore.config

import io.ktor.server.config.*

data class AppConfig(
    val databaseServer: String,
    val databaseUsername: String,
    val databaseUserPassword: String,
) {
    companion object {
        lateinit var instance: AppConfig
        fun init(mainConfig: ApplicationConfig) {
            instance = AppConfig(
                databaseServer = mainConfig.property("ktor.database.server").getString(),
                databaseUsername = mainConfig.property("ktor.database.username").getString(),
                databaseUserPassword = mainConfig.property("ktor.database.password").getString(),
            )
        }
    }
}
