package com.santynu.livraria_lello.business.model

import com.google.gson.JsonObject

data class BookViewData(
    val isbn13: String,
    val isbn10: String,
    val title: String,
    val author: String,
    val authorId: Int = 0,
    val publishingHouse: String,
    val publishingHouseId: Int = 0
) {
    fun toJson() : JsonObject {
        val jsonObject = JsonObject()
        jsonObject.addProperty("isbn13", isbn13)
        jsonObject.addProperty("isbn10", isbn10)
        jsonObject.addProperty("title", title)
        jsonObject.addProperty("author", author)
        jsonObject.addProperty("authorId", authorId)
        jsonObject.addProperty("publishingHouse", publishingHouse)
        jsonObject.addProperty("publishingHouseId", publishingHouseId)
        return jsonObject
    }
}
