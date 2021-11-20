using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class Program
    {

        static void Main()
        {
            Updater.Check();
            Configuration.Load();
            SysTray.Run();
            Discord.Start();
            Application.Run();
        }

    }

}