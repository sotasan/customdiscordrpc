package net.pryoscode.CustomDiscordRPC.menu.items;

import net.pryoscode.CustomDiscordRPC.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GitHub extends MenuItem {

    public GitHub() {
        setLabel("GitHub");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.openURL("https://github.com/PryosCode/CustomDiscordRPC");
            }
        });
    }

}