namespace CustomDiscordRPC.Menu;

using System.Diagnostics;

public sealed class GitHubMenuItem : MenuItem {

    public override string Name => "GitHub";

    protected override void OnClick() {
        _ = Process.Start(new ProcessStartInfo() {
            FileName = "https://github.com/sotasan/customdiscordrpc",
            UseShellExecute = true
        });
    }

}