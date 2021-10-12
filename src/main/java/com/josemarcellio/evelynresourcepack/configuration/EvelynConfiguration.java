package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class EvelynConfiguration {
    final FileConfiguration file = Main.getPlugins().getConfig();
    List<String> accepts = file.getStringList ( "EvelynResourcePack.Messages.Accept.Messages" );
    List<String> successs = file.getStringList ( "EvelynResourcePack.Messages.Success.Messages" );
    List<String> declineds = file.getStringList ( "EvelynResourcePack.Messages.Declined.Messages" );
    List<String> faileds = file.getStringList ( "EvelynResourcePack.Messages.Failed.Messages" );
    List<String> bypasss = file.getStringList ( "EvelynResourcePack.Messages.Bypass.Messages" );

    public void send(Player p) {
        p.setResourcePack ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.URL-Link" ) ) );
    }

    public void main(Player p) {
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "              &6&lEvelynResourcePack" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', " &e/pack - Manual Download ResourcePack!" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "" ) );
        p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', "&b&m                                                          &b" ) );
    }

    public void accept(Player p) {
        for (String accept : accepts) {
            p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', accept ) );
        }
    }

    public void declined2(Player p) {
        for (String declined : declineds) {
            p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', declined ) );
        }
    }

    public void failed2(Player p) {
        for (String failed : faileds) {
            p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', failed ) );
        }
    }

    public void bypass(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Bypass.Enable" )) {
            for (String bypass : bypasss) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', bypass ) );
            }
        }
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Bypass.Enable" )) {
            bypassdiscord ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Sound.Bypass.Enable" )) {
            bypasssound ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Title.Bypass.Enable" )) {
            bypasstitle ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Bypass.Enable" )) {
            bypassbar ( p );
        }
    }

    public void success(Player p) {
        for (String success : successs) {
            p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', success ) );
        }
    }

    public void declined(Player p) {
        p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Kick.Declined.Messages" ) ) ) );
    }

    public void failed(Player p) {
        p.kickPlayer ( ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Kick.Failed.Messages" ) ) ) );
    }

    public void acceptdelay(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Accept.Enable" )) {
            accept ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Title.Accept.Enable" )) {
            accepttitle ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Sound.Accept.Enable" )) {
            acceptsound ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Accept.Enable" )) {
            acceptbar ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Accept.Enable" )) {
            acceptdiscord(p);
        }
    }

    public void successdelay(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Success.Enable" )) {
            success ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Title.Success.Enable" )) {
            successtitle ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Sound.Success.Enable" )) {
            successsound ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Success.Enable" )) {
            successbar ( p );
        }
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Success.Enable" )) {
            successdiscord(p);
        }
    }

    public void declineddelay(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declined2 ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );

        }
        if (file.getBoolean ( "EvelynResourcePack.Kick.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declined ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Title.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declinedtitle ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Sound.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declinedsound ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Declined.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> declinedbar ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Declined.Enable" )) {
            declineddiscord(p);
        }
    }

    public void faileddelay(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failed2 ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Kick.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failed ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Title.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failedtitle ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Sound.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failedsound ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Failed.Enable" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> failedbar ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Failed.Enable" )) {
            faileddiscord(p);
        }
    }

    public void joinbypass(Player p) {
        if (p.hasPermission ( "evelyn.bypass" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> bypass ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        } else {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> send ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public void bypasstitle(Player p) {
        Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Bypass.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Bypass.Stay" ), file.getInt ( "EvelynResourcePack.Title.Bypass.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Bypass.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Bypass.SubTitle" ) ) ));
    }

    public void accepttitle(Player p) {
        Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Accept.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Accept.Stay" ), file.getInt ( "EvelynResourcePack.Title.Accept.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Accept.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Accept.SubTitle" ) ) ));
    }

    public void successtitle(Player p) {
        Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Success.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Success.Stay" ), file.getInt ( "EvelynResourcePack.Title.Success.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Success.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Success.SubTitle" ) ) ));
    }

    public void declinedtitle(Player p) {
        Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Declined.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Declined.Stay" ), file.getInt ( "EvelynResourcePack.Title.Declined.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Declined.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Declined.SubTitle" ) ) ));
    }

    public void failedtitle(Player p) {
        Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Failed.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Failed.Stay" ), file.getInt ( "EvelynResourcePack.Title.Failed.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Failed.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Failed.SubTitle" ) ) ));
    }

    public void bypasssound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Bypass.Sound" ) ) ).get ().parseSound () ), file.getInt("EvelynResourcePack.Sound.Bypass.Volume"), file.getInt("EvelynResourcePack.Sound.Bypass.Pitch"));
    }

    public void acceptsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Accept.Sound" ) ) ).get ().parseSound () ), file.getInt("EvelynResourcePack.Sound.Accept.Volume"), file.getInt("EvelynResourcePack.Sound.Accept.Pitch"));
    }

    public void successsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Success.Sound" ) ) ).get ().parseSound () ), file.getInt("EvelynResourcePack.Sound.Success.Volume"), file.getInt("EvelynResourcePack.Sound.Success.Pitch"));
    }

    public void failedsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Failed.Sound" ) ) ).get ().parseSound () ), file.getInt("EvelynResourcePack.Sound.Failed.Volume"), file.getInt("EvelynResourcePack.Sound.Failed.Pitch"));
    }

    public void declinedsound(Player p) {
        p.playSound(p.getLocation(), Objects.requireNonNull ( XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Declined.Sound" ) ) ).get ().parseSound () ), file.getInt("EvelynResourcePack.Sound.Declined.Volume"), file.getInt("EvelynResourcePack.Sound.Declined.Pitch"));
    }

    public void bypassbar(Player p) {
        ActionBar.sendActionBar (Main.getPlugins(), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Bypass.Messages" ) ) ), Main.getPlugins().getConfig().getInt("EvelynResourcePack.ActionBar.Bypass.Duration") );
    }

    public void acceptbar(Player p) {
        ActionBar.sendActionBar (Main.getPlugins(), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Accept.Messages" ) ) ), Main.getPlugins().getConfig().getInt("EvelynResourcePack.ActionBar.Accept.Duration") );
    }

    public void successbar(Player p) {
        ActionBar.sendActionBar (Main.getPlugins(), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Success.Messages" ) ) ), Main.getPlugins().getConfig().getInt("EvelynResourcePack.ActionBar.Success.Duration") );
    }

    public void failedbar(Player p) {
        ActionBar.sendActionBar (Main.getPlugins(), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Failed.Messages" ) ) ), Main.getPlugins().getConfig().getInt("EvelynResourcePack.ActionBar.Failed.Duration") );
    }

    public void declinedbar(Player p) {
        ActionBar.sendActionBar (Main.getPlugins(), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Declined.Messages" ) ) ), Main.getPlugins().getConfig().getInt("EvelynResourcePack.ActionBar.Declined.Duration") );
    }

    public void acceptdiscord (Player p) {
        DiscordEmbed embed = new DiscordEmbed ()
                .setTitle ( file.getString ( "EvelynResourcePack.Discord-Webhook.Accept.Title" ) )
                .setColor ( Color.cyan )
                .setDescription ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Accept.Description" ) ).replaceAll ( "%player%", p.getName () ) );
        DiscordAuthor author = new DiscordAuthor (
                ChatColor.stripColor ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Accept.Author" ) ).replaceAll ( "%player%", p.getName () ) ),
                Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Accept.Profile" ) ).replaceAll ( "%player%", p.getName () ) );
        try {
            DiscordSender.sendEmbed ( embed, file.getString ( "EvelynResourcePack.Discord-Webhook.URL-Link" ), author );
        } catch (Exception exception) {
            exception.printStackTrace ();
        }
    }

    public void successdiscord (Player p) {
        DiscordEmbed embed = new DiscordEmbed ()
                .setTitle(file.getString("EvelynResourcePack.Discord-Webhook.Success.Title"))
                .setColor( Color.cyan)
                .setDescription( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Description" ) ).replaceAll("%player%", p.getName()));
        DiscordAuthor author = new DiscordAuthor (
                ChatColor.stripColor( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Author" ) ).replaceAll("%player%", p.getName())),
                Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Profile" ) ).replaceAll("%player%", p.getName()));
        try {
            DiscordSender.sendEmbed(embed, file.getString("EvelynResourcePack.Discord-Webhook.URL-Link"), author);
        } catch (Exception exception) {
            exception.printStackTrace ();
        }
    }

    public void faileddiscord (Player p) {
        DiscordEmbed embed = new DiscordEmbed ()
                .setTitle(file.getString("EvelynResourcePack.Discord-Webhook.Failed.Title"))
                .setColor( Color.cyan)
                .setDescription( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Description" ) ).replaceAll("%player%", p.getName()));
        DiscordAuthor author = new DiscordAuthor (
                ChatColor.stripColor( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Author" ) ).replaceAll("%player%", p.getName())),
                Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Profile" ) ).replaceAll("%player%", p.getName()));
        try {
            DiscordSender.sendEmbed(embed, file.getString("EvelynResourcePack.Discord-Webhook.URL-Link"), author);
        } catch (Exception exception) {
            exception.printStackTrace ();
        }
    }

    public void declineddiscord (Player p) {
        DiscordEmbed embed = new DiscordEmbed ()
                .setTitle(file.getString("EvelynResourcePack.Discord-Webhook.Declined.Title"))
                .setColor(Color.cyan)
                .setDescription( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Description" ) ).replaceAll("%player%", p.getName()));
        DiscordAuthor author = new DiscordAuthor (
                ChatColor.stripColor( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Author" ) ).replaceAll("%player%", p.getName())),
                Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Profile" ) ).replaceAll("%player%", p.getName()));
        try {
            DiscordSender.sendEmbed(embed, file.getString("EvelynResourcePack.Discord-Webhook.URL-Link"), author);
        } catch (Exception exception) {
            exception.printStackTrace ();
        }
    }

    public void bypassdiscord (Player p) {
        DiscordEmbed embed = new DiscordEmbed ()
                .setTitle(file.getString("EvelynResourcePack.Discord-Webhook.Bypass.Title"))
                .setColor(Color.cyan)
                .setDescription( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Description" ) ).replaceAll("%player%", p.getName()));
        DiscordAuthor author = new DiscordAuthor (
                ChatColor.stripColor( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Author" ) ).replaceAll("%player%", p.getName())),
                Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Profile" ) ).replaceAll("%player%", p.getName()));
        try {
            DiscordSender.sendEmbed(embed, file.getString("EvelynResourcePack.Discord-Webhook.URL-Link"), author);
        } catch (Exception exception) {
            exception.printStackTrace ();
        }
    }
}
