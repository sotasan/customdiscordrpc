namespace CustomDiscordRPC.Menu;

using H.NotifyIcon.Core;

public abstract class MenuItem : PopupMenuItem {

    public abstract string Name { get; }

    public MenuItem() {
        Text = Name;
        Click += (_, _) => OnClick();
    }

    protected abstract void OnClick();

}