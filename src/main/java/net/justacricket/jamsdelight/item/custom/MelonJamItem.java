package net.justacricket.jamsdelight.item.custom;

import net.justacricket.jamsdelight.block.ModBlocks;
import net.justacricket.jamsdelight.item.ModFoods;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.ribs.vintagedelight.block.custom.MasonJarBlock;
import net.ribs.vintagedelight.item.ModItems;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class MelonJamItem extends ConsumableItem {

    public MelonJamItem() {
        super(ModItems.jarItem(ModFoods.MELON_JAM), true);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.NONE);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = hitResult.getBlockPos();
            Direction direction = hitResult.getDirection();
            BlockPos placePos = player.isCrouching() ? blockPos.relative(direction) : blockPos;
            MasonJarBlock masonJarBlock = (MasonJarBlock) ModBlocks.MELON_JAM_JAR.get();
            BlockState existingState = world.getBlockState(placePos);

            if (existingState.getBlock() instanceof MasonJarBlock && !player.isCrouching()) {
                if (masonJarBlock.tryPlaceJar(world, placePos, player, itemStack)) {
                    return InteractionResultHolder.success(itemStack);
                }
            } else if (player.isCrouching() && existingState.canBeReplaced(new BlockPlaceContext(player, hand, itemStack, hitResult))) {
                Direction facingDirection = player.getDirection().getOpposite();
                world.setBlock(placePos, masonJarBlock.defaultBlockState().setValue(MasonJarBlock.FACING, facingDirection), 3);
                itemStack.shrink(1);
                return InteractionResultHolder.success(itemStack);
            }
        }
        return super.use(world, player, hand);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, world, tooltip, flag);
        tooltip.add(Component.translatable("item.vintagedelight.mason_jar.tooltip")
                .withStyle(ChatFormatting.GRAY)
                .withStyle(style -> style.withItalic(true)));
    }

}
