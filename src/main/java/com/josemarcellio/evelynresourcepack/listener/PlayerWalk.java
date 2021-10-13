package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.handler.EvelynHandler;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerWalk implements Listener {

    @EventHandler
    public void walk(final PlayerMoveEvent e) {
        if (!EvelynHandler.lockplayer ( e.getPlayer () )) {
            final Player p = e.getPlayer();
            final Location to = e.getTo();
            final FileConfiguration file = Main.getPlugins ().getConfig ();
            if (file.getBoolean ( "EvelynResourcePack.Lock.Join.Enable" )) {
                if (to != null && e.getFrom().getY() > to.getY()) return;
                p.teleport(e.getFrom());
                e.setCancelled(true);
            }
        }
    }
}