package looa.jihanki.item;

import looa.jihanki.Jihanki;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(Jihanki.MOD_ID, id); // Create the identifier for the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item); // Register the item.
        return registeredItem; // Return the registered item!
    }

    public static final RegistryKey<ItemGroup> JIHANKI_ITEM_GROUP_KEY = RegistryKey
            .of(Registries.ITEM_GROUP.getKey(), Identifier.of(Jihanki.MOD_ID, "item_group"));

    public static final ItemGroup JIHANKI_ITEM_GROUP = FabricItemGroup.builder() // Create the custom item group.
            .icon(() -> new ItemStack(ModBlocks.DIRTY_CONCRETE.asItem()))
            .displayName(Text.translatable("itemGroup.jihanki"))
            .build();

    public static final Item ANTIQUE_SWORD = register(
            new SwordItem(AntiqueMaterial.INSTANCE, 5, 95.0F, new FabricItemSettings()), "antique_sword"
    );

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, JIHANKI_ITEM_GROUP_KEY, JIHANKI_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(JIHANKI_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.ANTIQUE_SWORD);  // Add to item group.
        });
    }
}
