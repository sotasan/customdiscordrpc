package net.pryoscode.CustomDiscordRPC;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.pryoscode.CustomDiscordRPC.utils.SystemUtils;
import net.pryoscode.CustomDiscordRPC.utils.TrayUtils;
import javax.swing.*;
import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static TrayUtils trayUtils;
    public static final String VERSION = "v1.2";

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

        checkForUpdates();
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

    public static void checkForUpdates() {
        try {
            URL url = new URL("https://api.github.com/repos/PryosCode/CustomDiscordRPC/releases");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\A");
            String content = scanner.next();
            scanner.close();

            connection.disconnect();

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(content, JsonArray.class);
            if(jsonArray.size() == 0)
                return;

            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            String tag = jsonObject.get("tag_name").getAsString();

            if(!VERSION.equals(tag)) {
                JOptionPane.showMessageDialog(null, "Is this application up to date?\nNewest Version: " + tag, "CustomDiscordRPC " + VERSION, JOptionPane.WARNING_MESSAGE);
                Main.openURL("https://github.com/PryosCode/CustomDiscordRPC/releases");
            }

        } catch (Exception e) {
            errorPopup(e);
        }
    }

}