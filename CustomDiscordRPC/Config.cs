namespace CustomDiscordRPC;

using CustomDiscordRPC.Extensions;
using IniParser;
using IniParser.Model;
using System.Reflection;

public sealed class Config {

    public string? ApplicationID { get; set; }
    public string? Details { get; set; }
    public string? State { get; set; }
    public bool Timestamp { get; set; }
    public string? LargeImageKey { get; set; }
    public string? LargeImageText { get; set; }
    public string? SmallImageKey { get; set; }
    public string? SmallImageText { get; set; }
    public string? Button1Label { get; set; }
    public string? Button1Url { get; set; }
    public string? Button2Label { get; set; }
    public string? Button2Url { get; set; }

    public static Config GetConfig() {
        Config config = new();
        IniData data = new FileIniDataParser().ReadFile(GetPath());
        foreach (PropertyInfo property in typeof(Config).GetProperties()) {
            string? value = data.GetKey(property.Name);
            if (!string.IsNullOrEmpty(value))
                property.SetValue(config, Convert.ChangeType(value, property.PropertyType));
        }
        return config;
    }

    public static string GetPath() {
        return Path.Combine(Assembly.GetExecutingAssembly().GetDirectory(), $"{nameof(Config)}.ini");
    }

}