using System;
using System.Collections.Generic;
using DiscordRPC;

namespace CustomDiscordRPC
{

    class Discord
    {

        private static DiscordRpcClient Client;

        public static void Update()
        {
            if (Client == null || !Client.ApplicationID.Equals(Configuration.ClientID))
            {
                if (Client != null) Client.Dispose();
                Client = new DiscordRpcClient(Configuration.ClientID);
                Client.Initialize();
            }

            var presence = new RichPresence();
            if (!String.IsNullOrEmpty(Configuration.Details)) presence.Details = Configuration.Details;
            if (!String.IsNullOrEmpty(Configuration.State)) presence.State = Configuration.State;
            Boolean.TryParse(Configuration.Timestamp, out bool timestamp);
            if (timestamp) presence.Timestamps = new Timestamps() { Start = DateTime.UtcNow };
            if (!String.IsNullOrEmpty(Configuration.LargeImageKey) ||
                !String.IsNullOrEmpty(Configuration.LargeImageText) ||
                !String.IsNullOrEmpty(Configuration.SmallImageKey) ||
                !String.IsNullOrEmpty(Configuration.SmallImageText))
            {
                var assets = new Assets();
                assets.LargeImageKey = Configuration.LargeImageKey;
                assets.LargeImageText = Configuration.LargeImageText;
                assets.SmallImageKey = Configuration.SmallImageKey;
                assets.SmallImageText = Configuration.SmallImageText;
                presence.Assets = assets;
            }
            var buttons = new List<Button>();
            if (!String.IsNullOrEmpty(Configuration.Button1Label) &&
                !String.IsNullOrEmpty(Configuration.Button1Url))
                    buttons.Add(new Button() { Label = Configuration.Button1Label, Url = Configuration.Button1Url });
            if (!String.IsNullOrEmpty(Configuration.Button2Label) &&
                !String.IsNullOrEmpty(Configuration.Button2Url))
                buttons.Add(new Button() { Label = Configuration.Button2Label, Url = Configuration.Button2Url });
            presence.Buttons = buttons.ToArray();
            Client.SetPresence(presence);
        }

    }

}