package com.santynu.livraria_lello.business.model

data class Book(
    val isbn13: String,
    val isbn10: String,
    val title: String,
    val author: String,
    val editorial: String
)
