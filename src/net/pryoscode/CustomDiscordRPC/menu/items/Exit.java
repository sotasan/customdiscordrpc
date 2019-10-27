package net.pryoscode.CustomDiscordRPC.menu.items;

import net.pryoscode.CustomDiscordRPC.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit extends MenuItem {

    public Exit() {
        setLabel("Exit");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.trayUtils.removeTrayIcon();
                System.exit(0);
            }
        });
    }

}