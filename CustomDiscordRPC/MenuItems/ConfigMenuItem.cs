namespace CustomDiscordRPC.Menu;

using System.Diagnostics;

public sealed class ConfigMenuItem : MenuItem {

    public override string Name => "Config";

    protected override void OnClick() {
        _ = Process.Start(new ProcessStartInfo() {
            FileName = "notepad",
            Arguments = Config.GetPath()
        });
    }

}