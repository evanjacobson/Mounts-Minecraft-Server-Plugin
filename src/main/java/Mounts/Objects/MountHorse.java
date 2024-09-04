package Mounts.Objects;

import Mounts.Objects.Abstract.MountEntity;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MountHorse extends MountEntity {

    public MountHorse() {
        super(EntityType.HORSE);
    }

    @Override
    public AbstractHorse spawnEntity(Player player, ItemStack spawnItem) {
        return super.spawnEntity(player, spawnItem);
    }

}
