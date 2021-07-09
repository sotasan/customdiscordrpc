package net.pryoscode.customdiscordrpc

import kotlin.io.println
import club.minnced.discord.rpc.DiscordRPC
import club.minnced.discord.rpc.DiscordEventHandlers
import club.minnced.discord.rpc.DiscordRichPresence
import club.minnced.discord.rpc.DiscordUser

class Discord : DiscordEventHandlers.OnReady {

    constructor(config: Config) {
        val lib = DiscordRPC.INSTANCE
        val handlers = DiscordEventHandlers()
        handlers.ready = this
        lib.Discord_Initialize("638034914398175233", handlers, true, "")
        val presence = DiscordRichPresence()
        presence.startTimestamp = System.currentTimeMillis() / 1000
        presence.details = "Line 1"
        presence.state = "Line 2"
        presence.largeImageKey = "discord-color"
        presence.smallImageKey = "discord-white"
        lib.Discord_UpdatePresence(presence)
        Thread {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks()
                Thread.sleep(2000)
            }
        }.start();
    }

    override fun accept(user: DiscordUser) {
        println("Ready!")
    }

}