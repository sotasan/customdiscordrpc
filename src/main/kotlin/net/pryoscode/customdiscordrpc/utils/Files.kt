package net.pryoscode.customdiscordrpc.utils

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileWriter
import net.pryoscode.customdiscordrpc.Configuration

fun read(file: File): String {
    return Files.readString(file.toPath(), StandardCharsets.UTF_8)
}

fun write(file: File, text: String) {
    val writer = FileWriter(file, StandardCharsets.UTF_8)
    writer.write(text)
    writer.close()
}

fun loadText(path: String): String {
    return String(loadBinary(path), StandardCharsets.UTF_8)
}

fun loadBinary(path: String): ByteArray {
    val stream = Configuration::class.java.classLoader.getResourceAsStream(path)
    val buffer = ByteArrayOutputStream()
    val data = ByteArray(stream.available())
    var i: Int
    while (stream.read(data, 0, data.size).let { i = it; it != -1 }) {
      buffer.write(data, 0, i)
    }
    return buffer.toByteArray()
}

fun getConfig(): File {
    val folder = File(System.getenv("APPDATA") + File.separator + "PryosCode" + File.separator + "CustomDiscordRPC")
    if(!folder.exists()) {
        folder.mkdirs()
    }
    val config = File(folder.getPath() + File.separator + "config.yml")
    if (!config.exists()) {
        write(config, loadText("config.yml"))
    }
    return config
}