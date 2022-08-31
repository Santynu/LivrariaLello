package com.santynu.livraria_lello.infrastructure.delivery_mecanism.template_engine


import com.santynu.livraria_lello.infrastructure.Config
import freemarker.template.Configuration
import freemarker.template.Version
import spark.template.freemarker.FreeMarkerEngine
import java.io.File

object CustomFreeMarkerEngine {

    private val templatesLocation = if (Config.isLocal()) "src/main/resources/dist/templates" else "dist/templates"

    fun templateEngine(): FreeMarkerEngine {
        val conf = Configuration(Version(2, 3, 23))
        if (Config.isLocal()) conf.setDirectoryForTemplateLoading(File(templatesLocation))
        else conf.setClassLoaderForTemplateLoading(this::class.java.classLoader, templatesLocation)
        return FreeMarkerEngine(conf)
    }
}