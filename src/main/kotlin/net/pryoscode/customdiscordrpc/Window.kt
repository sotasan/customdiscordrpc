package net.pryoscode.customdiscordrpc

import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.layout.StackPane

class Window : Application {

    constructor() {}

    override fun start(stage: Stage) {
        stage.title = "CustomDiscordRPC"
        val root = StackPane()
        stage.setScene(Scene(root, 500.0, 500.0))
        stage.show()
    }

}