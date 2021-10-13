package com.josemarcellio.evelynresourcepack.hook;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import fr.xephi.authme.events.LoginEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AuthMeListener implements Listener {

    public Main plugin;

    public AuthMeListener(Main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onlogin(LoginEvent e) {
        Player p = e.getPlayer();
        new EvelynConfiguration(this.plugin).joinbypass(p);
    }
}
