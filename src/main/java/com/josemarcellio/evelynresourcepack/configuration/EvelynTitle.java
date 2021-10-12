package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.Titles;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class EvelynTitle {
    final FileConfiguration file = Main.getPlugins().getConfig();

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
}
