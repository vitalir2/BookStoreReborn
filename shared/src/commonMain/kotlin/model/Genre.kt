package model

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val genreId: Long = 1,
    val name: String,
    val description: String = "No description",
)
