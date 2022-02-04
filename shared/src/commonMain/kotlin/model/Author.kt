package model

data class Author(
    val authorId: Long,
    val firstName: String,
    val lastName: String,
    val bornDate: Date?,
    val bornCountry: String,
    val description: String,
)
