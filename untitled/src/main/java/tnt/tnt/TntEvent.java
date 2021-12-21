package tnt.tnt;



import jdk.javadoc.internal.tool.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;


public class TntEvent implements Listener {

    Main plugin;

    @EventHandler//blokken onder je weg halen
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location location = player.getLocation();


        int y = (int) (location.getY());
        int ysec = (int) location.getY() -1;
        int x = (int) location.getX() -1;
        int z = (int) location.getZ() -1;
        World world = player.getWorld();

        Block block = new Location(world, x, ysec, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSand = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockGravel = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);


        if (Tnt.getTnt().getToggle()) {
            if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) {//sand
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt()  , new Runnable(){//delay ding
                    @Override
                    public void run() {
                        blockSand.setType(Material.AIR);
                        block.setType(Material.AIR);
                    }

                }, 5L);//delay zelf
            } else if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GRAVEL) {//gravel
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Tnt.getTnt()  , new Runnable() {
                    @Override
                    public void run() {
                        blockGravel.setType(Material.AIR);
                        block.setType(Material.AIR);
                    }//delay ding

                    }, 5L);//delay zelf
            }
        }


    }//einde blokken weghalen

}
