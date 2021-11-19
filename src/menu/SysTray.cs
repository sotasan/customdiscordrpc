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
            icon.ContextMenuStrip.Items.Add(new AutoStart());
            icon.ContextMenuStrip.Items.Add(new Config());
            icon.ContextMenuStrip.Items.Add(new GitHub());
            icon.ContextMenuStrip.Items.Add(new Exit());
            icon.Visible = true;
        }

    }

}