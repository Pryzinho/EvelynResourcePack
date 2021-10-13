package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.handler.EvelynHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    public Main plugin;
    public EvelynHandler evelyn;

    public PlayerQuit(Main instance, EvelynHandler evelyn) {
        this.plugin = instance;
        this.evelyn = evelyn;
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        if (EvelynHandler.lockplayer ( e.getPlayer () )) {
            this.evelyn.removelock ( e.getPlayer () );
        }
    }
}