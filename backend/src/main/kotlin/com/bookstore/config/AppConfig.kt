package com.bookstore.config

data class AppConfig(
    val databaseServer: String,
    val databaseUsername: String,
    val databaseUserPassword: String,
    val baseDbInitPath: String
)
