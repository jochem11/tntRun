package tnt.tnt;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TntEvent implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location location = player.getLocation();

        int y = (int) (location.getY()  -1);
        int ysec = (int) location.getY() -2;
        int x = (int) location.getX() -1;
        int z = (int) location.getZ() -1;
        World world = player.getWorld();

        Block block = new Location(world, x, ysec, z).getBlock().getRelative(BlockFace.DOWN);
        Block blockSand = new Location(world, x, y, z).getBlock().getRelative(BlockFace.DOWN);

        System.out.println(block.getType());

        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) {

            blockSand.setType(Material.AIR);
            block.setType(Material.AIR);
            player.sendMessage("kut");
        }
    }
}
