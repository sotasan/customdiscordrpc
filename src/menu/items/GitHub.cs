using System;
using System.Diagnostics;
using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class GitHub : ToolStripButton
    {

        public GitHub() : base("GitHub", null, OnClick) {}

        private static void OnClick(object sender, EventArgs args)
        {
            var process = new Process();
            process.StartInfo = new ProcessStartInfo("https://github.com/PryosCode/CustomDiscordRPC");
            process.StartInfo.UseShellExecute = true;
            process.Start();
        }

    }

}