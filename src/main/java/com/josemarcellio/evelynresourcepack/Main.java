package com.josemarcellio.evelynresourcepack;

import com.josemarcellio.evelynresourcepack.command.MainCommand;
import com.josemarcellio.evelynresourcepack.command.ResourcePackCommand;
import com.josemarcellio.evelynresourcepack.listener.PlayerJoin;
import com.josemarcellio.evelynresourcepack.listener.ResourcePack;
import com.josemarcellio.evelynresourcepack.metrics.Metrics;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public static Main getPlugins() {
        return JavaPlugin.getPlugin(Main.class);
    }
    public void onEnable() {
        this.saveDefaultConfig ();
        this.getServer ().getPluginManager ().registerEvents ( new ResourcePack (), this );
        this.getServer ().getPluginManager ().registerEvents ( new PlayerJoin (), this );
        getCommand ( "pack" ).setExecutor ( new ResourcePackCommand () );
        getCommand ( "resourcepack" ).setExecutor ( new MainCommand () );
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