package com.github.ykplay.chat

import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-05-26 22:06
 */

fun Route.chatRouting() {
    webSocket("/chat") {
        send("You are connected.")
        for (frame in incoming) {
            frame as? Frame.Text ?: continue
            val receivedText = frame.readText()
            send("You said: $receivedText")
        }
    }
}

fun Application.registerChatRoutes() {
    routing {
        chatRouting()
    }
}