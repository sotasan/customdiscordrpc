package net.pryoscode.customdiscordrpc

import java.awt.PopupMenu

class MenuManager : PopupMenu {

    constructor() {
        add(GitHub())
        add(Config())
        add(Exit())
    }

}