using System;
using System.IO;
using IniParser;

namespace CustomDiscordRPC
{

    class Configuration
    {

        public static string ConfigDirectory;
        public static string ConfigFile;

        public static string ClientID;
        public static string Details;
        public static string State;

        public static string LargeImageKey;
        public static string LargeImageText;

        public static string SmallImageKey;
        public static string SmallImageText;

        public static string Button1Label;
        public static string Button1Url;

        public static string Button2Label;
        public static string Button2Url;

        public static void Load()
        {
            ConfigDirectory = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData), "PryosCode", "CustomDiscordRPC");
            ConfigFile = Path.Combine(ConfigDirectory, "config.ini");
            if (!Directory.Exists(ConfigDirectory)) Directory.CreateDirectory(ConfigDirectory);
            if (!File.Exists(ConfigFile)) File.WriteAllText(ConfigFile, Loader.GetString("config.ini"));
            var parser = new FileIniDataParser();
            var data = parser.ReadFile(ConfigFile);

            ClientID = data["Config"]["ClientID"];
            Details = data["Config"]["Details"];
            State = data["Config"]["State"];
            LargeImageKey = data["Config"]["LargeImageKey"];
            LargeImageText = data["Config"]["LargeImageText"];
            SmallImageKey = data["Config"]["SmallImageKey"];
            SmallImageText = data["Config"]["SmallImageText"];
            Button1Label = data["Config"]["Button1Label"];
            Button1Url = data["Config"]["Button1Url"];
            Button2Label = data["Config"]["Button2Label"];
            Button2Url = data["Config"]["Button2Url"];
        }

    }

}