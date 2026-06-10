package me.ksmc.minecraftSpigotPlugin;

import me.ksmc.minecraftSpigotPlugin.Commands.CTBCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin has been enabled!");

        getCommand("ctb").setExecutor(new CTBCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin has been disabled!");
    }
}
