package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class EvelynConfiguration {
    static List<String> accepts = Main.getPlugins ().getConfig ().getStringList ( "EvelynResourcePack.Messages.Accept" );
    static List<String> successs = Main.getPlugins ().getConfig ().getStringList ( "EvelynResourcePack.Messages.Success" );

    public static void send(Player p) {
        p.setResourcePack ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.URL-Link" ) );
    }

    public static void main(Player p) {
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "              &6&lEvelynResourcePack" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', " &e/pack - to download the resourcepack manual" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
    }

    public static void accept(Player p) {
        for (String accept : accepts) {
            p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', accept ) );
        }
    }

    public static void bypass(Player p) {
        return;
    }

    public static void success(Player p) {
        for (String success : successs) {
            p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', success ) );
        }
    }

    public static void declined(Player p) {
        p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Kick.Declined" ) ) );
    }

    public static void failed(Player p) {
        p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Kick.Failed" ) ) );
    }

    public static void acceptdelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Messages.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> accept ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void successdelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Messages.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> success ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void declineddelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Kick.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declined ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void faileddelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Kick.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failed ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void joinbypass(Player p) {
        if (p.hasPermission ( "evelyn.bypass" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> bypass ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ));
        } else {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> send ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ));
        }
    }
}
