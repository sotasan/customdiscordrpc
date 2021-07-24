package net.pryoscode.customdiscordrpc

import org.yaml.snakeyaml.Yaml
import net.pryoscode.customdiscordrpc.utils.read
import net.pryoscode.customdiscordrpc.utils.getConfig

fun clientId(): String = get("ClientID")
fun details(): String = get("Details")
fun state(): String = get("State")
fun imagesLargeKey(): String = get("Images.LargeKey")
fun imagesLargeText(): String = get("Images.LargeText")
fun imagesSmallKey(): String = get("Images.SmallKey")
fun imagesSmallText(): String = get("Images.SmallText")

private fun get(key: String): String {
    val config: Map<String, Any> = Yaml().load(read(getConfig()))
    if (key.contains(".")) {
        val array = key.split(".")
        val category = config.get(array[0].toString()) as Map<String, Any>
        return category.get(array[1].toString()).toString()
    }
    return config.get(key).toString()
}