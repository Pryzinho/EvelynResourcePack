package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.handler.EvelynHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    public EvelynHandler evelyn;

    public PlayerQuit(EvelynHandler evelyn) {
        this.evelyn = evelyn;
    }

    @EventHandler
    public void quit(final PlayerQuitEvent e) {
        if (EvelynHandler.lockplayer ( e.getPlayer () )) {
            this.evelyn.removelock ( e.getPlayer () );
        }
    }
}