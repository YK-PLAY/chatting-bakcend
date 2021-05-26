package com.github.ykplay

import com.github.ykplay.chat.registerChatRoutes
import com.github.ykplay.test.registerTestRoutes
import io.ktor.application.*
import io.ktor.features.*

import io.ktor.serialization.*
import io.ktor.websocket.*

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-05-23 18:04
 */

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    // init http server
    install(ContentNegotiation) {
        json()
    }

    // init web socket server
    install(WebSockets) {
    }

    // routing
    registerTestRoutes()
    registerChatRoutes()
}