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
        File config = new File(getFolder().getPath() + "/config.json");
        if (!config.exists()) {
            write(config, readLocalFile("assets/config.json"));
        }
        return config;
    }

    public static byte[] readLocalFile(String location) {
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(location);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            return buffer;
        } catch (Exception e) {
            Main.errorPopup(e);
        }
        return null;
    }

    public static String read(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            return content;
        } catch (Exception e) {
            Main.errorPopup(e);
        }
        return null;
    }

    public static void write(File file, byte[] buffer) {
        try {
            OutputStream outStream = new FileOutputStream(file);
            outStream.write(buffer);
            outStream.close();
        } catch (Exception e) {
            Main.errorPopup(e);
        }
    }

}