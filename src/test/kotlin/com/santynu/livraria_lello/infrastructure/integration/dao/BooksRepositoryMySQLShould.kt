package com.santynu.livraria_lello.infrastructure.integration.dao

import com.santynu.livraria_lello.business.model.BookViewData
import com.santynu.livraria_lello.infrastructure.Config
import com.santynu.livraria_lello.infrastructure.repository.BooksRepositoryMySQL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.sql2o.Sql2o

class BooksRepositoryMySQLShould {

    companion object {
        val exampleBook = BookViewData(
            isbn13 = "9780439064866",
            isbn10 = "0439064864",
            title = "Harry Potter and the Chamber of Secrets",
            author = "J.K. Rowling",
            publishingHouse = "Scholastic Press"

        )
    }

    @Test
    fun retrieveAllBooks() {
        val books = BooksRepositoryMySQL().retrieveAll()

        assertThat(books.size).isEqualTo(7)
        assertThat(books).contains(exampleBook)
    }

    @Test
    fun retrieveBookInfo() {
        val isbn13 = "9780590353403"

        val bookInfo = BooksRepositoryMySQL().retrieveBookInfo(isbn13)

        assertThat(bookInfo.isbn13).isEqualTo(isbn13)
        assertThat(bookInfo.isbn10).isEqualTo("0590353403")
        assertThat(bookInfo.title).isEqualTo("Harry Potter and the Philosopher's Stone")
        assertThat(bookInfo.authorId).isEqualTo(1)
        assertThat(bookInfo.author).isEqualTo("J.K. Rowling")
        assertThat(bookInfo.publishingHouseId).isEqualTo(1)
        assertThat(bookInfo.publishingHouse).isEqualTo("Scholastic Press")
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
            connector.createQuery("""INSERT INTO books (isbn_13, isbn_10, title, author_id, publishing_house_id) VALUES
                ("${isbn13}", "0000000001", "Any book", 1, 1)""").executeUpdate()
        }
    }

    private fun checkIfBookExits(isbn13: String) : Boolean{
        return Sql2o(Config.MSQL_JDBC_CONNECTOR, Config.MYSQL_USER, Config.MYSQL_PASSWORD).open().use { connector ->
            connector.createQuery("""SELECT isbn_13 FROM books WHERE isbn_13 = '$isbn13'""").executeAndFetchTable().rows().size == 1
        }
    }


}