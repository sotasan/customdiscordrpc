package net.pryoscode.customdiscordrpc

import java.awt.SystemTray
import java.awt.TrayIcon
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO
import net.pryoscode.customdiscordrpc.utils.loadBinary

class SysTray {

    private val icon: TrayIcon

    constructor() {
        val image = ImageIO.read(ByteArrayInputStream(loadBinary("logo.png")))
        icon = TrayIcon(image, "CustomDiscordRPC")
        icon.setImageAutoSize(true)
        icon.setPopupMenu(MenuManager())
        SystemTray.getSystemTray().add(icon)
    }

    fun display(text: String) {
        icon.displayMessage("CustomDiscordRPC", text, TrayIcon.MessageType.INFO)
    }

}