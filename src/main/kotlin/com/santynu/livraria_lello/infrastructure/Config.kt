package com.santynu.livraria_lello.infrastructure

object Config {

    val PORT = getMandatoryEnvVariable("PORT").toInt()
    val MSQL_JDBC_CONNECTOR = getMandatoryEnvVariable("MSQL_JDBC_CONNECTOR")
    val MYSQL_USER = getMandatoryEnvVariable("MYSQL_USER")
    val MYSQL_PASSWORD = getMandatoryEnvVariable("MYSQL_PASSWORD")

    fun isLocal() = getMandatoryEnvVariable("ENV") == "LOCAL"

    private fun getMandatoryEnvVariable(name: String) =
        when (val envVariable = System.getenv(name)) {
            null -> throw Exception("Mandatory env variable missing: $name")
            else -> envVariable
        }
}