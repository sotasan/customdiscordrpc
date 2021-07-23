package net.pryoscode.customdiscordrpc

import org.yaml.snakeyaml.Yaml
import net.pryoscode.customdiscordrpc.utils.read
import net.pryoscode.customdiscordrpc.utils.getConfig

class Configuration {

    fun clientId(): String { return get("ClientID") }
    fun details(): String { return get("Details") }
    fun state(): String { return get("State") }
    fun imagesLargeKey(): String { return get("Images.LargeKey") }
    fun imagesLargeText(): String { return get("Images.LargeText") }
    fun imagesSmallKey(): String { return get("Images.SmallKey") }
    fun imagesSmallText(): String { return get("Images.SmallText") }

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