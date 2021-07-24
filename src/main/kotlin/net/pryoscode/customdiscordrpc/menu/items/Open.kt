package net.pryoscode.customdiscordrpc

import java.awt.MenuItem
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import javafx.application.Platform
import javafx.stage.Stage
import javax.swing.SwingUtilities

class Open : MenuItem, ActionListener {

    constructor() : super("Open") {
        addActionListener(this)
    }

    override fun actionPerformed(event: ActionEvent) {
        Platform.runLater { Window().start(Stage()) }
    }

}