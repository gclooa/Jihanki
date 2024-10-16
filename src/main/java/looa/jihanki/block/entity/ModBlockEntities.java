package looa.jihanki.block.entity;

import looa.jihanki.Jihanki;
import looa.jihanki.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<VendingMachineBlockEntity> VENDING_MACHINE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Jihanki.MOD_ID, "vending_machine_block_entity"),
                    FabricBlockEntityTypeBuilder.create(VendingMachineBlockEntity::new,
                            ModBlocks.VENDING_MACHINE).build());

    public static void initialize() {
    }
}
