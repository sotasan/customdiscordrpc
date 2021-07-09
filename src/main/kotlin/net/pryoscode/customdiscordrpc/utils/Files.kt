package net.pryoscode.customdiscordrpc.helpers

import java.nio.charset.StandardCharsets
import java.io.ByteArrayOutputStream

fun readText(file: String): String {
    return String(readBinary(file), StandardCharsets.UTF_8)
}

fun readBinary(file: String): ByteArray {
    return ByteArray(0)
}

fun loadText(path: String): String {
    return String(loadBinary(path), StandardCharsets.UTF_8)
}

fun loadBinary(path: String): ByteArray {
    return ByteArray(0)
}