package com.santynu.livraria_lello.infrastructure.integration.dao

import com.santynu.livraria_lello.business.model.Book
import com.santynu.livraria_lello.infrastructure.Config
import com.santynu.livraria_lello.infrastructure.repository.BooksRepositoryMySQL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.sql2o.Sql2o

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

    @Test
    fun deleteOne() {
        val isbn13Example = "0000000000001"
        addOneBookToDatabase(isbn13Example)
        assertThat(checkIfBookExits(isbn13Example)).isEqualTo(true)
        BooksRepositoryMySQL().deleteOneForISBN13(isbn13Example)
        assertThat(checkIfBookExits(isbn13Example)).isEqualTo(false)

    }

    private fun addOneBookToDatabase(isbn13: String) {
        Sql2o(Config.MSQL_JDBC_CONNECTOR, Config.MYSQL_USER, Config.MYSQL_PASSWORD).open().use { connector ->
            connector.createQuery("""INSERT INTO books (isbn_13, isbn_10, title, author, editorial) VALUES
                ("${isbn13}", "0000000001", "Any book", "Any author", "Any editorial")""").executeUpdate()
        }
    }

    private fun checkIfBookExits(isbn13: String) : Boolean{
        return Sql2o(Config.MSQL_JDBC_CONNECTOR, Config.MYSQL_USER, Config.MYSQL_PASSWORD).open().use { connector ->
            connector.createQuery("""SELECT isbn_13 FROM books WHERE isbn_13 = '$isbn13'""").executeAndFetchTable().rows().size == 1
        }
    }


}