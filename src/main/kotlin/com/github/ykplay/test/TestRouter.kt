package com.github.ykplay.test

import com.github.ykplay.test.models.UserAgeResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-05-23 17:52
 */

fun Route.testRouting() {
    route("/users") {
        get("/{id}/age") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                text = "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )

            call.application.environment.log.info("Hello $id!")

            call.respond(
                status = HttpStatusCode.OK,
                message = UserAgeResponse(18)
            )
        }
    }
}

fun Application.registerTestRoutes() {
    routing {
        testRouting()
    }
}