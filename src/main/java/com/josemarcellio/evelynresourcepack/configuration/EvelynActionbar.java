package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.ActionBar;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class EvelynActionbar {
    final FileConfiguration file = Main.getPlugins().getConfig();
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
}
