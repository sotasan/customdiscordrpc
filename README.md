<p align="center">
    <a href="https://github.com/PryosCode/CustomDiscordRPC/releases"><img src="https://img.shields.io/github/downloads/PryosCode/CustomDiscordRPC/total?label=Downloads" alt="Downloads"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE"><img src="https://img.shields.io/github/license/PryosCode/CustomDiscordRPC?label=License" alt="License"></a>
    <a href="https://discord.gg/bF2GRHq"><img src="https://discordapp.com/api/guilds/350302354639290379/widget.png" alt="Discord"></a>
</p>

# CustomDiscordRPC

<a href="https://github.com/PryosCode/CustomDiscordRPC/releases"><img align="right" src="images/banner.gif"></a>

Customisable Discord Rich Presence Client written in Java for Windows.

1. [Getting Started](#getting-started)
2. [Installation](#installation)
3. [Configuration](#configuration)
4. [Dependencies](#dependencies)
5. [License](#license)

## Getting Started

You have to create your own [Discord Application](https://discordapp.com/developers/applications) and you can upload some assets if you want to use them later. The recommended size for a image is `1024x1024`, but the minimum size is `512x512`.

## Installation

The latest version can be found on [GitHub](https://github.com/PryosCode/CustomDiscordRPC/releases).

### Setup

If you want to use the setup version you can [download](https://github.com/PryosCode/CustomDiscordRPC/releases) and directly start the `Setup-CustomDiscordRPC.exe`. It will install it's own Java SE Runtime Environment in the root directory.

### Portable

If you want to use the portable version you can [download](https://github.com/PryosCode/CustomDiscordRPC/releases) it, but you will have to extract the `Portable-CustomDiscordRPC.zip`. In the file is the executable and the Java SE Runtime Environment included.

## Configuration

If the application is running you can find a system tray and if you click on it you will find an option called `Config`.
This will open the `config.json` and you will have to set the `ClientID`.
Otherwise you can press `Windows` + `R` and enter the command `notepad.exe %appdata%\PryosCode\CustomDiscordRPC\config.json`.
In this file you can configure every perspective of this application.

## Dependencies

If you want to expand this application, you will have to install:

* [JTattoo](http://www.jtattoo.net/)
* [Gson](https://github.com/google/gson)
* [Java-Discord-RPC](https://github.com/MinnDevelopment/java-discord-rpc)

### Maven

```xml
<!-- https://mvnrepository.com/artifact/com.jtattoo/JTattoo -->
<dependency>
    <groupId>com.jtattoo</groupId>
    <artifactId>JTattoo</artifactId>
    <version>1.6.12</version>
</dependency>

<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>

<!-- https://mvnrepository.com/artifact/club.minnced/java-discord-rpc -->
<dependency>
    <groupId>club.minnced</groupId>
    <artifactId>java-discord-rpc</artifactId>
    <version>2.0.1</version>
</dependency>
```

## License

This project is licensed under the GNU Affero General Public License v3.0 - see the [LICENSE.md](https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE) file for details.
