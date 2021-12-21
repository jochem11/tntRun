package tnt.tnt;

import org.bukkit.plugin.java.JavaPlugin;
import tnt.tnt.command.TntToggle;

public final class Tnt extends JavaPlugin {

    public static Tnt getTnt;
    private static Tnt tnt;
    private boolean toggle;

    @Override

    public void onEnable() {
        tnt = this;
        getServer().getPluginManager().registerEvents(new TntEvent(), this);
        new TntToggle();

    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Tnt getTnt() {
        return tnt;
    }

    public boolean getToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }


}

