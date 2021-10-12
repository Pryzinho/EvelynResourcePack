package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class EvelynMessages {
    final FileConfiguration file = Main.getPlugins().getConfig();
    List<String> accepts = file.getStringList ( "EvelynResourcePack.Messages.Accept.Messages" );
    List<String> successs = file.getStringList ( "EvelynResourcePack.Messages.Success.Messages" );
    List<String> declineds = file.getStringList ( "EvelynResourcePack.Messages.Declined.Messages" );
    List<String> faileds = file.getStringList ( "EvelynResourcePack.Messages.Failed.Messages" );
    List<String> bypasss = file.getStringList ( "EvelynResourcePack.Messages.Bypass.Messages" );

    public void accept(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Accept.Enable" )) {
            for (String accept : accepts) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', accept ) );
            }
        }
    }

    public void declined2(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Declined.Enable" )) {
            for (String declined : declineds) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', declined ) );
            }
        }
    }

    public void failed2(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Failed.Enable" )) {
            for (String failed : faileds) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', failed ) );
            }
        }
    }

    public void bypassmessage (Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Bypass.Enable" )) {
            for (String bypass : bypasss) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', bypass ) );
            }
        }
    }

    public void success(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Success.Enable" )) {
            for (String success : successs) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', success ) );
            }
        }
    }
}
