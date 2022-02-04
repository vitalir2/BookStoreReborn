package model

data class Book(
    val bookId: Long,
    val title: String,
    val year: Int,
    val price: Double,
    val type: Int,
    val pictureUrl: String?,
    val description: String,
    val langCode: String,
)