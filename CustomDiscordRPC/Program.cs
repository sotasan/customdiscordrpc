using CustomDiscordRPC;
using CustomDiscordRPC.Extensions;
using CustomDiscordRPC.Menu;
using H.NotifyIcon.Core;
using System.Drawing;
using System.Reflection;

bool createdNew;
using Mutex mutex = new(true, "{E519EEC6-80F9-4D69-B253-423F9421ECAE}", out createdNew);
if (!createdNew)
    return;

string path = Config.GetPath();
string file = Path.GetFileName(path);
if (!File.Exists(path)) {
    using FileStream fileStream = new(path, FileMode.CreateNew, FileAccess.Write);
    using Stream stream = Assembly.GetExecutingAssembly().GetAsset(file);
    stream.CopyTo(fileStream);
}

FileSystemWatcher watcher = new(Path.GetDirectoryName(path)!, file) {
    EnableRaisingEvents = true
};
watcher.Changed += (_, args) => Discord.Init();

new TrayIconWithContextMenu() {
    ToolTip = "CustomDiscordRPC",
    Icon = new Icon(Assembly.GetExecutingAssembly().GetAsset("Icon.ico")!).Handle,
    ContextMenu = new() {
        Items = {
            new AutoStartMenuItem(),
            new ConfigMenuItem(),
            new GitHubMenuItem(),
            new PopupMenuSeparator(),
            new ExitMenuItem()
        }
    }
}.Create();

Discord.Init();

await Task.Delay(Timeout.Infinite);
