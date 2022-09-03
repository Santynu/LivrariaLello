package com.santynu.livraria_lello.business.model

interface BooksRepository {
    fun retrieveAll() : List<Book>

    fun deleteOneForISBN13(isbn13: String)
}