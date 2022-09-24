package com.santynu.livraria_lello.business.model

interface BooksRepository {
    fun retrieveAll() : List<BookViewData>

    fun deleteOneForISBN13(isbn13: String)
}