package net.pryoscode.customdiscordrpc

import java.awt.SystemTray
import java.awt.TrayIcon
import java.io.ByteArrayInputStream
import javax.imageio.ImageIO
import net.pryoscode.customdiscordrpc.utils.loadBinary

class SysTray {

    constructor() {
        val image = ImageIO.read(ByteArrayInputStream(loadBinary("logo.png")))
        val icon = TrayIcon(image, "CustomDiscordRPC")
        icon.setImageAutoSize(true)
        icon.setPopupMenu(MenuManager())
        SystemTray.getSystemTray().add(icon)
    }

}