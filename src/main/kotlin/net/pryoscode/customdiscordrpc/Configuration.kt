package net.pryoscode.customdiscordrpc

import org.yaml.snakeyaml.Yaml
import net.pryoscode.customdiscordrpc.utils.read
import net.pryoscode.customdiscordrpc.utils.getConfig

class Configuration {

    fun clientId(): String { return get("ClientID") }
    fun details(): String { return get("Details") }
    fun state(): String { return get("State") }
    fun largeImage(): String { return get("Images.LargeImage") }
    fun largeImageTooltip(): String { return get("Images.LargeImageTooltip") }
    fun smallImage(): String { return get("Images.SmallImage") }
    fun smallImageTooltip(): String { return get("Images.SmallImageTooltip") }

    fun get(key: String): String {
        val config: Map<String, Any> = Yaml().load(read(getConfig()))
        if (key.contains(".")) {
            val array = key.split(".")
            val category = config.get(array[0].toString()) as Map<String, Any>
            return category.get(array[1].toString()).toString()
        }
        return config.get(key).toString()
    }

}