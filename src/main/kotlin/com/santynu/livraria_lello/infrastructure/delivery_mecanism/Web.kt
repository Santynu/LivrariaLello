package com.santynu.livraria_lello.infrastructure.delivery_mecanism

import com.santynu.livraria_lello.infrastructure.Config.PORT
import com.santynu.livraria_lello.infrastructure.Config.isLocal
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.PageInteraction.Companion.aPageInteraction
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.http.get
import com.santynu.livraria_lello.infrastructure.delivery_mecanism.template_engine.CustomFreeMarkerEngine.templateEngine
import com.santynu.livraria_lello.infrastructure.repository.BooksRepositoryMySQL
import com.santynu.livraria_lello.view.ViewData
import spark.ModelAndView
import spark.Spark
import spark.Spark.port
import spark.Spark.secure
import spark.TemplateEngine

object Web {
    fun start() {
        configureStaticFilesLocation()

        port(PORT)
        registerRoutes(templateEngine())
    }
    private fun registerRoutes(templateEngine: TemplateEngine){
        get(path = "/", engine = templateEngine) { request, response ->
            try {
                aPageInteraction(ModelAndView(ViewData(), "index.ftl"))
            } catch (e: Exception){
                throw Exception(e)
            }
        }

        get(path = "/delete/:id") {requestContext, _ ->
            BooksRepositoryMySQL().deleteOneForISBN13(requestContext.params("id"))
            aPageInteraction("OK")
        }

        get(path = "/health") { _, _ -> aPageInteraction("OK") }
    }

    private fun configureStaticFilesLocation() {
        val staticFilesLocation = if (isLocal()) "src/main/resources/dist" else "dist"

        if (isLocal()) Spark.externalStaticFileLocation(staticFilesLocation)
        else Spark.staticFileLocation(staticFilesLocation)
    }
}