package Mounts.Interfaces;

import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface IMountEntity {
    AbstractHorse spawnEntity(Player player, ItemStack spawnItem);

    void setAttributeValue(String fieldName, double value) throws NoSuchFieldException;
}
