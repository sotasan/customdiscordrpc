package net.pryoscode.customdiscordrpc

class Config {

    init {
        // TODO: Create file
    }

    val clientId = get("ClientID")
    val details = get("Details")
    val state = get("State")
    val largeImage = get("LargeImage")
    val largeImageTooltip = get("LargeImageTooltip")
    val smallImage = get("SmallImage")
    val smallImageTooltip = get("SmallImageTooltip")

    fun get(key: String): String {
        return ""
    }

}