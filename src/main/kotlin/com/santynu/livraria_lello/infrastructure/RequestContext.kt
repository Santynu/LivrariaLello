package com.santynu.livraria_lello.infrastructure

import spark.Request
import spark.Response

class RequestContext private constructor(
        private val request: Request,
        private val response: Response
){
    companion object {

        fun contextFrom(request: Request, response: Response): RequestContext {
            return RequestContext(
                    request = request,
                    response = response
            )
        }
    }
}