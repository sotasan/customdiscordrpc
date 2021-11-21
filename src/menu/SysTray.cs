using System;
using System.Drawing;
using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class SysTray
    {

        private static NotifyIcon Icon;

        public static void Run()
        {
            Application.ApplicationExit += OnExit;
            Icon = new NotifyIcon();
            Icon.Text = "CustomDiscordRPC";
            Icon.Icon = new Icon(Loader.Get("logo.ico"));
            Icon.ContextMenuStrip = new ContextMenuStrip();
            Icon.ContextMenuStrip.Items.Add(new AutoStart());
            Icon.ContextMenuStrip.Items.Add(new Config());
            Icon.ContextMenuStrip.Items.Add(new GitHub());
            Icon.ContextMenuStrip.Items.Add(new Exit());
            Icon.Visible = true;
        }

        private static void OnExit(object sender, EventArgs args)
        {
            Icon.Dispose();
        }

        public static void Send(string message)
        {
            Icon.ShowBalloonTip(0, "CustomDiscordRPC", message, ToolTipIcon.Info);
        }

    }

}