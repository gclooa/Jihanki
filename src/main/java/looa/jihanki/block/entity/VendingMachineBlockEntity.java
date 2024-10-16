package looa.jihanki.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class VendingMachineBlockEntity extends BlockEntity {
    public VendingMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.VENDING_MACHINE_BLOCK_ENTITY, pos, state);
    }
}
