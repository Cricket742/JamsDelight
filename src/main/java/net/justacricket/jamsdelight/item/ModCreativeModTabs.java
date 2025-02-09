package net.justacricket.jamsdelight.item;

import net.justacricket.jamsdelight.JamsDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JamsDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JAMS_TAB = CREATIVE_MODE_TABS.register("jams_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.jams_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.MELON_JAM.get());
                        pOutput.accept(ModItems.MELON_JAM_BOTTLE.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
