package net.pryoscode.CustomDiscordRPC.utils;

import net.pryoscode.CustomDiscordRPC.Main;
import net.pryoscode.CustomDiscordRPC.menu.ItemManager;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class TrayUtils {

    private SystemTray systemTray;
    private TrayIcon trayIcon;

    public TrayUtils() {
        try {
            systemTray = SystemTray.getSystemTray();
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("assets/discord.png");
            Image image = ImageIO.read(inputStream);
            inputStream.close();
            trayIcon = new TrayIcon(image, "CustomDiscordRPC " + Main.VERSION);
            systemTray.add(trayIcon);
            trayIcon.setImageAutoSize(true);
            trayIcon.setPopupMenu(new ItemManager());
        } catch (Exception e) {
            Main.errorPopup(e);
        }
    }

    public SystemTray getSystemTray() {
        return systemTray;
    }

    public TrayIcon getTrayIcon() {
        return trayIcon;
    }

    public void removeTrayIcon() {
        systemTray.remove(trayIcon);
    }

}