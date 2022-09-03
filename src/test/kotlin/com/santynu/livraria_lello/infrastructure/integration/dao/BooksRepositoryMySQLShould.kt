package com.santynu.livraria_lello.infrastructure.integration.dao

import com.santynu.livraria_lello.business.model.Book
import com.santynu.livraria_lello.infrastructure.repository.BooksRepositoryMySQL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BooksRepositoryMySQLShould {

    companion object {
        val exampleBook = Book(
            isbn13 = "9780439064866",
            isbn10 = "0439064864",
            title = "Harry Potter and the Chamber of Secrets",
            author = "J.K. Rowling",
            editorial = "Scholastic Press"

        )
    }

    @Test
    fun retrieveAllBooks() {
        val books = BooksRepositoryMySQL().retrieveAll()

        assertThat(books.size).isEqualTo(7)
        assertThat(books).contains(exampleBook)
    }


}