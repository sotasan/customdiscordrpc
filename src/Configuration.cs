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
        public static string Timestamp;

        public static string LargeImageKey;
        public static string LargeImageText;

        public static string SmallImageKey;
        public static string SmallImageText;

        public static string Button1Label;
        public static string Button1Url;

        public static string Button2Label;
        public static string Button2Url;

        public static void Init()
        {
            ConfigDirectory = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData), "PryosCode", "CustomDiscordRPC");
            ConfigFile = Path.Combine(ConfigDirectory, "config.ini");
            Load();
            var watcher = new FileSystemWatcher(ConfigDirectory);
            watcher.Changed += OnChanged;
            watcher.EnableRaisingEvents = true;
        }

        private static void Load()
        {
            if (!Directory.Exists(ConfigDirectory)) Directory.CreateDirectory(ConfigDirectory);
            if (!File.Exists(ConfigFile)) File.WriteAllText(ConfigFile, Loader.GetString("config.ini"));
            var data = new FileIniDataParser().ReadFile(ConfigFile);

            ClientID = data.GetKey("ClientID");
            Details = data.GetKey("Details");
            State = data.GetKey("State");
            Timestamp = data.GetKey("Timestamp");
            LargeImageKey = data.GetKey("LargeImageKey");
            LargeImageText = data.GetKey("LargeImageText");
            SmallImageKey = data.GetKey("SmallImageKey");
            SmallImageText = data.GetKey("SmallImageText");
            Button1Label = data.GetKey("Button1Label");
            Button1Url = data.GetKey("Button1Url");
            Button2Label = data.GetKey("Button2Label");
            Button2Url = data.GetKey("Button2Url");
        }

        public static void OnChanged(object sender, EventArgs args)
        {
            Load();
            Discord.Update();
            SysTray.Send("The config was reloaded.");
        }

    }

}