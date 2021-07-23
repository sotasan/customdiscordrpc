package net.pryoscode.customdiscordrpc

import java.util.Timer
import java.util.Scanner
import java.net.URL
import kotlin.concurrent.timerTask
import com.google.gson.Gson
import com.google.gson.JsonArray

class Updater {

    constructor() {
        Timer().scheduleAtFixedRate(timerTask {
            val scanner = Scanner(URL("https://api.github.com/repos/PryosCode/CustomDiscordRPC/releases").openStream()).useDelimiter("\\A")
            if (scanner.hasNext()) {
                val response = Gson().fromJson(scanner.next(), JsonArray::class.java)
                if (response.size() > 0) {
                    val json = response.first().asJsonObject
                    if (!Updater::class.java.getPackage().getImplementationVersion().equals(json.get("tag_name").asString)) {
                        println("TODO: Auto Update")
                    }
                }
            }
        }, 0, (1000 * 60 * 60).toLong())
    }

}