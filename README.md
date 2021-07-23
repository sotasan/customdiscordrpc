<p align="center">
    <a href="https://github.com/PryosCode/CustomDiscordRPC/releases"><img src="https://img.shields.io/github/downloads/PryosCode/CustomDiscordRPC/total?label=Downloads" alt="Downloads"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/actions/workflows/build.yml"><img src="https://github.com/PryosCode/CustomDiscordRPC/actions/workflows/build.yml/badge.svg" alt="Build"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE"><img src="https://img.shields.io/github/license/PryosCode/CustomDiscordRPC?label=License" alt="License"></a>
    <a href="https://discord.gg/bF2GRHq"><img src="https://discordapp.com/api/guilds/350302354639290379/widget.png" alt="Discord"></a>
</p>


<h1><a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/src/main/resources/logo.png"><img width="30px" height="auto" alt="Logo" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/src/main/resources/logo.png"></a> CustomDiscordRPC</h1>

Customisable Discord Rich Presence Client in a JVM for Windows.

## Getting Started

You have to create your own [Discord Application](https://discord.com/developers/applications) and you can upload some assets if you want to use them later. The recommended size for a image is `1024x1024`, but the minimum size is `512x512`. Make sure to copy the `Application ID`.

## Installation

### Setup

If you want to use the installer version you can [download](https://github.com/PryosCode/CustomDiscordRPC/releases) and directly start the `CustomDiscordRPC.exe`. It will install it's own HotSpot JVM in the specified directory.

### Java

If you want to use the java version you can [download](https://github.com/PryosCode/CustomDiscordRPC/releases) the archive and install manually [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html). After that you can execute the archive with `java -jar CustomDiscordRPC.jar`.

## Configuration 

If the application is running you can find a system tray at the bottom right of your screen and if you right click on it you will find an option called `Config`. This will open the config file in notepad.

The config is located at `%appdata%/PryosCode/CustomDiscordRPC/config.yml`.

### Example

<a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/src/main/resources/config.yml"><img align="right" alt="Example" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/img/example.png"></a>

```yaml
ClientID: 638034914398175233
Details: Line 1
State: Line 2
Images:
  LargeKey: discord-color
  LargeText: CustomDiscordRPC
  SmallKey: discord-white
  SmallText: PryosCode
```

## License

[Apache License 2.0](https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE)