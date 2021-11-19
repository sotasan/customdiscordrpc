using System.Windows.Forms;

namespace CustomDiscordRPC
{

    class Program
    {

        static void Main()
        {
            new SysTray();
            new Discord();
            Application.Run();
        }

    }

}