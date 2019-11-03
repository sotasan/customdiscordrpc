package net.pryoscode.CustomDiscordRPC.menu;

import net.pryoscode.CustomDiscordRPC.menu.items.Config;
import net.pryoscode.CustomDiscordRPC.menu.items.Exit;
import net.pryoscode.CustomDiscordRPC.menu.items.Folder;
import net.pryoscode.CustomDiscordRPC.menu.items.GitHub;
import java.awt.*;

public class ItemManager extends PopupMenu {

    public ItemManager() {
        add(new GitHub());
        addSeparator();
        add(new Config());
        add(new Folder());
        add(new Exit());
    }

}