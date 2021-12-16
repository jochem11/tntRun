package tnt.tnt;

import org.bukkit.plugin.java.JavaPlugin;

public final class Tnt extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TntEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
