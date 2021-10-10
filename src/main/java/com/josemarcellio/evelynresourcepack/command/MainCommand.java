package com.josemarcellio.evelynresourcepack.command;

import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender , final Command command, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            EvelynConfiguration.main(p);
        }
        return false;
    }
}
