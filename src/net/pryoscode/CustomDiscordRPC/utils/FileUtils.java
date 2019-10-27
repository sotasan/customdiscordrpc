package net.pryoscode.CustomDiscordRPC.utils;

import net.pryoscode.CustomDiscordRPC.Main;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileUtils {

    public static File getFolder() {
        File folder = new File(System.getenv("APPDATA") + "/PryosCode/CustomDiscordRPC");
        if(!folder.exists())
            folder.mkdirs();
        return folder;
    }

    public static File getConfig() {
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("assets/config.json");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            File config = new File(getFolder().getPath() + "/config.json");
            if (!config.exists()) {
                OutputStream outStream = new FileOutputStream(config);
                outStream.write(buffer);
                outStream.close();
            }
            return config;
        } catch (Exception e) {
            Main.errorPopup(e);
        }
        return null;
    }

    public static String getConfigContent() {
        try {
            Scanner scanner = new Scanner(FileUtils.getConfig());
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            return content;
        } catch (Exception e) {
            Main.errorPopup(e);
        }
        return null;
    }

}