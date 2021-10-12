package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.DiscordAuthor;
import com.josemarcellio.evelynresourcepack.utils.DiscordEmbed;
import com.josemarcellio.evelynresourcepack.utils.DiscordSender;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Objects;

public class EvelynDiscord {

    final FileConfiguration file = Main.getPlugins().getConfig();
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
