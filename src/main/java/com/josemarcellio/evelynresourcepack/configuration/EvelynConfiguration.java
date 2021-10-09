package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.Titles;
import com.josemarcellio.evelynresourcepack.utils.XSound;
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
            accept ( p );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Title.Accept.Enable" )) {
            accepttitle ( p );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Sound.Accept.Enable" )) {
            acceptsound ( p );
        }
    }

    public static void successdelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Messages.Success.Enable" )) {
            success ( p );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Title.Success.Enable" )) {
            successtitle ( p );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Sound.Success.Enable" )) {
            successsound ( p );
        }
    }

    public static void declineddelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Kick.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declined ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Title.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declinedtitle ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Sound.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declinedsound ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void faileddelay(Player p) {
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Kick.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failed ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Title.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failedtitle ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (Main.getPlugins ().getConfig ().getBoolean ( "EvelynResourcePack.Sound.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failedsound ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void joinbypass(Player p) {
        if (p.hasPermission ( "evelyn.bypass" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> bypass ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        } else {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> send ( p ), 20L * Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public static void accepttitle(Player p) {
        Titles.sendTitle ( p, Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Accept.Title" ), Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Accept.SubTitle" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Accept.FadeIn" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Accept.Stay" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Accept.FadeOut" ) );
    }

    public static void successtitle(Player p) {
        Titles.sendTitle ( p, Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Success.Title" ), Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Success.SubTitle" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Success.FadeIn" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Success.Stay" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Success.FadeOut" ) );
    }

    public static void declinedtitle(Player p) {
        Titles.sendTitle ( p, Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Declined.Title" ), Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Declined.SubTitle" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Declined.FadeIn" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Declined.Stay" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Declined.FadeOut" ) );
    }

    public static void failedtitle(Player p) {
        Titles.sendTitle ( p, Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Failed.Title" ), Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Title.Failed.SubTitle" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Failed.FadeIn" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Failed.Stay" ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.Title.Failed.FadeOut" ) );
    }

    public static void acceptsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Sound.Accept.Sound" ) ) ).get ().parseSound () ), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Accept.Volume"), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Accept.Pitch"));
    }

    public static void successsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Sound.Success.Sound" ) ) ).get ().parseSound () ), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Success.Volume"), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Success.Pitch"));
    }

    public static void failedsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Sound.Failed.Sound" ) ) ).get ().parseSound () ), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Failed.Volume"), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Failed.Pitch"));
    }

    public static void declinedsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( Main.getPlugins ().getConfig ().getString ( "EvelynResourcePack.Sound.Declined.Sound" ) ) ).get ().parseSound () ), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Declined.Volume"), Main.getPlugins ().getConfig ().getInt("EvelynResourcePack.Sound.Declined.Pitch"));
    }

}
