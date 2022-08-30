package com.santynu.livraria_lello.infrastructure.delivery_mecanism

import com.santynu.livraria_lello.infrastructure.delivery_mecanism.PageInteraction.Companion.aPageInteraction
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.http.get
import spark.Spark.port

object Web {
    fun start() {
        port(8080)
        registerRoutes()
    }

    private fun registerRoutes(){
        get(path = "/health") { _, _ -> aPageInteraction("OK") }
    }



}