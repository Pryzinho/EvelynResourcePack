package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePack implements Listener {
    @EventHandler
    public void resourcepack(final PlayerResourcePackStatusEvent e) {
        final Player p = e.getPlayer();
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.ACCEPTED)) {
            new EvelynConfiguration().acceptdelay (p);
        }
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED)) {
            new EvelynConfiguration().successdelay (p);
        }
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED)) {
            new EvelynConfiguration().declineddelay (p);
        }
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD)) {
            new EvelynConfiguration().faileddelay (p);
        }
    }
}
