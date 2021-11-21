using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class Program
    {

        static void Main()
        {
            Updater.Check();
            Configuration.Init();
            SysTray.Run();
            Discord.Update();
            Application.Run();
        }

    }

}