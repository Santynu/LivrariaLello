package com.santynu.livraria_lello.view

import com.santynu.livraria_lello.infrastructure.repository.BooksRepositoryMySQL

class ViewData {
    fun getBooksList() = BooksRepositoryMySQL().retrieveAll()
}