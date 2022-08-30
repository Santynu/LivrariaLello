package com.santynu.livraria_lello.infrastructure.delivery_mecanism.http

import com.santynu.livraria_lello.infrastructure.delivery_mecanism.PageInteraction
import spark.Request
import spark.Response
import spark.Spark

fun get(
    path: String,
    route: (Request, Response) -> PageInteraction<String>
) = Spark.get(path) { request, response -> route(request, response).build() }