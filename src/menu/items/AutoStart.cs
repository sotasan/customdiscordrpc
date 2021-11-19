using System;
using System.Windows.Forms;
using Microsoft.Win32;

namespace CustomDiscordRPC
{

    class AutoStart : ToolStripButton
    {

        public AutoStart() : base("Auto Start", null, OnClick) {}

        private static void OnClick(object sender, EventArgs args)
        {
            var key = Registry.CurrentUser.OpenSubKey(@"Software\Microsoft\Windows\CurrentVersion\Run");
            key.Close();
        }

    }

}