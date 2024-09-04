package Mounts;

import Mounts.Commands.HorseAttributeCommand;
import Mounts.Commands.SpawnHorseCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mounts extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(MountEvents.getInstance(), this);

        this.getCommand("mount").setExecutor(new SpawnHorseCommand());
        this.getCommand("mountedit").setExecutor(new HorseAttributeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Mounts getInstance(){
        return getPlugin(Mounts.class);
    }
}
