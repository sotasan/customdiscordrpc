package net.pryoscode.CustomDiscordRPC.menu.items;

import net.pryoscode.CustomDiscordRPC.Main;
import net.pryoscode.CustomDiscordRPC.utils.FileUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Config extends MenuItem {

    public Config() {
        setLabel("Config");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("notepad.exe " + FileUtils.getConfig().getPath());
                } catch (Exception ex) {
                    Main.errorPopup(ex);
                }
            }
        });
    }

}