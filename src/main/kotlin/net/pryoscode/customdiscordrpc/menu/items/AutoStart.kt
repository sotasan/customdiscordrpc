package net.pryoscode.customdiscordrpc

import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import java.awt.CheckboxMenuItem
import net.pryoscode.customdiscordrpc.utils.getConfig

class AutoStart : CheckboxMenuItem, ActionListener {

    constructor() : super("AutoStart") {
        addActionListener(this)
    }

    override fun actionPerformed(event: ActionEvent) {
    }

}