package net.pryoscode.customdiscordrpc

import kotlin.io.println
import club.minnced.discord.rpc.DiscordRPC
import club.minnced.discord.rpc.DiscordEventHandlers
import club.minnced.discord.rpc.DiscordRichPresence
import club.minnced.discord.rpc.DiscordUser

class Discord : DiscordEventHandlers.OnReady {

    val tray: SysTray

    constructor(tray: SysTray) {
        this.tray = tray
        val lib = DiscordRPC.INSTANCE
        val handlers = DiscordEventHandlers()
        handlers.ready = this
        lib.Discord_Initialize("638034914398175233", handlers, true, "")
        val presence = DiscordRichPresence()
        presence.startTimestamp = System.currentTimeMillis() / 1000
        presence.details = details()
        presence.state = state()
        presence.largeImageKey = imagesLargeKey()
        presence.largeImageText = imagesLargeText()
        presence.smallImageKey = imagesSmallKey()
        presence.smallImageText = imagesSmallText()
        lib.Discord_UpdatePresence(presence)
        Thread {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks()
                Thread.sleep(2000)
            }
        }.start()
    }

    override fun accept(user: DiscordUser) {
        tray.display("Successfully started the RPC Client.")
    }

}