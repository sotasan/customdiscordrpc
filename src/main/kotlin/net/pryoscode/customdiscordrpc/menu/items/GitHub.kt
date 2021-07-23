package net.pryoscode.customdiscordrpc

import java.awt.MenuItem
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import java.awt.Desktop
import java.net.URL

class GitHub : MenuItem, ActionListener {

    constructor() {
        setLabel("GitHub")
        addActionListener(this)
    }

    override fun actionPerformed(event: ActionEvent) {
        Desktop.getDesktop().browse(URL("https://github.com/PryosCode/CustomDiscordRPC").toURI())
    }

}