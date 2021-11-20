using System.IO;
using System.Reflection;

namespace CustomDiscordRPC
{

    class Loader
    {

        public static Stream Get(string name)
        {
            var assembly = Assembly.GetExecutingAssembly();
            var stream = assembly.GetManifestResourceStream("CustomDiscordRPC.assets." + name);
            return stream;
        }

        public static string GetString(string name)
        {
            var reader = new StreamReader(Get(name));
            return reader.ReadToEnd();
        }

    }

}