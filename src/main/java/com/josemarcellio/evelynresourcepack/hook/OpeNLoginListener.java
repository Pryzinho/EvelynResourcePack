package com.josemarcellio.evelynresourcepack.hook;

import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import com.nickuc.openlogin.bukkit.api.events.AsyncLoginEvent;
import com.nickuc.openlogin.bukkit.api.events.AsyncRegisterEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OpeNLoginListener implements Listener {
    @EventHandler
    public void onlogin(AsyncLoginEvent e) {
        Player p = e.getPlayer();
        new EvelynConfiguration().joinbypass(p);
    }
    @EventHandler
    public void onregister(AsyncRegisterEvent e) {
        Player p = e.getPlayer();
        new EvelynConfiguration().joinbypass(p);
    }
}
