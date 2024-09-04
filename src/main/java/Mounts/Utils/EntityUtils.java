package Mounts.Utils;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityUtils {

    private static final Map<String, NamespacedKey> persistentKeyMap = new HashMap<>();
    private static final Map<String, Attribute> attributeMap = new HashMap<>();

    static {
        attributeMap.put(HorseAttributes.ENTITY_SCALE, Attribute.GENERIC_SCALE);
        attributeMap.put(HorseAttributes.MOVEMENT_SPEED, Attribute.GENERIC_MOVEMENT_SPEED);
        attributeMap.put(HorseAttributes.MOVEMENT_EFFICIENCY, Attribute.GENERIC_MOVEMENT_EFFICIENCY);
        attributeMap.put(HorseAttributes.STEP_HEIGHT, Attribute.GENERIC_STEP_HEIGHT);
        attributeMap.put(HorseAttributes.WATER_MOVEMENT_EFFICIENCY, Attribute.GENERIC_WATER_MOVEMENT_EFFICIENCY);
        attributeMap.put(HorseAttributes.JUMP_STRENGTH, Attribute.GENERIC_JUMP_STRENGTH);
        attributeMap.put(HorseAttributes.FALL_DAMAGE_MULTIPLIER, Attribute.GENERIC_FALL_DAMAGE_MULTIPLIER);
        attributeMap.put(HorseAttributes.SAFE_FALL_DISTANCE, Attribute.GENERIC_SAFE_FALL_DISTANCE);
        attributeMap.put(HorseAttributes.GRAVITY, Attribute.GENERIC_GRAVITY);
        attributeMap.put(HorseAttributes.MAX_HEALTH, Attribute.GENERIC_MAX_HEALTH);
        attributeMap.put(HorseAttributes.KNOCKBACK_RESISTANCE, Attribute.GENERIC_KNOCKBACK_RESISTANCE);
        attributeMap.put(HorseAttributes.EXPLOSION_KNOCKBACK_RESISTANCE, Attribute.GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE);
        attributeMap.put(HorseAttributes.BURN_TIME, Attribute.GENERIC_BURNING_TIME);
        attributeMap.put(HorseAttributes.ARMOR_DURABILITY, Attribute.GENERIC_ARMOR);
        attributeMap.put(HorseAttributes.ARMOR_TOUGHNESS, Attribute.GENERIC_ARMOR_TOUGHNESS);
    }
    static {
        persistentKeyMap.put(HorseAttributes.ENTITY_SCALE, PersistentKeys.ENTITY_SCALE);
        persistentKeyMap.put(HorseAttributes.MOVEMENT_SPEED, PersistentKeys.MOVEMENT_SPEED);
        persistentKeyMap.put(HorseAttributes.MOVEMENT_EFFICIENCY, PersistentKeys.MOVEMENT_EFFICIENCY);
        persistentKeyMap.put(HorseAttributes.STEP_HEIGHT, PersistentKeys.STEP_HEIGHT);
        persistentKeyMap.put(HorseAttributes.WATER_MOVEMENT_EFFICIENCY, PersistentKeys.WATER_MOVEMENT_EFFICIENCY);
        persistentKeyMap.put(HorseAttributes.JUMP_STRENGTH, PersistentKeys.JUMP_STRENGTH);
        persistentKeyMap.put(HorseAttributes.FALL_DAMAGE_MULTIPLIER, PersistentKeys.FALL_DAMAGE_MULTIPLIER);
        persistentKeyMap.put(HorseAttributes.SAFE_FALL_DISTANCE, PersistentKeys.SAFE_FALL_DISTANCE);
        persistentKeyMap.put(HorseAttributes.GRAVITY, PersistentKeys.GRAVITY);
        persistentKeyMap.put(HorseAttributes.MAX_HEALTH, PersistentKeys.MAX_HEALTH);
        persistentKeyMap.put(HorseAttributes.KNOCKBACK_RESISTANCE, PersistentKeys.KNOCKBACK_RESISTANCE);
        persistentKeyMap.put(HorseAttributes.EXPLOSION_KNOCKBACK_RESISTANCE, PersistentKeys.EXPLOSION_KNOCKBACK_RESISTANCE);
        persistentKeyMap.put(HorseAttributes.BURN_TIME, PersistentKeys.BURN_TIME);
        persistentKeyMap.put(HorseAttributes.ARMOR_DURABILITY, PersistentKeys.ARMOR_DURABILITY);
        persistentKeyMap.put(HorseAttributes.ARMOR_TOUGHNESS, PersistentKeys.ARMOR_TOUGHNESS);
    }

    public static Attribute getAttribute(String attributeName) {
        // Normalize the attribute name to uppercase for case-insensitive comparison
        String normalizedAttributeName = attributeName.toUpperCase();

        // Look up the attribute in the map
        return attributeMap.getOrDefault(normalizedAttributeName, null);
    }

    public static NamespacedKey getPersistentKey(String attributeName){
        // Normalize the attribute name to uppercase for case-insensitive comparison
        String normalizedAttributeName = attributeName.toUpperCase();

        // Look up the attribute in the map
        return persistentKeyMap.getOrDefault(normalizedAttributeName, null);
    }

    public static List<String> getAttributeNames() {
        return attributeMap.keySet().stream().toList();
    }

    public static List<Attribute> getAttributes(){
        return attributeMap.values().stream().toList();
    }

    public static List<NamespacedKey> getPersistentKeys(ArrayList<NamespacedKey> keysToFilter){

        keysToFilter.remove(PersistentKeys.IS_MOUNT_ITEM);
        keysToFilter.remove(PersistentKeys.OWNER);

        return keysToFilter.stream().toList();
    }

    public static List<NamespacedKey> getPersistentKeys(){
        return getPersistentKeys(new ArrayList<>(persistentKeyMap.values()));
    }

    public static List<NamespacedKey> getPersistentKeys(PersistentDataContainer container){
        return getPersistentKeys(new ArrayList<>(container.getKeys()));
    }
}
