package com.josemarcellio.evelynresourcepack.hook;

import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import com.nickuc.login.api.events.AsyncLoginEvent;
import com.nickuc.login.api.events.AsyncRegisterEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class nLoginListener implements Listener {
    @EventHandler
    public void onlogin(AsyncLoginEvent e) {
        Player p = e.getPlayer();
        EvelynConfiguration.joinbypass(p);
    }
    @EventHandler
    public void onregister(AsyncRegisterEvent e) {
        Player p = e.getPlayer();
        EvelynConfiguration.joinbypass(p);
    }
}