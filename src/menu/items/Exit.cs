using System;
using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class Exit : ToolStripMenuItem
    {

        public Exit() : base("Exit", null, OnClick) {}

        private static void OnClick(object sender, EventArgs args)
        {
            Application.Exit();
        }

    }

}