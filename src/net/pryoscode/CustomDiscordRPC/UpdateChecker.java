package net.pryoscode.CustomDiscordRPC;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class UpdateChecker {

    public UpdateChecker() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
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

                    if(!Main.VERSION.equals(tag)) {
                        JOptionPane.showMessageDialog(null, "Is this application up to date?\nNewest Version: " + tag, "CustomDiscordRPC " + Main.VERSION, JOptionPane.WARNING_MESSAGE);
                        Main.openURL("https://github.com/PryosCode/CustomDiscordRPC/releases");
                    }

                } catch (Exception e) {
                    Main.errorPopup(e);
                }
            }
        }, 0, 1000*60*60*24);
    }

}