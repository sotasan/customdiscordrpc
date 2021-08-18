package net.pryoscode.customdiscordrpc

import java.util.Timer
import java.util.Scanner
import java.net.URL
import java.io.File
import java.io.ByteArrayInputStream
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import kotlin.concurrent.timerTask
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.nativejavafx.taskbar.TaskbarProgressbar
import net.pryoscode.customdiscordrpc.utils.getJar
import net.pryoscode.customdiscordrpc.utils.getJVM
import net.pryoscode.customdiscordrpc.utils.loadBinary
import javafx.application.Application
import javafx.application.Platform
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.fxml.FXMLLoader
import javafx.fxml.FXML
import javafx.scene.image.Image
import javafx.scene.control.ProgressBar

class Updater : Application {

    @FXML
    private lateinit var bar: ProgressBar
    private lateinit var stage: Stage

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
                            val cache = getJar().parent + File.separator + getJar().nameWithoutExtension + ".cache"
                            Runtime.getRuntime().exec(String.format("cmd /c attrib -H \"%s\"", cache))
                            Thread.sleep(3000)
                            Platform.runLater { start(Stage()) }
                            val out = BufferedOutputStream(FileOutputStream(cache), 1024)
                            Runtime.getRuntime().exec(String.format("cmd /c attrib +H \"%s\"", cache))
                            val connection = URL(url).openConnection()
                            val stream = BufferedInputStream(connection.inputStream)
                            val data = ByteArray(1024)
                            var downloaded = 0
                            var i: Int
                            while (stream.read(data, 0, data.size).let { i = it; it != -1 }) {
                                downloaded += i
                                val progress = downloaded.toDouble() / connection.contentLength.toDouble()
                                bar.progress = progress
                                Platform.runLater { TaskbarProgressbar.showCustomProgress(stage, progress, TaskbarProgressbar.Type.NORMAL) }
                                out.write(data, 0, i)
                            }
                            out.close()
                            stream.close()
                            Runtime.getRuntime().exec(String.format("cmd /c ping 127.0.0.1 /n 3 > nul && del \"%s\" && attrib -H \"%s\" && move \"%s\" \"%s\" && \"%s\" -jar \"%s\"", getJar().path, cache, cache, getJar().path, getJVM().path, getJar().path))
                            System.exit(0)
                        }
                    }
                }
            }
        }, 0, (1000 * 60 * 60).toLong())
    }

    override fun start(stage: Stage) {
        this.stage = stage
        stage.title = "CustomDiscordRPC"
        stage.setResizable(false)
        stage.icons.add(Image(ByteArrayInputStream(loadBinary("logo.png"))))
        val loader = FXMLLoader(Updater::class.java.classLoader.getResource("updater.fxml"))
        loader.setController(this)
        stage.setScene(Scene(loader.load(), 400.0, 50.0))
        stage.setOnCloseRequest {
            stage.hide()
            System.exit(0)
        }
        stage.show()
    }

}