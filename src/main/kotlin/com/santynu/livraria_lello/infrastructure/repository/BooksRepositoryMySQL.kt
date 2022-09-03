package com.santynu.livraria_lello.infrastructure.repository

import com.santynu.livraria_lello.business.model.Book
import com.santynu.livraria_lello.business.model.BooksRepository
import com.santynu.livraria_lello.infrastructure.Config
import org.sql2o.Sql2o

class BooksRepositoryMySQL : BooksRepository{
    override fun retrieveAll(): List<Book> {
        return Sql2o(Config.MSQL_JDBC_CONNECTOR, Config.MYSQL_USER, Config.MYSQL_PASSWORD).open().use { connection ->
            connection.createQuery("""SELECT * FROM books""")
                .executeAndFetchTable()
                .rows().map {row ->
                    Book(
                        isbn13 = row.getString("isbn_13"),
                        isbn10 = row.getString("isbn_10"),
                        title = row.getString("title"),
                        author = row.getString("author"),
                        editorial = row.getString("editorial")
                    )
               }
        }
    }
}