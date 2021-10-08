package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.Titles;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class EvelynConfiguration {
    static List<String> accepts = Main.getPlugins ().getConfig ().getStringList ( "EvelynResourcePack.Messages.Accept.Messages" );
    static List<String> successs = Main.getPlugins ().getConfig ().getStringList ( "EvelynResourcePack.Messages.Success.Messages" );

    public static void send(Player p) {
        p.setResourcePack ( Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.URL-Link" ) ) );
    }

    public static void main(Player p) {
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "              &6&lEvelynResourcePack" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', " &e/pack - Manual Download ResourcePack!" ) );
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
        p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Kick.Declined.Messages" ) ) ) );
    }

    public static void failed(Player p) {
        p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Kick.Failed.Messages" ) ) ) );
    }

    public static void acceptdelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Messages.Accept.Enable" )) {
            accept(p);
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Title.Accept.Enable" )) {
            accepttitle ( p );
        }
    }

    public static void successdelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Messages.Success.Enable" )) {
            success(p);
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Title.Success.Enable" )) {
            successtitle ( p );
        }
    }

    public static void declineddelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Kick.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declined ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void faileddelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Kick.Failed.Enable" )) {
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

    public static void accepttitle(Player p) {
        Titles.sendTitle(p,Main.getPlugins().getConfig().getString("EvelynResourcePack.Title.Accept.Title"),Main.getPlugins().getConfig().getString("EvelynResourcePack.Title.Accept.SubTitle") , Main.getPlugins().getConfig().getInt("EvelynResourcePack.Title.Accept.FadeIn"),Main.getPlugins().getConfig().getInt("EvelynResourcePack.Title.Accept.Stay"),Main.getPlugins().getConfig().getInt("EvelynResourcePack.Title.Accept.FadeOut"));
    }

    public static void successtitle(Player p) {
        Titles.sendTitle(p,Main.getPlugins().getConfig().getString("EvelynResourcePack.Title.Success.Title"),Main.getPlugins().getConfig().getString("EvelynResourcePack.Title.Success.SubTitle") , Main.getPlugins().getConfig().getInt("EvelynResourcePack.Title.Success.FadeIn"),Main.getPlugins().getConfig().getInt("EvelynResourcePack.Title.Success.Stay"),Main.getPlugins().getConfig().getInt("EvelynResourcePack.Title.Success.FadeOut"));
    }
}
