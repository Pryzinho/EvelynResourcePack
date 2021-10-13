package com.josemarcellio.evelynresourcepack.utils;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.command.MainCommand;
import com.josemarcellio.evelynresourcepack.command.ResourcePackCommand;
import com.josemarcellio.evelynresourcepack.handler.EvelynHandler;
import com.josemarcellio.evelynresourcepack.hook.AuthMeListener;
import com.josemarcellio.evelynresourcepack.hook.OpeNLoginListener;
import com.josemarcellio.evelynresourcepack.hook.nLoginListener;
import com.josemarcellio.evelynresourcepack.listener.PlayerJoin;
import com.josemarcellio.evelynresourcepack.listener.PlayerQuit;
import com.josemarcellio.evelynresourcepack.listener.PlayerWalk;
import com.josemarcellio.evelynresourcepack.listener.ResourcePack;
import java.util.Objects;

public class EvelynManager {

    public static void Listener() {
        Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new ResourcePack (new EvelynHandler (Main.getPlugins())), Main.getPlugins() );
        Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new PlayerWalk (), Main.getPlugins() );
        Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new PlayerQuit (new EvelynHandler (Main.getPlugins())), Main.getPlugins() );
        if (Main.getPlugins().getServer ().getPluginManager ().isPluginEnabled ( "AuthMe" )) {
            Main.getPlugins().getLogger ().info ( "Hooking to AuthMe!" );
            Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new AuthMeListener (), Main.getPlugins() );
        } else if (Main.getPlugins().getServer ().getPluginManager ().isPluginEnabled ( "nLogin" )) {
            Main.getPlugins().getLogger ().info ( "Hooking to nLogin!" );
            Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new nLoginListener (), Main.getPlugins() );
        } else if (Main.getPlugins().getServer ().getPluginManager ().isPluginEnabled ( "OpeNLogin" )) {
            Main.getPlugins().getLogger ().info ( "Hooking to OpeNLogin!" );
            Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new OpeNLoginListener (), Main.getPlugins() );
        } else {
            Main.getPlugins().getServer ().getPluginManager ().registerEvents ( new PlayerJoin (), Main.getPlugins() );
            Main.getPlugins().getLogger ().info("No Login Plugins Found!, Use Default System!");
        }
    }
    public static void Command() {
        Objects.requireNonNull ( Main.getPlugins ().getCommand ( "pack" ) ).setExecutor ( new ResourcePackCommand () );
        Objects.requireNonNull ( Main.getPlugins ().getCommand ( "resourcepack" ) ).setExecutor ( new MainCommand () );
    }
}
