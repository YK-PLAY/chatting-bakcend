package com.github.ykplay

import com.github.ykplay.test.registerTestRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-05-23 18:04
 */

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
    install(CORS) {
        anyHost()
    }
    registerTestRoutes()
}