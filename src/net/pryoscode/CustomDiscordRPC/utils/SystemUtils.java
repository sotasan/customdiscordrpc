package net.pryoscode.CustomDiscordRPC.utils;

public class SystemUtils {

    public static String getOS() {
        return System.getProperty("os.name");
    }

    public static boolean isWindows() {
        return getOS().toLowerCase().contains("win");
    }

}