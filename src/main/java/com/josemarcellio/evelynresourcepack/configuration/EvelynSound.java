package com.josemarcellio.evelynresourcepack.configuration;

import com.josemarcellio.evelynresourcepack.Main;
import com.josemarcellio.evelynresourcepack.utils.XSound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.Optional;

public class EvelynSound {
    final FileConfiguration file = Main.getPlugins().getConfig();
    public void bypasssound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Bypass.Enable" )) {
            Optional<XSound> bypass = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Bypass.Sound" ) ) );
            bypass.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Bypass.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Bypass.Pitch" ) ) );
        }
    }

    public void acceptsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Accept.Enable" )) {
            Optional<XSound> accept = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Accept.Sound" ) ) );
            accept.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Accept.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Accept.Pitch" ) ) );
        }
    }

    public void successsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Success.Enable" )) {
            Optional<XSound> success = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Success.Sound" ) ) );
            success.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Success.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Success.Pitch" ) ) );
        }
    }

    public void failedsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Failed.Enable" )) {
            Optional<XSound> failed = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Failed.Sound" ) ) );
            failed.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Failed.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Failed.Pitch" ) ) );
        }
    }

    public void declinedsound(Player p) {
        if (file.getBoolean ( "EvelynResourcePack.Sound.Declined.Enable" )) {
            Optional<XSound> declined = XSound.matchXSound ( Objects.requireNonNull ( file.getString ( "EvelynResourcePack.Sound.Declined.Sound" ) ) );
            declined.ifPresent ( xSound -> p.playSound ( p.getLocation (), Objects.requireNonNull ( xSound.parseSound () ), file.getInt ( "EvelynResourcePack.Sound.Declined.Volume" ), file.getInt ( "EvelynResourcePack.Sound.Declined.Pitch" ) ) );
        }
    }
}
