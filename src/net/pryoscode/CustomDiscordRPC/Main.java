package net.pryoscode.CustomDiscordRPC;

import net.pryoscode.CustomDiscordRPC.utils.SystemUtils;
import net.pryoscode.CustomDiscordRPC.utils.TrayUtils;
import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Main {

    public static TrayUtils trayUtils;
    public static final String VERSION = "v1.3";

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (Exception e) {
            errorPopup(e);
        }

        if (!SystemTray.isSupported() || !SystemUtils.isWindows()) {
            JOptionPane.showMessageDialog(null, "Are you using Windows?\nYour OS: " + SystemUtils.getOS(), "CustomDiscordRPC " + VERSION, JOptionPane.ERROR_MESSAGE);
            openURL("https://github.com/PryosCode/CustomDiscordRPC");
            System.exit(0);
        }

        new UpdateChecker();
        trayUtils = new TrayUtils();
        new Discord();
    }

    public static void errorPopup(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "CustomDiscordRPC " + VERSION, JOptionPane.ERROR_MESSAGE);
        openURL("https://github.com/PryosCode/CustomDiscordRPC/issues");
        trayUtils.removeTrayIcon();
        System.exit(0);
    }

    public static void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {}
    }

}