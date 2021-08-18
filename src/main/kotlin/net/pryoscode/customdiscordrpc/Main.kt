@file:JvmName("Main")

package net.pryoscode.customdiscordrpc

import java.awt.SystemTray
import javax.swing.JOptionPane
import javafx.application.Platform

fun main() {
    if (!SystemTray.isSupported() || !System.getProperty("os.name").lowercase().startsWith("windows")) {
        JOptionPane.showMessageDialog(null, "Are you using Windows?", "CustomDiscordRPC", JOptionPane.ERROR_MESSAGE)
        System.exit(1)
    }
    Platform.startup {}
    Updater()
    Discord(SysTray())
}