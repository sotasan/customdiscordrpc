package net.pryoscode.customdiscordrpc

import java.awt.PopupMenu

class MenuManager : PopupMenu {

    constructor() {
        add(Open())
        add(Config())
        add(GitHub())
        add(Exit())
    }

}