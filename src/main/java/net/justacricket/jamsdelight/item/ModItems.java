package net.justacricket.jamsdelight.item;

import net.justacricket.jamsdelight.item.custom.*;
import net.justacricket.jamsdelight.JamsDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import static net.ribs.vintagedelight.item.ModItems.bottleItem;

public class ModItems {

    public static final RegistryObject<Item> MELON_JAM;
    public static final RegistryObject<Item> MELON_JAM_BOTTLE;


    public static final DeferredRegister<Item> ITEMS;

    static{
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JamsDelight.MOD_ID);
        MELON_JAM = ITEMS.register("melon_mason_jam",
                MelonJamItem::new);
        MELON_JAM_BOTTLE = ITEMS.register("melon_jam_bottle",
                () -> new ConsumableItem(bottleItem(ModFoods.MELON_JAM_BOTTLE), true));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
