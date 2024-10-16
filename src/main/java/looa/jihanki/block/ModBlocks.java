package looa.jihanki.block;

import looa.jihanki.Jihanki;
import looa.jihanki.block.entity.VendingMachine;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static looa.jihanki.item.ModItems.JIHANKI_ITEM_GROUP_KEY;

public class ModBlocks {
    public static Block register(Block block, String id, boolean shouldRegisterItem){
        Identifier blockID = new Identifier(Jihanki.MOD_ID, id);
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, blockID, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockID, block);
    }

    public static final Block DIRTY_CONCRETE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)), "dirty_concrete", true
    );
    public static final Block OLD_CONCRETE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)), "old_concrete", true
    );
    public static final Block RETAINING_WALL = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)), "retaining_wall", true
    );
    public static final Block VENDING_MACHINE = register(
            new VendingMachine(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.STONE)), "vending_machine", true
    );
    public static final Block VENDING_MACHINE_WHITE = register(
            new Block(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.STONE)), "vending_machine_white", true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(JIHANKI_ITEM_GROUP_KEY).register(itemGroup -> {
            // Add to item group.
            itemGroup.add(ModBlocks.DIRTY_CONCRETE.asItem());
            itemGroup.add(ModBlocks.OLD_CONCRETE.asItem());
            itemGroup.add(ModBlocks.RETAINING_WALL.asItem());
            itemGroup.add(ModBlocks.VENDING_MACHINE.asItem());
            itemGroup.add(ModBlocks.VENDING_MACHINE_WHITE.asItem());
        });
    }
}
