package net.pryoscode.customdiscordrpc

import java.util.Timer
import java.util.Scanner
import java.net.URL
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import kotlin.concurrent.timerTask
import com.google.gson.Gson
import com.google.gson.JsonArray
import net.pryoscode.customdiscordrpc.utils.getJar
import net.pryoscode.customdiscordrpc.utils.getJVM

class Updater {

    constructor() {
        Timer().scheduleAtFixedRate(timerTask {
            val scanner = Scanner(URL("https://api.github.com/repos/PryosCode/CustomDiscordRPC/releases").openStream()).useDelimiter("\\A")
            if (scanner.hasNext()) {
                val response = Gson().fromJson(scanner.next(), JsonArray::class.java)
                if (response.size() > 0) {
                    val json = response.first().asJsonObject
                    if (!Updater::class.java.getPackage().implementationVersion.equals(json.get("tag_name").asString)) {
                        var url = ""
                        for (asset in json.get("assets").asJsonArray) {
                            if (asset.asJsonObject.get("content_type").asString.equals("application/java-archive")) {
                                url = asset.asJsonObject.get("browser_download_url").asString
                            }
                        }
                        if (!url.isEmpty()) {
                            val jar = getJar()
                            val cache = File(jar.parent + File.separator + jar.nameWithoutExtension + ".cache")
                            Files.copy(URL(url).openStream(), cache.toPath(), StandardCopyOption.REPLACE_EXISTING)
                            Runtime.getRuntime().exec(String.format("cmd.exe /c ping 127.0.0.1 /n 3 > nul && del \"%s\" && move \"%s\" \"%s\" && \"%s\" -jar \"%s\"", jar.path, cache.path, jar.path, getJVM().path, jar.path))
                            System.exit(0)
                        }
                    }
                }
            }
        }, 0, (1000 * 60 * 60).toLong())
    }

}