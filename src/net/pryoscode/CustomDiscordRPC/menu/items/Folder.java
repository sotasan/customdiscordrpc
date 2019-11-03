package net.pryoscode.CustomDiscordRPC.menu.items;

import net.pryoscode.CustomDiscordRPC.Main;
import net.pryoscode.CustomDiscordRPC.utils.FileUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Folder extends MenuItem {

    public Folder() {
        setLabel("Folder");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(FileUtils.getFolder());
                } catch (Exception ex) {
                    Main.errorPopup(ex);
                }
            }
        });
    }

}