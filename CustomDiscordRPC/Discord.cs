namespace CustomDiscordRPC;

using DiscordRPC;

public static class Discord {

    private static DiscordRpcClient? _client;

    public static void Init() {
        Config config = Config.GetConfig();
        if (_client == null || _client.ApplicationID != config.ApplicationID) {
            _client?.Dispose();
            if (config.ApplicationID != null) {
                _client = new(config.ApplicationID);
                _ = _client.Initialize();
            }
        }

        List<Button> buttons = new();

        if (config.Button1Label != null && config.Button1Url != null) {
            buttons.Add(new Button() {
                Label = config.Button1Label,
                Url = config.Button1Url
            });
        }

        if (config.Button2Label != null && config.Button2Url != null) {
            buttons.Add(new Button() {
                Label = config.Button2Label,
                Url = config.Button2Url
            });
        }

        _client?.SetPresence(new() {
            Details = config.Details,
            State = config.State,
            Timestamps = config.Timestamp ? new() {
                Start = DateTime.UtcNow
            } : null,
            Assets = config.LargeImageKey != null
                    || config.LargeImageText != null
                    || config.SmallImageKey != null
                    || config.SmallImageText != null
                    ? new() {
                        LargeImageKey = config.LargeImageKey,
                        LargeImageText = config.LargeImageText,
                        SmallImageKey = config.SmallImageKey,
                        SmallImageText = config.SmallImageText,
                    } : null,
            Buttons = buttons.ToArray()
        });
    }

}