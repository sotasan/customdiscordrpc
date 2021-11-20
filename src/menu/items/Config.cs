using System;
using System.Diagnostics;
using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class Config : ToolStripButton
    {

        public Config() : base("Config", null, OnClick) {}

        private static void OnClick(object sender, EventArgs args)
        {
            Process.Start("notepad.exe", Configuration.ConfigFile);
        }

    }

}