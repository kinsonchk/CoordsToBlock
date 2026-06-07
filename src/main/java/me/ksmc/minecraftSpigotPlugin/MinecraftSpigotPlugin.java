package me.ksmc.minecraftSpigotPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftSpigotPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("[SpigotPlugin] Plugin has been enabled!");

        getCommand("ctb").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("[SpigotPlugin] Plugin has been disabled!");
    }
}
