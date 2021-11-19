using DiscordRPC;

namespace CustomDiscordRPC
{

    class Discord
    {

        public Discord()
        {
            var client = new DiscordRpcClient("638034914398175233");
            client.Initialize();
            client.SetPresence(new RichPresence()
            {
                Details = "Line 1",
                State = "Line 2",
                Assets = new Assets()
                {
                    LargeImageKey = "discord-color",
                    LargeImageText = "CustomDiscordRPC",
                    SmallImageKey = "discord-white",
                    SmallImageText = "PryosCode"
                },
                Buttons = new Button[]
                {
                    new Button() { Label = "Website", Url = "https://pryoscode.net" },
                    new Button() { Label = "Source Code", Url = "https://github.com/PryosCode/CustomDiscordRPC" }
                }
            });
        }

    }

}