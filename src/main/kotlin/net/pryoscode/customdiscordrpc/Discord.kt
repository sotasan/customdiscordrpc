package net.pryoscode.customdiscordrpc

import kotlin.io.println
import club.minnced.discord.rpc.DiscordRPC
import club.minnced.discord.rpc.DiscordEventHandlers
import club.minnced.discord.rpc.DiscordRichPresence
import club.minnced.discord.rpc.DiscordUser

class Discord : DiscordEventHandlers.OnReady {

    constructor(config: Config) {
        val lib = DiscordRPC.INSTANCE
        val applicationId = "638034914398175233"
        val steamId = ""
        val handlers = DiscordEventHandlers()
        handlers.ready = this
        lib.Discord_Initialize(applicationId, handlers, true, steamId)
        val presence = DiscordRichPresence()
        presence.startTimestamp = System.currentTimeMillis() / 1000
        presence.details = "Testing RPC"
        lib.Discord_UpdatePresence(presence)
        lib.Discord_RunCallbacks()
    }

    override fun accept(user: DiscordUser) {
        println("Ready!")
    }

}