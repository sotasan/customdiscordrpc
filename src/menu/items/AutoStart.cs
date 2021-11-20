using System;
using System.Windows.Forms;
using Microsoft.Win32;

namespace CustomDiscordRPC
{

    class AutoStart : ToolStripMenuItem
    {

        public AutoStart() : base("Auto Start", null, OnClick)
        {
            var key = Registry.CurrentUser.OpenSubKey(@"SOFTWARE\Microsoft\Windows\CurrentVersion\Run", true);
            Checked = !String.IsNullOrEmpty(key.GetValue("CustomDiscordRPC", "").ToString());
            key.Close();
        }

        private static void OnClick(object sender, EventArgs args)
        {
            var item = (ToolStripMenuItem) sender;
            var key = Registry.CurrentUser.OpenSubKey(@"SOFTWARE\Microsoft\Windows\CurrentVersion\Run", true);
            if (String.IsNullOrEmpty(key.GetValue("CustomDiscordRPC", "").ToString()))
            {
                key.SetValue("CustomDiscordRPC", Application.ExecutablePath);
                item.Checked = true;
            }
            else
            {
                key.DeleteValue("CustomDiscordRPC", false);
                item.Checked = false;
            }
            key.Close();
        }

    }

}