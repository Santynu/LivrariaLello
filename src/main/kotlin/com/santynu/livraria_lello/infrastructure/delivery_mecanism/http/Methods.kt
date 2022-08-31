package com.santynu.livraria_lello.infrastructure.delivery_mecanism.http

import com.santynu.livraria_lello.infrastructure.RequestContext
import com.santynu.livraria_lello.infrastructure.RequestContext.Companion.contextFrom
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.PageInteraction
import spark.*

fun get(
    path: String,
    route: (Request, Response) -> PageInteraction<String>
) = Spark.get(path) { request, response -> route(request, response).build() }

fun get(path: String, engine: TemplateEngine, route: (RequestContext, Response) -> PageInteraction<ModelAndView>) =
    Spark.get(path, { request, response -> route(contextFrom(request, response), response).build() }, engine)