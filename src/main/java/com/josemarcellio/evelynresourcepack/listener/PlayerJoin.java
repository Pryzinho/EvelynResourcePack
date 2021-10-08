package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void join(final PlayerJoinEvent e) {
        final Player p = e.getPlayer ();
        EvelynConfiguration.joinbypass(p);
    }
}
