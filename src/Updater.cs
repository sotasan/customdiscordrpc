using System;
using System.Diagnostics;
using System.IO;
using System.Net.Http;
using System.Reflection;
using System.Windows.Forms;
using Newtonsoft.Json.Linq;

namespace CustomDiscordRPC
{

    class Updater
    {

        public static async void Check()
        {
            var client = new HttpClient();
            client.DefaultRequestHeaders.Add("User-Agent", "CustomDiscordRPC");
            var data = await client.GetStringAsync("https://api.github.com/repos/PryosCode/CustomDiscordRPC/releases");
            var item = JArray.Parse(data).First;
            var tag = item.Value<string>("tag_name");
            var build = Assembly.GetEntryAssembly().GetName().Version;
            var version = $"v{build.Major}.{build.Minor}.{build.Build}";
            if (!tag.Equals(version))
            {
                var url = item.Value<JArray>("assets").First.Value<string>("browser_download_url");
                var bytes = await client.GetByteArrayAsync(url);
                var file = Path.Combine(Path.GetTempPath(), Guid.NewGuid().ToString() + ".exe");
                File.WriteAllBytes(file, bytes);
                Process.Start(file);
                Application.Exit();
            }
        }

    }

}