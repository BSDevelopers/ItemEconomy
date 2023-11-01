package addon.brainsynder.itemeconomy.config;

import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface ConfigValues {
    Map<String, ConfigEntry> ENTRIES = new LinkedHashMap<>();

    ConfigEntry<Boolean> HIDE_PRICE = createEntry("Hide-Price-If-Bypassed", true, """
            Disabling this will make the items show the price, but if the player has bypass permissions he wont have to pay
            
            Default: '{default}'
            """);

    ConfigEntry<Boolean> PAY_PER_USE = createEntry("Pay-Per-Use-Enabled", false, """
            Should players have to pay each time they spawn a pet?
            
            Default: '{default}'
            """);

    ConfigEntry<String> FREE_PRICE = createEntry("Price.Free", "FREE", """
            If a pet is free this will be in the place of the price in the lore
            
            Default: '{default}'
            """);
    ConfigEntry<String> BYPASSED_PRICE = createEntry("Price.Bypassed", "BYPASSED", """
            If the player has the bypass permission, will be in the place of the price in the lore
            
            Default: '{default}'
            """);

    ConfigEntry<String> TRUE = createEntry("Boolean.true", "&#92fc98true", "Default: '{default}'");
    ConfigEntry<String> FALSE = createEntry("Boolean.false", "&#fa7d7dfalse", "Default: '{default}'");

    // &eSimplePets &6>>
    ConfigEntry<String> ONE_TIME_PURCHASE_MESSAGE = createEntry("Messages.PurchaseSuccessful.One-Time-Purchase",
            "&eSimplePets &6>> &7You have successfully purchased the {type} pet.", """
            This message will be sent if the purchase it successful
            Placeholders:
            - {type} (will get what type of pet it is)
            - {cost-display} (A custom display of what the pet will cost)
            
            Default: '{default}'
            """);
    ConfigEntry<String> PER_USE_PURCHASE_MESSAGE = createEntry("Messages.PurchaseSuccessful.Pay-Per-Use",
            "&eSimplePets &6>> &7You have successfully paid for the {type} pet.", """
            This message will be sent if the purchase it successful
            Placeholders:
            - {type} (will get what type of pet it is)
            - {cost-display} (A custom display of what the pet will cost)
            
            Default: '{default}'
            """);
    ConfigEntry<String> INSUFFICIENT_FUNDS_MESSAGE = createEntry("Messages.InsufficientFunds",
            "&eSimplePets &6>> &cYou do not have the item(s) to buy this pet, you need to have {cost-display}", """
            This message will be sent if the purchase it successful
            Placeholders:
            - {type} (will get what type of pet it is)
            - {cost-display} (A custom display of what the pet will cost)
            
            Default: '{default}'
            """);

    ConfigEntry<List<String>> ONE_TIME_PURCHASE_LORE = createEntry("Messages.Lore-Lines.One-Time-Purchase",
            Lists.newArrayList(
                    "&#ffbf5ePrice: &#99ffac{cost-display}",
                    "&#ffbf5ePurchased: {purchased}"
            ), """
            These Lore Lines will only be used if 'Pay-Per-Use' is set to false
            Placeholders:
            - {type} (will get what type of pet it is)
            - {cost-display} (A custom display of what the pet will cost)
            - {current-total} (How many of the item the player currently has in their inventory)
            - {cost} (How many of the item the player needs to have to purchase the pet)
            - {purchased} (true/false if the player purchased the pet)
            
            Default: '{default}'
            """);

    ConfigEntry<List<String>> PER_USE_PURCHASE_LORE = createEntry("Messages.Lore-Lines.Pay-Per-Use",
            Lists.newArrayList(
                    "&#ffbf5ePrice: &#99ffac{cost-display}"
            ), """
            These Lore Lines will only be used if 'Pay-Per-Use' is set to true
            Placeholders:
            - {type} (will get what type of pet it is)
            - {cost-display} (A custom display of what the pet will cost)
            - {current-total} (How many of the item the player currently has in their inventory)
            - {cost} (How many of the item the player needs to have to purchase the pet)
            - {purchased} (true/false if the player purchased the pet)
            
            Default: '{default}'
            """);

    private static <T> ConfigEntry<T> createEntry(String key, T value, String description) {
        ConfigEntry<T> option = new ConfigEntryImpl<>(key, value, description);
        ENTRIES.put(key, option);
        return option;
    }
    private static <T> ConfigEntry<T> createEntry(String key, T value) {
        ConfigEntry<T> option = new ConfigEntryImpl<>(key, value);
        ENTRIES.put(key, option);
        return option;
    }
}