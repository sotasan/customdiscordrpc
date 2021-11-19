using System;
using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class SysTray
    {

        public SysTray()
        {
            NotifyIcon icon = new NotifyIcon();
            icon.Text = "CustomDiscordRPC";
            icon.Icon = new System.Drawing.Icon("assets/logo.ico");
            icon.ContextMenuStrip = new ContextMenuStrip();
            icon.ContextMenuStrip.Items.Add("GitHub");
            icon.ContextMenuStrip.Items.Add(new ToolStripSeparator());
            icon.ContextMenuStrip.Items.Add("Exit", null, OnExitClick);

            icon.Visible = true;
        }

        private void OnExitClick(object subject, EventArgs args)
        {
            Application.Exit();
        }

    }

}