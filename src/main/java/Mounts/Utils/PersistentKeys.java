package Mounts.Utils;

import Mounts.Mounts;
import org.bukkit.NamespacedKey;

public class PersistentKeys {

    public static final NamespacedKey IS_MOUNT_ITEM = new NamespacedKey(Mounts.getInstance(), "IS_MOUNT_EGG");
    public static final NamespacedKey OWNER = new NamespacedKey(Mounts.getInstance(), "OWNER");

    public static final NamespacedKey ENTITY_SCALE = new NamespacedKey(Mounts.getInstance(), HorseAttributes.ENTITY_SCALE);

    // Movement and Speed
    public static final NamespacedKey MOVEMENT_SPEED = new NamespacedKey(Mounts.getInstance(), HorseAttributes.MOVEMENT_SPEED); 
    public static final NamespacedKey MOVEMENT_EFFICIENCY = new NamespacedKey(Mounts.getInstance(), HorseAttributes.MOVEMENT_EFFICIENCY); 
    public static final NamespacedKey STEP_HEIGHT = new NamespacedKey(Mounts.getInstance(), HorseAttributes.STEP_HEIGHT); 
    public static final NamespacedKey WATER_MOVEMENT_EFFICIENCY = new NamespacedKey(Mounts.getInstance(), HorseAttributes.WATER_MOVEMENT_EFFICIENCY); 

    // Jumping and fall damage
    public static final NamespacedKey JUMP_STRENGTH = new NamespacedKey(Mounts.getInstance(), HorseAttributes.JUMP_STRENGTH); 
    public static final NamespacedKey FALL_DAMAGE_MULTIPLIER = new NamespacedKey(Mounts.getInstance(), HorseAttributes.FALL_DAMAGE_MULTIPLIER); 
    public static final NamespacedKey SAFE_FALL_DISTANCE = new NamespacedKey(Mounts.getInstance(), HorseAttributes.SAFE_FALL_DISTANCE); 
    public static final NamespacedKey GRAVITY = new NamespacedKey(Mounts.getInstance(), HorseAttributes.GRAVITY); 

    // Health and Combat
    public static final NamespacedKey MAX_HEALTH = new NamespacedKey(Mounts.getInstance(), HorseAttributes.MAX_HEALTH); 
    public static final NamespacedKey KNOCKBACK_RESISTANCE = new NamespacedKey(Mounts.getInstance(), HorseAttributes.KNOCKBACK_RESISTANCE); 
    public static final NamespacedKey EXPLOSION_KNOCKBACK_RESISTANCE = new NamespacedKey(Mounts.getInstance(), HorseAttributes.EXPLOSION_KNOCKBACK_RESISTANCE); 
    public static final NamespacedKey BURN_TIME = new NamespacedKey(Mounts.getInstance(), HorseAttributes.BURN_TIME); 

    // Armor
    public static final NamespacedKey ARMOR_DURABILITY = new NamespacedKey(Mounts.getInstance(), HorseAttributes.ARMOR_DURABILITY); 
    public static final NamespacedKey ARMOR_TOUGHNESS = new NamespacedKey(Mounts.getInstance(), HorseAttributes.ARMOR_TOUGHNESS);


}
