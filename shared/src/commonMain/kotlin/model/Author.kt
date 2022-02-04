package model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val authorId: Long,
    val firstName: String,
    val lastName: String,
    val bornDate: Long,
    val bornCountry: String,
    val description: String,
)
