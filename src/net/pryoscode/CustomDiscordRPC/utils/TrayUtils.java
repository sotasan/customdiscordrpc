package net.pryoscode.CustomDiscordRPC.utils;

import net.pryoscode.CustomDiscordRPC.Main;
import net.pryoscode.CustomDiscordRPC.menu.ItemManager;
import javax.imageio.ImageIO;
import java.awt.*;

public class TrayUtils {

    private SystemTray systemTray;
    private TrayIcon trayIcon;

    public TrayUtils() {
        try {
            systemTray = SystemTray.getSystemTray();
            Image image = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("assets/discord.png"));
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