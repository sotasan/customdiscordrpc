namespace CustomDiscordRPC.Menu;

using System;

public sealed class ExitMenuItem : MenuItem {

    public override string Name => "Exit";

    protected override void OnClick() {
        Environment.Exit(0);
    }

}