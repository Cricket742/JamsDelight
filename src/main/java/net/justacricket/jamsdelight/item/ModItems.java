package net.justacricket.jamsdelight.item;

import net.justacricket.jamsdelight.item.custom.*;
import net.justacricket.jamsdelight.JamsDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JamsDelight.MOD_ID);

    public static final RegistryObject<Item> MELON_JAM = ITEMS.register("melon_mason_jar",
            MelonJamItem::new);
//    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
//            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
