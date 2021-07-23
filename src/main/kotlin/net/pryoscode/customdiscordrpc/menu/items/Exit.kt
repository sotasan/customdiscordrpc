package net.pryoscode.customdiscordrpc

import java.awt.MenuItem
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

class Exit : MenuItem, ActionListener {

    constructor() {
        setLabel("Exit")
        addActionListener(this)
    }

    override fun actionPerformed(event: ActionEvent) {
        System.exit(0)
    }

}