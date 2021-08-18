package net.pryoscode.customdiscordrpc

import java.awt.PopupMenu

class MenuManager : PopupMenu {

    constructor() {
        add(Config())
        add(AutoStart())
        add(GitHub())
        add(Exit())
    }

}