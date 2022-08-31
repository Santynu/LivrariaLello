package com.santynu.livraria_lello.infrastructure

object Config {

    val PORT = getMandatoryEnvVariable("PORT").toInt()

    private fun getMandatoryEnvVariable(name: String) =
        when (val envVariable = System.getenv(name)) {
            null -> throw Exception("Mandatory env variable missing: $name")
            else -> envVariable
        }
}