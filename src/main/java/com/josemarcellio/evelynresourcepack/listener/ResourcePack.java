package com.josemarcellio.evelynresourcepack.listener;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.configuration.EvelynConfiguration;
import com.josemarcellio.evelynresourcepack.handler.EvelynHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePack implements Listener {

    public Main plugin;
    public EvelynHandler evelyn;

    public ResourcePack(Main instance, EvelynHandler evelyn) {
        this.plugin = instance;
        this.evelyn = evelyn;
    }

    @EventHandler
    public void resourcepack(final PlayerResourcePackStatusEvent e) {
        final FileConfiguration file = Main.getPlugins().getConfig();
        final Player p = e.getPlayer();
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.ACCEPTED)) {
            new EvelynConfiguration ().acceptdelay ( p );
            if (file.getBoolean ( "EvelynResourcePack.Unlock.Accept.Enable" )) {
                ResourcePack.this.evelyn.unlockplayer(p);
            }
        }
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED)) {
            new EvelynConfiguration().successdelay (p);
            if (file.getBoolean ( "EvelynResourcePack.Unlock.Success.Enable" )) {
                ResourcePack.this.evelyn.unlockplayer(p);
            }
        }
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED)) {
            new EvelynConfiguration().declineddelay (p);
            if (file.getBoolean ( "EvelynResourcePack.Unlock.Declined.Enable" )) {
                ResourcePack.this.evelyn.unlockplayer(p);
            }
        }
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD)) {
            new EvelynConfiguration().faileddelay (p);
            if (file.getBoolean ( "EvelynResourcePack.Unlock.Failed.Enable" )) {
                ResourcePack.this.evelyn.unlockplayer(p);
            }
        }
    }
}