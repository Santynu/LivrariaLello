package com.santynu.livraria_lello.infrastructure

import com.santynu.livraria_lello.infrastructure.Config.PORT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConfigShould {
    @Test
    fun xxx() {
        assertThat(PORT).isEqualTo(System.getenv("PORT").toInt())
    }
}