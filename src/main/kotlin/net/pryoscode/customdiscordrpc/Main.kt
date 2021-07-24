@file:JvmName("Main")

package net.pryoscode.customdiscordrpc
import java.awt.SystemTray
import javax.swing.JOptionPane
import javafx.application.Platform

fun main() {
    if (!SystemTray.isSupported() || !System.getProperty("os.name").startsWith("Windows")) {
        JOptionPane.showMessageDialog(null, "Are you using Windows?", "CustomDiscordRPC", JOptionPane.ERROR_MESSAGE)
        System.exit(1)
    }
    Updater()
    Platform.startup {}
    val tray = SysTray()
    Discord(tray)
}