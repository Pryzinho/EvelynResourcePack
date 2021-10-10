package com.josemarcellio.evelynresourcepack;

import com.josemarcellio.evelynresourcepack.metrics.Metrics;
import com.josemarcellio.evelynresourcepack.utils.EvelynManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public static Main getPlugins() {
        return JavaPlugin.getPlugin(Main.class);
    }

    public void onEnable() {
        EvelynManager.Listener();
        EvelynManager.Command();
        this.saveDefaultConfig ();
        new Metrics (this, 12979);
        this.getLogger ().info ( "---------------------------------------------" );
        this.getLogger ().info ( "" );
        this.getLogger ().info ( "   EvelynResourcePack by JoseMarcellio" );
        this.getLogger ().info ( "" );
        this.getLogger ().info ( "---------------------------------------------" );
    }

    public void onDisable() {
        this.getLogger ().info ( "Disabling EvelynResourcePack" );
    }
}