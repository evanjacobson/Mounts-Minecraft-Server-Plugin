package Mounts.Commands;

import Mounts.Utils.HorseAttributes;
import Mounts.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SpawnHorseCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if(!player.hasPermission("mounts.admin")){
            player.sendMessage(Component.text("You do not have permission to use mount commands", NamedTextColor.DARK_RED));
            return true;
        }

        ItemStack horseEgg = player.getInventory().getItemInMainHand();
        if(horseEgg.isEmpty()){
            horseEgg = new ItemStack(Material.HORSE_SPAWN_EGG);
        }

        var meta = horseEgg.getItemMeta();
        var container = meta.getPersistentDataContainer();

        container.set(PersistentKeys.IS_MOUNT_ITEM, PersistentDataType.DOUBLE, 1.0);

        var ownerName = args.length == 0 ? HorseAttributes.UNOWNED : args[0];
        container.set(PersistentKeys.OWNER, PersistentDataType.STRING, ownerName);

        if(ownerName.equalsIgnoreCase(HorseAttributes.UNOWNED)){
            meta.itemName(Component.text("Unowned Horse Mount", NamedTextColor.GREEN));
        }
        else{
            meta.itemName(Component.text(ownerName + "'s Horse Mount", NamedTextColor.GOLD));
        }

        horseEgg.setItemMeta(meta);

        player.getInventory().addItem(horseEgg);

        return true;

    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> playerNames = new ArrayList<String>();

        if(args.length < 1){
            return playerNames;
        }

        var name = args[0].toLowerCase();

        playerNames = Bukkit.getOnlinePlayers()
                .stream()
                .map(Player::getName)
                .filter(n -> n.toLowerCase().contains(name))
                .toList();

        return playerNames;
    }
}
