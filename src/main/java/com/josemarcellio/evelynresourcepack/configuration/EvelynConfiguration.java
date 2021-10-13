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
import java.util.Optional;

public class EvelynConfiguration {

    public Main plugin;

    public EvelynConfiguration(Main instance) {
        this.plugin = instance;
    }

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

    public void bypass(Player p) {
        Bukkit.getScheduler().runTaskLater(this.plugin, () -> {
            bypassmessage ( p );
            bypassdiscord ( p );
            bypasssound ( p );
            bypasstitle ( p );
            bypassbar ( p );
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ));
    }

    public void success(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Messages.Success.Enable" )) {
            for (String success : successs) {
                p.sendMessage ( ChatColor.translateAlternateColorCodes ( '&', success ) );
            }
        }
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
        Bukkit.getScheduler().runTaskLater(this.plugin, () -> {
            accept ( p );
            accepttitle ( p );
            acceptsound ( p );
            acceptbar ( p );
            acceptdiscord(p);
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ));
    }

    public void successdelay(Player p) {
        Bukkit.getScheduler().runTaskLater(this.plugin, () -> {
            success ( p );
            successtitle ( p );
            successsound ( p );
            successbar ( p );
            successdiscord(p);
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ));
    }

    public void declineddelay(Player p) {
        Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> {
            declined ( p );
            declineddiscord ( p );
            declined2 ( p );
            declinedtitle ( p );
            declinedsound ( p );
            declinedbar ( p );
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
    }

    public void faileddelay(Player p) {
        Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> {
            failed2 ( p );
            failed ( p );
            failedtitle ( p );
            failedsound ( p );
            failedbar ( p );
            faileddiscord ( p );
        }, 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
    }

    public void joinbypass(Player p) {
        if (p.hasPermission ( "evelyn.bypass" )) {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> bypass ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        } else {
            Bukkit.getScheduler ().runTaskLater ( Main.getPlugins (), () -> send ( p ), 20L * file.getInt ( "EvelynResourcePack.Delay" ) );
        }
    }

    public void bypasstitle(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Title.Bypass.Enable" )) {
            Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Bypass.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Bypass.Stay" ), file.getInt ( "EvelynResourcePack.Title.Bypass.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Bypass.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Bypass.SubTitle" ) ) ) );
        }
    }

    public void accepttitle(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Title.Accept.Enable" )) {
            Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Accept.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Accept.Stay" ), file.getInt ( "EvelynResourcePack.Title.Accept.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Accept.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Accept.SubTitle" ) ) ) );
        }
    }

    public void successtitle(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Title.Success.Enable" )) {
            Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Success.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Success.Stay" ), file.getInt ( "EvelynResourcePack.Title.Success.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Success.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Success.SubTitle" ) ) ) );
        }
    }

    public void declinedtitle(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Title.Declined.Enable" )) {
            Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Declined.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Declined.Stay" ), file.getInt ( "EvelynResourcePack.Title.Declined.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Declined.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Declined.SubTitle" ) ) ) );
        }
    }

    public void failedtitle(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Title.Failed.Enable" )) {
            Titles.sendTitle ( p, file.getInt ( "EvelynResourcePack.Title.Failed.FadeIn" ), file.getInt ( "EvelynResourcePack.Title.Failed.Stay" ), file.getInt ( "EvelynResourcePack.Title.Failed.FadeOut" ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Failed.Title" ) ) ), ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Title.Failed.SubTitle" ) ) ) );
        }
    }

    public void bypasssound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Bypass.Enable" )) {
            Optional<XSound> bypass = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Bypass.Sound" ) ) );
            bypass.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Bypass.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Bypass.Pitch" ) ) );
        }
    }

    public void acceptsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Accept.Enable" )) {
            Optional<XSound> accept = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Accept.Sound" ) ) );
            accept.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Accept.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Accept.Pitch" ) ) );
        }
    }

    public void successsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Success.Enable" )) {
            Optional<XSound> success = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Success.Sound" ) ) );
            success.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Success.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Success.Pitch" ) ) );
        }
    }

    public void failedsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Failed.Enable" )) {
            Optional<XSound> failed = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Failed.Sound" ) ) );
            failed.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Failed.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Failed.Pitch" ) ) );
        }
    }

    public void declinedsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Declined.Enable" )) {
            Optional<XSound> declined = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Declined.Sound" ) ) );
            declined.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Declined.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Declined.Pitch" ) ) );
        }
    }

    public void bypassbar(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Bypass.Enable" )) {
            ActionBar.sendActionBar ( Main.getPlugins (), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Bypass.Messages" ) ) ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.ActionBar.Bypass.Duration" ) );
        }
    }

    public void acceptbar(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Accept.Enable" )) {
            ActionBar.sendActionBar ( Main.getPlugins (), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Accept.Messages" ) ) ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.ActionBar.Accept.Duration" ) );
        }
    }

    public void successbar(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Success.Enable" )) {
            ActionBar.sendActionBar ( Main.getPlugins (), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Success.Messages" ) ) ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.ActionBar.Success.Duration" ) );
        }
    }

    public void failedbar(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Failed.Enable" )) {
            ActionBar.sendActionBar ( Main.getPlugins (), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Failed.Messages" ) ) ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.ActionBar.Failed.Duration" ) );
        }
    }

    public void declinedbar(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.ActionBar.Declined.Enable" )) {
            ActionBar.sendActionBar ( Main.getPlugins (), p, ChatColor.translateAlternateColorCodes ( '&', Objects.requireNonNull ( file.getString ( "EvelynResourcePack.ActionBar.Declined.Messages" ) ) ), Main.getPlugins ().getConfig ().getInt ( "EvelynResourcePack.ActionBar.Declined.Duration" ) );
        }
    }

    public void acceptdiscord (Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Accept.Enable" )) {
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
    }

    public void successdiscord (Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Success.Enable" )) {
            DiscordEmbed embed = new DiscordEmbed ()
                    .setTitle ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Title" ) )
                    .setColor ( Color.cyan )
                    .setDescription ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Description" ) ).replaceAll ( "%player%", p.getName () ) );
            DiscordAuthor author = new DiscordAuthor (
                    ChatColor.stripColor ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Author" ) ).replaceAll ( "%player%", p.getName () ) ),
                    Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Success.Profile" ) ).replaceAll ( "%player%", p.getName () ) );
            try {
                DiscordSender.sendEmbed ( embed, file.getString ( "EvelynResourcePack.Discord-Webhook.URL-Link" ), author );
            } catch (Exception exception) {
                exception.printStackTrace ();
            }
        }
    }

    public void faileddiscord (Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Failed.Enable" )) {
            DiscordEmbed embed = new DiscordEmbed ()
                    .setTitle ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Title" ) )
                    .setColor ( Color.cyan )
                    .setDescription ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Description" ) ).replaceAll ( "%player%", p.getName () ) );
            DiscordAuthor author = new DiscordAuthor (
                    ChatColor.stripColor ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Author" ) ).replaceAll ( "%player%", p.getName () ) ),
                    Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Failed.Profile" ) ).replaceAll ( "%player%", p.getName () ) );
            try {
                DiscordSender.sendEmbed ( embed, file.getString ( "EvelynResourcePack.Discord-Webhook.URL-Link" ), author );
            } catch (Exception exception) {
                exception.printStackTrace ();
            }
        }
    }

    public void declineddiscord (Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Declined.Enable" )) {
            DiscordEmbed embed = new DiscordEmbed ()
                    .setTitle ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Title" ) )
                    .setColor ( Color.cyan )
                    .setDescription ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Description" ) ).replaceAll ( "%player%", p.getName () ) );
            DiscordAuthor author = new DiscordAuthor (
                    ChatColor.stripColor ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Author" ) ).replaceAll ( "%player%", p.getName () ) ),
                    Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Declined.Profile" ) ).replaceAll ( "%player%", p.getName () ) );
            try {
                DiscordSender.sendEmbed ( embed, file.getString ( "EvelynResourcePack.Discord-Webhook.URL-Link" ), author );
            } catch (Exception exception) {
                exception.printStackTrace ();
            }
        }
    }

    public void bypassdiscord (Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Discord-Webhook.Bypass.Enable" )) {
            DiscordEmbed embed = new DiscordEmbed ()
                    .setTitle ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Title" ) )
                    .setColor ( Color.cyan )
                    .setDescription ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Description" ) ).replaceAll ( "%player%", p.getName () ) );
            DiscordAuthor author = new DiscordAuthor (
                    ChatColor.stripColor ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Author" ) ).replaceAll ( "%player%", p.getName () ) ),
                    Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Discord-Webhook.Bypass.Profile" ) ).replaceAll ( "%player%", p.getName () ) );
            try {
                DiscordSender.sendEmbed ( embed, file.getString ( "EvelynResourcePack.Discord-Webhook.URL-Link" ), author );
            } catch (Exception exception) {
                exception.printStackTrace ();
            }
        }
    }
}
