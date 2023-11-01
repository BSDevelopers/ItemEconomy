package addon.brainsynder.itemeconomy;

import addon.brainsynder.itemeconomy.config.ConfigEntryImpl;
import addon.brainsynder.itemeconomy.config.ConfigValues;
import com.google.common.collect.Maps;
import lib.brainsynder.item.ItemBuilder;
import lib.brainsynder.utils.Colorize;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import simplepets.brainsynder.addon.AddonConfig;
import simplepets.brainsynder.addon.AddonPermissions;
import simplepets.brainsynder.addon.PermissionData;
import simplepets.brainsynder.addon.PetModule;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.event.inventory.PetInventoryAddPetItemEvent;
import simplepets.brainsynder.api.event.inventory.PetSelectTypeEvent;
import simplepets.brainsynder.api.inventory.Item;
import simplepets.brainsynder.api.inventory.handler.InventoryType;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.debug.DebugLevel;

import java.util.*;

@Namespace(namespace = "ItemEconomy")
public class ItemEconomyModule extends PetModule {
    private final Map<PetType, ItemPrice> priceMap = Maps.newHashMap();

    private static Boolean legacyContents = null;
    private String bypassPerm;
    private List<String> lore = new ArrayList<>();
    private Map<PetType, String> typePermissions;
    private final ItemPrice DEFAULT_PRICE = new ItemPrice(true, Material.BEDROCK, 64, "! Invalid Pet Price !", 1);

    @Override
    public void init() {
        PermissionData parent = new PermissionData(bypassPerm).setDescription("This is the master permission, Will ignore all individual bypass permissions listed below");

        typePermissions.forEach((type, s) -> {
            AddonPermissions.register(this, parent, new PermissionData(s).setDescription("This is a bypass permission for the "+type.getName()+" pet, who ever has this permission will not have to pay for this pet"));
        });
    }

    @Override
    public void loadDefaults(AddonConfig config) {
        ConfigEntryImpl.CONFIG = config;
        this.typePermissions = Maps.newHashMap();
        config.addComment("Boolean", "Here is where you can set the translations for the 2 boolean values (true/false)");

        ConfigValues.ENTRIES.forEach((key, entry) -> {
            // Load the default values just in case
            if (entry.getDescription() == null) {
                config.addDefault(key, entry.getDefault());
            } else {
                config.addDefault(key, entry.getDefault(), entry.getDescription()
                        .replace("{default}", String.valueOf(entry.getDefault())) // Replace the {default} placeholder with what the default value is
                );
            }

            // Moves all the old keys to the new key
            if (!entry.getPastPaths().isEmpty()) {
                entry.getPastPaths().forEach(oldKey -> {
                    config.move(String.valueOf(oldKey), key);
                });
            }


            // Fetch the configs value
            Object value = config.get(key);

            // Validate the value, make sure the types match to prevent booleans becoming numbers
            if (!value.getClass().getSimpleName().equals(entry.getDefault().getClass().getSimpleName())) {
                SimplePets.getDebugLogger().debug(SimplePets.ADDON, "Value of '" + key + "' can not be a '" + value.getClass().getSimpleName() + "' must be a '" + entry.getDefault().getClass().getSimpleName() + "'" + ((entry.getExamples() != null) ? " Example(s): " + entry.getExamples() : ""));
                value = entry.getDefault();
            }
            // Store the configured value into the Entry
            entry.setValue(value, false);
        });

        String bypassPermission = "pet." + getNamespace().namespace().toLowerCase().replace(" ", "_") + ".bypass";

        config.addComment("type", """
                Here I will explain what each value controls for all the pet type customization.
                - 'enabled'
                   This will allow you to toggle if the pet is FREE or if they have to pay
                - 'display'
                   This is what will be displayed as the 'price' of the item
                   This is customizable so you should be able to use Custom Items (Custom Model Data Items)
                   
                   Note: Colors can be used here ;)
                - 'material'
                   This is what controls what material the players have to pay with
                   If you are using CustomModels this will have to be the base item for the item
                   
                   See: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/Material.java#123
                - 'count'
                   This one is self explanatory how many of said item will the player pay with
                - 'custom-model-data'
                   If you have a resource pack that adds custom models chances are you use CustomModels
                   This allows you to specify what model of item you are using
                   (This is how other plugins such as ItemsAdder have support)
                   
                   Note: If you are not using Custom Models then set the value to -1
                   See:  https://mcmodels.net/how-to-tutorials/resource-pack-tutorials/what-is-custommodeldata-2/
                   
                """);
        boolean loadedPermissions = false;
        for (PetType type : PetType.values()) {
            if (type == PetType.UNKNOWN) continue;
            if (!type.isSupported()) continue;

            String path = "type." + type.getName() + ".";
            config.addDefault(path + "enabled", true);
            config.addDefault(path + "display", "10 Diamonds");
            config.addDefault(path + "cost.material", "DIAMOND");
            config.addDefault(path + "cost.count", 10);
            config.addDefault(path + "cost.custom-model-data", -1);

            if (!loadedPermissions) {
                config.addDefault("bypass_permissions.parent", bypassPermission,
                        "This is the master permission, Will ignore all individual bypass permissions listed below");
                loadedPermissions = true;
            }
            config.addDefault("bypass_permissions.type." + type.getName(), bypassPermission + "." + type.getName(), "This is a bypass permission for the " + type.getName() + " pet, who ever has this permission will now have to pay for this pet");

            typePermissions.put(type, config.getString("bypass_permissions.type." + type.getName(), bypassPermission + "." + type.getName()));

            Material material = null;

            try {
                material = Material.getMaterial(config.getString(path + "cost.material", null));
            } catch (Exception e) {
                SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Invalid material in the 'ItemEconomy' addon for the '" + type.getName() + "' pet type");
                priceMap.put(type, DEFAULT_PRICE);
                continue;
            }

            ItemPrice price = new ItemPrice(
                    config.getBoolean(path + "enabled", true),
                    material,
                    config.getInt(path + "cost.count", 1),
                    config.getString(path + "display"),
                    config.getInt(path + "cost.custom-model-data", -1)
            );

            priceMap.put(type, price);
        }

        lore = (ConfigValues.PAY_PER_USE.getValue() ? ConfigValues.PER_USE_PURCHASE_LORE.getValue() : ConfigValues.ONE_TIME_PURCHASE_LORE.getValue());
        bypassPerm = config.getString("bypass_permissions.parent", bypassPermission);
    }

    private String var(boolean value) {
        return value ? ConfigValues.TRUE.getValue() : ConfigValues.FALSE.getValue();
    }

    // I don't remember why I was adding this method...
    public boolean isPetFree(PetType type) {
        return !priceMap.get(type).enabled();
    }

    @EventHandler
    public void onInventoryOpen(PetInventoryAddPetItemEvent event) {
        if (!isEnabled()) return;
        if (event.getInventory().getInventoryType() != InventoryType.SUMMON_GUI) return;
        PetUser user = event.getUser();
        List<PetType> petArray = user.getOwnedPets();

        PetType type = event.getType();
        ItemBuilder builder = ItemBuilder.fromItem(event.getItem());
        ItemPrice itemPrice = priceMap.getOrDefault(type, DEFAULT_PRICE);
        String price = itemPrice.displayName();
        if (isPetFree(type)) price = ConfigValues.FREE_PRICE.getValue();

        if (ConfigValues.HIDE_PRICE.getValue() && (AddonPermissions.hasPermission(this, event.getUser().getPlayer(), typePermissions.get(type))))
            price = ConfigValues.BYPASSED_PRICE.getValue();
        boolean contains = petArray.contains(type);

        int total = Arrays.stream(user.getPlayer().getInventory().getContents())
                .filter(Objects::nonNull)
                .filter(i -> (i.getType() == itemPrice.material()) && (itemPrice.customModelData() == -1 || i.getItemMeta().getCustomModelData() == itemPrice.customModelData()))
                .mapToInt(ItemStack::getAmount).sum();

        for (String line : lore)
            builder.addLore(line
                    .replace("{type}", type.getName())
                    .replace("{current-total}", String.valueOf(total))
                    .replace("{cost}", String.valueOf(itemPrice.count()))
                    .replace("{purchased}", String.valueOf(var(contains)))
                    .replace("{cost-display}", price)
            );

        event.setItem(builder.build());
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSelect(PetSelectTypeEvent event) {
        if (!isEnabled()) return;
        // if (AddonPermissions.hasPermission(this, event.getUser().getPlayer(), typePermissions.get(event.getPetType()))) return;

        ItemPrice price = priceMap.getOrDefault(event.getPetType(), DEFAULT_PRICE);
        if ((price == null) || !price.enabled()) return; // The pet is free, return

        PetUser user = event.getUser();
        // If player already owns the pet ignore
        if (user.getOwnedPets().contains(event.getPetType())) return;

        int total = Arrays.stream(user.getPlayer().getInventory().getContents())
                .filter(Objects::nonNull)
                .filter(i -> (i.getType() == price.material()) && (price.customModelData() == -1 || i.getItemMeta().getCustomModelData() == price.customModelData()))
                .mapToInt(ItemStack::getAmount).sum();

        if (total < price.count()) {
            event.setCancelled(true);
            user.getPlayer().sendMessage(Colorize.translateBungeeHex(ConfigValues.INSUFFICIENT_FUNDS_MESSAGE.getValue())
                    .replace("{cost-display}", price.displayName())
                    .replace("{type}", event.getPetType().getName())
                    .replace("{current-total}", String.valueOf(total))
                    .replace("{cost}", String.valueOf(price.count()))
            );
            return;
        }

        // Checks if PayPerUse is enabled, if it is not add the pet to the players purchased list
        if (ConfigValues.PAY_PER_USE.getValue()) {
            remove(price, event.getUser().getPlayer().getInventory());
            user.getPlayer().sendMessage(Colorize.translateBungeeHex(ConfigValues.PER_USE_PURCHASE_MESSAGE.getValue())
                    .replace("{cost-display}", price.displayName())
                    .replace("{type}", event.getPetType().getName())
                    .replace("{current-total}", String.valueOf(total))
                    .replace("{cost}", String.valueOf(price.count()))
            );
            return;
        }

        // withdraw money, and add pet to the players purchased list
        user.addOwnedPet(event.getPetType());
        remove(price, event.getUser().getPlayer().getInventory());
        user.getPlayer().sendMessage(Colorize.translateBungeeHex(ConfigValues.ONE_TIME_PURCHASE_MESSAGE.getValue())
                .replace("{cost-display}", price.displayName())
                .replace("{type}", event.getPetType().getName())
                .replace("{current-total}", String.valueOf(total))
                .replace("{cost}", String.valueOf(price.count()))
        );
        user.updateSelectionMenu();
    }



    private static int remove(ItemPrice price, Inventory inventory) {
        int amountLeft = price.count();

        for (int currentSlot = 0; currentSlot < getStorageContents(inventory).length && amountLeft > 0; currentSlot++) {
            ItemStack currentItem = inventory.getItem(currentSlot);

            if ((currentItem != null)
                    && (currentItem.getType() == price.material())
                    && ((price.customModelData() == -1) || (currentItem.getItemMeta().getCustomModelData() == price.customModelData()))) {
                int neededToRemove = Math.min(currentItem.getAmount(), amountLeft);

                currentItem.setAmount(currentItem.getAmount() - neededToRemove);
                inventory.setItem(currentSlot, currentItem);

                amountLeft -= neededToRemove;
            }
        }
        return amountLeft;
    }

    private static ItemStack[] getStorageContents(Inventory inventory) {
        if (legacyContents == null) {
            try {
                inventory.getStorageContents();
                legacyContents = false;
            } catch (NoSuchMethodError e) {
                legacyContents = true;
            }
        }

        return legacyContents ? inventory.getContents() : inventory.getStorageContents();
    }
}
