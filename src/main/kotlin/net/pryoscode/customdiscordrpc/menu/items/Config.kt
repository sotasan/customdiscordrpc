package net.pryoscode.customdiscordrpc

import java.awt.MenuItem
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import net.pryoscode.customdiscordrpc.utils.getConfig

class Config : MenuItem, ActionListener {

    constructor() : super("Config") {
        addActionListener(this)
    }

    override fun actionPerformed(event: ActionEvent) {
        Runtime.getRuntime().exec("notepad.exe " + getConfig().toPath())
    }

}