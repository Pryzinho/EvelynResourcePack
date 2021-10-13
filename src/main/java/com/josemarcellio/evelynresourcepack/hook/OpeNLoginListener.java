package com.josemarcellio.evelynresourcepack.hook;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import com.nickuc.openlogin.bukkit.api.events.AsyncLoginEvent;
import com.nickuc.openlogin.bukkit.api.events.AsyncRegisterEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OpeNLoginListener implements Listener {

    public Main plugin;

    public OpeNLoginListener(Main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onlogin(final AsyncLoginEvent e) {
        final Player p = e.getPlayer();
        new EvelynConfiguration().joinbypass(p);
    }
    @EventHandler
    public void onregister(final AsyncRegisterEvent e) {
        final Player p = e.getPlayer();
        new EvelynConfiguration().joinbypass(p);
    }
}
