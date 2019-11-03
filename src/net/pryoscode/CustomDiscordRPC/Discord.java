package net.pryoscode.CustomDiscordRPC;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.pryoscode.CustomDiscordRPC.utils.FileUtils;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Discord {

    private long startTimestamp;
    private String clientID = "";

    public Discord() {
        DiscordRPC lib = DiscordRPC.INSTANCE;
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> Main.trayUtils.getTrayIcon().displayMessage("CustomDiscordRPC " + Main.VERSION, "Successfully started the RPC Client.", TrayIcon.MessageType.INFO);
        startTimestamp = System.currentTimeMillis() / 1000;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Gson gson = new Gson();
                    JsonObject jsonObject = gson.fromJson(FileUtils.read(FileUtils.getConfig()), JsonObject.class);

                    if (!clientID.equals(jsonObject.get("ClientID").getAsString())) {
                        clientID = jsonObject.get("ClientID").getAsString();
                        lib.Discord_Shutdown();
                        lib.Discord_Initialize(clientID, handlers, true, "");
                    }

                    DiscordRichPresence richPresence = new DiscordRichPresence();
                    richPresence.startTimestamp = startTimestamp;

                    richPresence.state = jsonObject.get("State").getAsString();
                    richPresence.details = jsonObject.get("Details").getAsString();

                    JsonObject images = jsonObject.get("Images").getAsJsonObject();
                    richPresence.largeImageKey = images.get("LargeImage").getAsString();
                    richPresence.largeImageText = images.get("LargeImageTooltip").getAsString();
                    richPresence.smallImageKey = images.get("SmallImage").getAsString();
                    richPresence.smallImageText = images.get("SmallImageTooltip").getAsString();

                    lib.Discord_UpdatePresence(richPresence);
                    lib.Discord_RunCallbacks();
                } catch (Exception e) {
                    Main.errorPopup(e);
                }
            }
        }, 0, 2000);
    }

}