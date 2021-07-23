package net.pryoscode.customdiscordrpc

import java.awt.SystemTray
import javax.swing.JOptionPane

fun main() {
    if (!SystemTray.isSupported() || !System.getProperty("os.name").startsWith("Windows")) {
        JOptionPane.showMessageDialog(null, "Are you using Windows?", "CustomDiscordRPC", JOptionPane.ERROR_MESSAGE)
        System.exit(1)
    }
    Updater()
    SysTray()
    val config = Configuration()
    Discord(config)
}