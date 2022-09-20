package com.santynu.livraria_lello

import com.santynu.livraria_lello.infrastructure.Config.PORT
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.Web
import com.santynu.livraria_lello.infrastructure.resources.DOBBY_INIT

fun main() {
    println(DOBBY_INIT)
    Web.start()
    println("App running on port: $PORT")
}