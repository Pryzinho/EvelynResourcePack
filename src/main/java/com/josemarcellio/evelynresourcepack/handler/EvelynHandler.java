package com.josemarcellio.evelynresourcepack.handler;

import java.util.ArrayList;

import com.josemarcellio.evelynresourcepack.Main;
import org.bukkit.entity.Player;

public class EvelynHandler {
    static Main plugin;
    private static ArrayList<String> lock;

    static {
        EvelynHandler.lock = new ArrayList<> ();
    }

    public EvelynHandler(final Main instance) {
        EvelynHandler.plugin = instance;
    }

    public static boolean lockplayer(final Player player) {
        return EvelynHandler.lock.contains ( player.getUniqueId ().toString () );
    }

    public void unlockplayer(final Player player) {
        EvelynHandler.lock.add(player.getUniqueId().toString());
    }

    public void removelock(final Player player) {
        EvelynHandler.lock.remove(player.getUniqueId().toString());
    }
}
