package net.justacricket.jamsdelight.block;

import net.justacricket.jamsdelight.JamsDelight;
import net.justacricket.jamsdelight.block.custom.mason_jars.MelonJamBlock;
import net.justacricket.jamsdelight.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, JamsDelight.MOD_ID);

 public static final RegistryObject<Block> MELON_JAM_JAR = registerBlock("melon_jam_jar",
                () -> new MelonJamBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
                        .strength(0.3f).sound(SoundType.GLASS)));


//        public static final RegistryObject<Block> BLUEBERRY_JAM_JAR = registerBlock("blueberry_jam_jar",
//                () -> new BlueBerryJamBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
//                        .strength(0.3f).sound(SoundType.GLASS)));


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static void  register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
