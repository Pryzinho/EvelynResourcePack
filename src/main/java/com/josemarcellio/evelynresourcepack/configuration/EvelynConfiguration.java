package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.Objects;

public class EvelynConfiguration {
    final FileConfiguration file = Main.getPlugins().getConfig();


    public void send(Player p) {
        Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> p.setResourcePack ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.URL-Link" ) ) ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
    }

    public void main(Player p) {
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "              &6&lEvelynResourcePack" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', " &e/pack - Manual Download ResourcePack!" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
    }


    public void bypass(Player p) {
        Bukkit.getScheduler().runTaskLater(Main.getPlugins(), () -> {
        new EvelynMessages().bypassmessage ( p );
        new EvelynDiscord().bypassdiscord ( p );
        new EvelynSound().bypasssound ( p );
        new EvelynTitle().bypasstitle ( p );
        new EvelynActionbar().bypassbar ( p );
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ));
    }


    public void declined(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Kick.Declined.Enable" )) {
            p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Kick.Declined.Messages" ) ) ) );
        }
    }

    public void failed(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Kick.Failed.Enable" )) {
            p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Kick.Failed.Messages" ) ) ) );
        }
    }

    public void acceptdelay(Player p) {
        Bukkit.getScheduler().runTaskLater(Main.getPlugins(), () -> {
            new EvelynMessages().accept ( p );
            new EvelynTitle().accepttitle ( p );
            new EvelynSound().acceptsound ( p );
            new EvelynActionbar().acceptbar ( p );
            new EvelynDiscord().acceptdiscord(p);
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ));
    }

    public void successdelay(Player p) {
        Bukkit.getScheduler().runTaskLater(Main.getPlugins(), () -> {
            new EvelynMessages().success ( p );
            new EvelynTitle().successtitle ( p );
            new EvelynSound().successsound ( p );
            new EvelynActionbar().successbar ( p );
            new EvelynDiscord().successdiscord(p);
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ));
    }

    public void declineddelay(Player p) {
        Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> {
            declined ( p );
            new EvelynDiscord().declineddiscord ( p );
            new EvelynMessages().declined2 ( p );
            new EvelynTitle().declinedtitle ( p );
            new EvelynSound().declinedsound ( p );
            new EvelynActionbar().declinedbar ( p );
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
    }

    public void faileddelay(Player p) {
        Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> {
            new EvelynMessages().failed2 ( p );
            failed ( p );
            new EvelynTitle().failedtitle ( p );
            new EvelynSound().failedsound ( p );
            new EvelynActionbar().failedbar ( p );
            new EvelynDiscord().faileddiscord ( p );
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
    }

    public void joinbypass(Player p) {
        if (p.hasPermission ( "evelyn.bypass" )) {
            bypass( p );
        } else {
           send ( p );
        }
    }

}
