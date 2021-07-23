<p align="center">
    <a href="https://github.com/PryosCode/CustomDiscordRPC/releases"><img src="https://img.shields.io/github/downloads/PryosCode/CustomDiscordRPC/total?label=Downloads" alt="Downloads"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/actions/workflows/build.yml"><img src="https://github.com/PryosCode/CustomDiscordRPC/actions/workflows/build.yml/badge.svg" alt="Build"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE"><img src="https://img.shields.io/github/license/PryosCode/CustomDiscordRPC?label=License" alt="License"></a>
    <a href="https://discord.gg/bF2GRHq"><img src="https://discordapp.com/api/guilds/350302354639290379/widget.png" alt="Discord"></a>
</p>


<h1><a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/src/main/resources/logo.png"><img width="30px" height="auto" alt="Logo" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/src/main/resources/logo.png"></a> CustomDiscordRPC</h1>

Customisable Discord Rich Presence Client in a JVM for Windows.

## Getting Started

You have to create your own [Discord Application](https://discord.com/developers/applications) and you can upload some assets if you want to use them later. The recommended size for a image is `1024x1024`, but the minimum size is `512x512`.

## Installation

### Setup

If you want to use the installer version you can [download](https://github.com/PryosCode/CustomDiscordRPC/releases) and directly start the `CustomDiscordRPC-Setup.exe`.

### Binary

If you want to use the binary version you can [download](https://github.com/PryosCode/CustomDiscordRPC/releases) it and execute the `CustomDiscordRPC.exe`.

## Configuration

If the application is running you can find a system tray and if you click on it you will find an option called `Config`.
This will open the `config.yml` and you will have to set the `ClientID`.
Otherwise you can press `Windows` + `R` and enter the command `notepad.exe %appdata%\PryosCode\CustomDiscordRPC\config.yml`.
In this file you can configure every perspective of this application.

### Example

<a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/src/main/resources/config.yml"><img align="right" alt="Example" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/img/example.png"></a>

```yaml
ClientID: 638034914398175233
Details: Line 1
State: Line 2
Images:
  LargeImage: discord-color
  LargeImageTooltip: CustomDiscordRPC
  SmallImage: discord-white
  SmallImageTooltip: PryosCode
```

## License

[Apache License 2.0](https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE)