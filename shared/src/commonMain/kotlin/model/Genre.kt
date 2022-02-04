package model

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val genreId: Long,
    val name: String,
    val description: String,
)
