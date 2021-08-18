package net.pryoscode.customdiscordrpc

import kotlin.io.println
import club.minnced.discord.rpc.DiscordRPC
import club.minnced.discord.rpc.DiscordEventHandlers
import club.minnced.discord.rpc.DiscordRichPresence
import club.minnced.discord.rpc.DiscordUser

class Discord : DiscordEventHandlers.OnReady {

    private val tray: SysTray

    constructor(tray: SysTray) {
        this.tray = tray
        val lib = DiscordRPC.INSTANCE
        val handlers = DiscordEventHandlers()
        handlers.ready = this
        val presence = DiscordRichPresence()
        presence.startTimestamp = System.currentTimeMillis() / 1000
        var clientId = ""
        Thread {
            while (!Thread.currentThread().isInterrupted()) {
                if (!clientId().equals(clientId)) {
                    clientId = clientId()
                    lib.Discord_Shutdown()
                    lib.Discord_Initialize(clientId, handlers, true, "")
                }
                presence.details = details()
                presence.state = state()
                presence.largeImageKey = imagesLargeKey()
                presence.largeImageText = imagesLargeText()
                presence.smallImageKey = imagesSmallKey()
                presence.smallImageText = imagesSmallText()
                lib.Discord_UpdatePresence(presence)
                lib.Discord_RunCallbacks()
                Thread.sleep(2000)
            }
        }.start()
    }

    override fun accept(user: DiscordUser) {
        tray.display("Successfully connected to Discord.")
    }

}