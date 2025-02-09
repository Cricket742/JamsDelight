package net.justacricket.jamsdelight.block.custom.mason_jars;

import net.justacricket.jamsdelight.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.ribs.vintagedelight.block.custom.MasonJarBlock;

public class MelonJamBlock extends MasonJarBlock {

    public MelonJamBlock(Properties properties) {
        super(properties);
    }
    @Override
    public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.MELON_JAM.get());
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemInHand = player.getItemInHand(hand);
        if (!world.isClientSide && hand == InteractionHand.MAIN_HAND && itemInHand.isEmpty()) {
            int jars = state.getValue(JARS);
            if (jars > 1) {
                world.setBlock(pos, state.setValue(JARS, jars - 1), 3);
                popResource(world, pos, new ItemStack(ModItems.MELON_JAM.get()));
                return InteractionResult.SUCCESS;
            } else if (jars == 1) {
                world.removeBlock(pos, false);
                popResource(world, pos, new ItemStack(ModItems.MELON_JAM.get()));
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, world, pos, player, hand, hit);
    }

}
