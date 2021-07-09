package net.pryoscode.customdiscordrpc

import java.awt.SystemTray
import javax.swing.JOptionPane

fun main(args : Array<String>) {
    if (!SystemTray.isSupported() || !System.getProperty("os.name").startsWith("Windows")) {
        JOptionPane.showMessageDialog(null, "Are you using Windows?", "CustomDiscordRPC", JOptionPane.ERROR_MESSAGE)
        System.exit(1)
    }
    val config = Config()
    Discord(config)
}