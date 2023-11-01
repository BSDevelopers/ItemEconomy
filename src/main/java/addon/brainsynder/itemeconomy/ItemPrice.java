package addon.brainsynder.itemeconomy;

import org.bukkit.Material;

public record ItemPrice (boolean enabled, Material material, int count, String displayName, int customModelData) {
}
