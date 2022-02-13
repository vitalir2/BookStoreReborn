package model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val authorId: Long = 1,
    val firstName: String,
    val lastName: String,
    val bornDate: Long,
    val bornCountry: String = "Unknown",
    val description: String = "No description",
)
