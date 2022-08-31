package com.santynu.livraria_lello.infrastructure.delivery_mecanism

import com.santynu.livraria_lello.infrastructure.Config.PORT
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.PageInteraction.Companion.aPageInteraction
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.http.get
import spark.Spark.port
import spark.Spark.secure

object Web {
    fun start() {
        port(PORT)
        registerRoutes()
    }
    private fun registerRoutes(){
        get(path = "/health") { _, _ -> aPageInteraction("OK") }
    }
}