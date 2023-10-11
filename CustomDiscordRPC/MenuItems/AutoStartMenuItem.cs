namespace CustomDiscordRPC.Menu;

using Microsoft.Win32;
using System.Reflection;

public sealed class AutoStartMenuItem : MenuItem {

    private const string Key = @"SOFTWARE\Microsoft\Windows\CurrentVersion\Run";
    private readonly string? _path;

    public override string Name => "Auto Start";

    public AutoStartMenuItem() {
        _path = Assembly.GetEntryAssembly()?.Location;
        Check();
    }

    protected override void OnClick() {
        using RegistryKey? key = Registry.CurrentUser.OpenSubKey(Key, true);
        if (Checked)
            key?.DeleteValue("CustomDiscordRPC", false);
        else if (_path != null)
            key?.SetValue("CustomDiscordRPC", _path);
        Check();
    }

    private void Check() {
        using RegistryKey? key = Registry.CurrentUser.OpenSubKey(Key);
        string? value = key?.GetValue("CustomDiscordRPC")?.ToString();
        Checked = _path != null && value != null && _path == value;
    }

}