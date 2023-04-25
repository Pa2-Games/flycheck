package net.sapo.flycheck;

import net.sapo.flycheck.Commands.Commandflycheck;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Flycheck extends JavaPlugin {
    public FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        this.getCommand("flycheck").setExecutor(new Commandflycheck());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
