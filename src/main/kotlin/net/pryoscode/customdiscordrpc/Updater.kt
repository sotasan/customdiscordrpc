package net.pryoscode.customdiscordrpc

import java.util.Timer
import kotlin.concurrent.timerTask

class Updater {

    constructor() {
        Timer().scheduleAtFixedRate(timerTask {
        }, 0, (1000 * 60 * 60).toLong())
    }

}