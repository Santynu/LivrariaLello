package com.santynu.livraria_lello.infrastructure.integration.services

import com.santynu.livraria_lello.infrastructure.delivery_mecanism.Web
import io.github.rybalkinsd.kohttp.dsl.httpGet
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import spark.Spark
import io.github.rybalkinsd.kohttp.ext.url
import org.assertj.core.api.Assertions
import org.eclipse.jetty.http.HttpStatus
import org.eclipse.jetty.http.HttpStatus.OK_200

class IndexShould {

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            Web.start()
            Spark.awaitInitialization()
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            Spark.stop()
            Spark.awaitStop()
        }
    }

    @Test
    fun `return OK`() {
        val content = httpGet { url("http://localhost:8080/") }

        assertThat(content.code()).isEqualTo(OK_200)
        assertThat(content.body()?.string()).contains("Hello world!")
   }

    @Test
    fun showNavbar() {
        val content = httpGet { url("http://localhost:8080/") }
        val body = content.body()?.string()

        assertThat(content.code()).isEqualTo(OK_200)
        assertThat(body).contains("<nav>")
        assertThat(body).contains("</nav>")
        assertThat(body).contains("<img src=\"/assets/images/deathly_hallows_sign.svg\" alt=\"deathly_hallows_sign\">")
        assertThat(body).contains("<span>Livraria Lello</span>")

    }


}

