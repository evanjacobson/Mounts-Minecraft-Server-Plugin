package Mounts.Commands;

import Mounts.Utils.EntityUtils;
import Mounts.Utils.PersistentKeys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HorseAttributeCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        if(!player.hasPermission("mounts.admin")){
            player.sendMessage(Component.text("You do not have permission to use mount commands", NamedTextColor.DARK_RED));
            return true;
        }

        if(args.length < 2){
            return false;
        }

        var horseEgg = player.getInventory().getItemInMainHand();
        if(!horseEgg.getItemMeta().getPersistentDataContainer().has(PersistentKeys.IS_MOUNT_ITEM)){
            player.sendMessage(Component.text("You must be holding a mount to do that", NamedTextColor.DARK_RED));
            return false;
        }

        List<String> attributes = EntityUtils.getAttributeNames();
        String attrName = args[0];

        if(!attributes.contains(attrName.toUpperCase())){
            return false;
        }

        String val = args[1];
        double d;

        var persistentKey = EntityUtils.getPersistentKey(attrName);
        if(persistentKey == null){
            return false;
        }

        var itemMeta = horseEgg.getItemMeta();

        try{
            d = Double.parseDouble(val);
            itemMeta.getPersistentDataContainer().set(persistentKey, PersistentDataType.DOUBLE, d);
        }
        catch(NumberFormatException ex){
            if(!val.equalsIgnoreCase("unset")){
                return false;

            }
            itemMeta.getPersistentDataContainer().remove(persistentKey);
        }

        var container = itemMeta.getPersistentDataContainer();
        var keys = EntityUtils.getPersistentKeys(container);

        List<Component> lore = new ArrayList<>();
        for(var data : keys){
            Component c = Component.text(data.getKey() + ": " + container.get(data, PersistentDataType.DOUBLE), NamedTextColor.DARK_RED);
            lore.add(c);
        }

        itemMeta.lore(lore);

        horseEgg.setItemMeta(itemMeta);

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length < 2){
            return EntityUtils.getAttributeNames().stream().filter(attr -> attr.startsWith(args[0].toUpperCase())).toList();
        }
        return List.of("unset", "<enter a decimal value here>");
    }
}
