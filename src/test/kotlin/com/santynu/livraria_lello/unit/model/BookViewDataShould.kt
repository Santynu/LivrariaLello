package com.santynu.livraria_lello.unit.model

import com.santynu.livraria_lello.business.model.BookViewData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BookViewDataShould {

    @Test
    fun buildJson() {
        val bookViewData = BookViewData(
            isbn13 = "1234567890ABC",
            isbn10 = "1234567890",
            title = "anyTitle",
            author = "anyAuthor",
            authorId = 1,
            publishingHouse = "anyPublishingHouse",
            publishingHouseId = 1
        )

        assertThat(bookViewData.toJson().toString()).isEqualTo("{\"isbn13\":\"1234567890ABC\",\"isbn10\":\"1234567890\",\"title\":\"anyTitle\",\"author\":\"anyAuthor\",\"authorId\":1,\"publishingHouse\":\"anyPublishingHouse\",\"publishingHouseId\":1}")
    }


}