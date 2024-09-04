package Mounts;

import Mounts.Objects.MountHorse;
import Mounts.Utils.HorseAttributes;
import Mounts.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class MountEvents implements Listener {

    //region Singleton Loader
    private static MountEvents instance = null;

    private MountEvents(){}

    public static synchronized MountEvents getInstance()
    {
        if(instance == null){
            instance = new MountEvents();
        }

        return instance;
    }
    //endregion

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof AbstractHorse horse) {

            Player player = event.getPlayer();

            AnimalTamer owner = horse.getOwner();

            if(owner != null && owner.getUniqueId() != player.getUniqueId() && !player.hasPermission("mounts.admin")) {
                event.setCancelled(true);
                player.sendMessage(Component.text("This horse belongs to " + owner.getName(), NamedTextColor.DARK_RED));
            }
        }
    }

    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {

        if(!event.getAction().isRightClick()){
            return;
        }

        ItemStack item = event.getItem();
        var container = Objects.requireNonNull(item).getItemMeta().getPersistentDataContainer();
        if (!container.has(PersistentKeys.IS_MOUNT_ITEM)) {
            return;
        }

        event.setCancelled(true);

        Player player = event.getPlayer();

        if(!player.hasPermission("mounts.spawn")){
            player.sendMessage(Component.text("You do not have permission to use mounts", NamedTextColor.DARK_RED));
            return;
        }

        var ownerName = Objects.requireNonNull(container.get(PersistentKeys.OWNER, PersistentDataType.STRING));

        if(!ownerName.equalsIgnoreCase(HorseAttributes.UNOWNED)
                && !ownerName.equalsIgnoreCase(player.getName())
                && !player.hasPermission("mounts.admin")){
            player.sendMessage(Component.text("You cannot spawn " + ownerName + "'s horse", NamedTextColor.DARK_RED));
            return;
        }

        new MountHorse().spawnEntity(player, item);

        if(!player.hasPermission("mounts.spawn.reuse")){
            item.setAmount(item.getAmount() - 1);
        }
    }
}
