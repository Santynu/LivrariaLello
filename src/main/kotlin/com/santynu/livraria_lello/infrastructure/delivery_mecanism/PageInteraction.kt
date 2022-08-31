package com.santynu.livraria_lello.infrastructure.delivery_mecanism

class PageInteraction<K> internal constructor(
    private val response: K,
)  {
    fun build(): K {
        return response
    }

    companion object {
        fun <K> aPageInteraction(response: K, ): PageInteraction<K> {
            return PageInteraction(response)
        }
    }

}