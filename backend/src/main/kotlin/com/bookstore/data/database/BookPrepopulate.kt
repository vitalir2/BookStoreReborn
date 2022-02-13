package com.bookstore.data.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookPrepopulate(
    val title: String,
    val authors: List<String>,
    @SerialName("image_url")
    val imageUrl: String,
    val description: String,
    val language: String?,
    @SerialName("book_format")
    val format: String?,
    val edition: String?,
    val genres: List<String>,
)
