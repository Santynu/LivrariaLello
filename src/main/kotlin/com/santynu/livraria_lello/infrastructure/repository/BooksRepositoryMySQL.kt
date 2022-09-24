package com.santynu.livraria_lello.infrastructure.repository

import com.santynu.livraria_lello.business.model.BookViewData
import com.santynu.livraria_lello.business.model.BooksRepository
import com.santynu.livraria_lello.infrastructure.Config
import org.sql2o.Sql2o

class BooksRepositoryMySQL : BooksRepository{
    override fun retrieveAll(): List<BookViewData> {
        return createConnector().use { connection ->
            connection.createQuery(retrieveAllBooksQueryString())
                .executeAndFetchTable()
                .rows().map {row ->
                    BookViewData(
                        isbn13 = row.getString("isbn_13"),
                        isbn10 = row.getString("isbn_10"),
                        title = row.getString("title"),
                        author = row.getString("author"),
                        editorial = row.getString("publishing_house")
                    )
               }
        }
    }

    override fun deleteOneForISBN13(isbn13: String) {
        createConnector().use { connection ->
            connection.createQuery("""DELETE FROM books WHERE isbn_13= '$isbn13'""").executeUpdate()
        }
    }

    private fun createConnector() = Sql2o(Config.MSQL_JDBC_CONNECTOR, Config.MYSQL_USER, Config.MYSQL_PASSWORD).open()

    private fun retrieveAllBooksQueryString() = """select
            books.isbn_13, books.isbn_10, books.title, authors.name as author, publishing_houses.name as publishing_house
        from
            books, authors, publishing_houses
        where
            books.author_id = authors.id && books.publishing_house_id = publishing_houses.id"""
}