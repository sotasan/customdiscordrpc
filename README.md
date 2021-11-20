<p align="center">
    <a href="https://github.com/PryosCode/CustomDiscordRPC/tags"><img alt="Version" src="https://img.shields.io/github/v/release/PryosCode/CustomDiscordRPC?label=Version"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/actions/workflows/build.yml"><img src="https://github.com/PryosCode/CustomDiscordRPC/actions/workflows/build.yml/badge.svg" alt="Build"></a>
    <a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE"><img src="https://img.shields.io/github/license/PryosCode/CustomDiscordRPC?label=License" alt="License"></a>
</p>

<h1><a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/assets/logo.png"><img width="30px" height="auto" alt="Logo" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/assets/logo.png"></a> CustomDiscordRPC</h1>

Customizable Discord Rich Presence Client for Windows.

## Getting Started

You have to create your own [Discord Application](https://discord.com/developers/applications) and you can upload some assets if you want to use them later. The recommended size for a image is `1024x1024`, but the minimum size is `512x512`. Make sure to copy the `Application ID`.

## Installation

You can just [download](https://github.com/PryosCode/CustomDiscordRPC/releases) the installer and directly execute `CustomDiscordRPC.exe`.

## Configuration 

If the application is running you can find a system tray at the bottom right of your screen and if you right click on it you will find an option called `Config`. This will open the config file in notepad.

The config is located at `%appdata%\PryosCode\CustomDiscordRPC\config.ini`.

## Examples

<table><tr><td>

```ini
ClientID=638034914398175233
```

</td><td>

<a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/assets/minimal.png"><img width="250px" alt="Minimal" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/assets/minimal.png"></a>

</td></tr><tr><td>

```ini
ClientID=638034914398175233
Details=Line 1
State=Line 2
LargeImageKey=discord-color
LargeImageText=CustomDiscordRPC
SmallImageKey=discord-white
SmallImageText=PryosCode
```

</td><td>

<a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/assets/normal.png"><img width="250px" alt="Normal" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/assets/normal.png"></a>

</td></tr><tr><td>

```ini
ClientID=638034914398175233
Details=Line 1
State=Line 2
LargeImageKey=discord-color
LargeImageText=CustomDiscordRPC
SmallImageKey=discord-white
SmallImageText=PryosCode
Button1Label=Website
Button1Url=https://pryoscode.net
Button2Label=GitHub
Button2Url=https://github.com/PryosCode/CustomDiscordRPC
```

</td><td>

<a href="https://github.com/PryosCode/CustomDiscordRPC/blob/master/assets/extended.png"><img width="250px" alt="Extended" src="https://github.com/PryosCode/CustomDiscordRPC/raw/master/assets/extended.png"></a>

</td></tr></table>

## License

[Apache License 2.0](https://github.com/PryosCode/CustomDiscordRPC/blob/master/LICENSE)