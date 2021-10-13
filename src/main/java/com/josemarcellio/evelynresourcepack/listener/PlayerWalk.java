package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.handler.EvelynHandler;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class PlayerWalk implements Listener {

    public Main plugin;
    public EvelynHandler evelyn;

    public PlayerWalk(Main instance, EvelynHandler evelyn) {
        this.plugin = instance;
        this.evelyn = evelyn;
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent e) {
        if (!EvelynHandler.lockplayer ( e.getPlayer () )) {
            final FileConfiguration file = Main.getPlugins ().getConfig ();
            if (file.getBoolean ( "EvelynResourcePack.Lock.Join.Enable" )) {
                e.setTo ( new Location ( e.getPlayer ().getWorld (), e.getFrom ().getX (), Objects.requireNonNull ( e.getTo () ).getY (), e.getFrom ().getZ (), e.getTo ().getYaw (), e.getTo ().getPitch () ) );
            }
        }
    }
}