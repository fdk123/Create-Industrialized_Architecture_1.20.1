package com.drmangotea.i_architecture.base;

import com.drmangotea.i_architecture.registry.IAItems;
import com.simibubi.create.*;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus;


import java.util.*;

import static com.drmangotea.i_architecture.IndustrializedArchitecture.MOD_ID;
import static com.drmangotea.i_architecture.IndustrializedArchitecture.REGISTRATE;


public class IACreativeTab {
    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);


    public static final RegistryObject<CreativeModeTab> INDUSTRIALIZED_DECOR_TAB = REGISTER.register("industrialized_decor", () -> CreativeModeTab.builder()
                        .title(Component.translatable("creative_tab.i_architecture"))
            .icon(()-> IAItems.INDUSTRIAL_IRON_INGOT.get().asItem().getDefaultInstance())
           // .displayItems(new RegistrateDisplayItemsGenerator(true, TFMGCreativeTabs.TFMG_MAIN))
            .build());


    public static void addCreative(BuildCreativeModeTabContentsEvent event) {


       if(event.getTab() == IACreativeTab.INDUSTRIALIZED_DECOR_TAB.get()){
           event.acceptAll(customAdditions());
           for(RegistryEntry<Item> item : REGISTRATE.getAll(Registries.ITEM)){
//
               event.accept(item.get(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
           }
//
       }


    }



    public static List<ItemStack> customAdditions(){
        List<ItemStack> list = new ArrayList<>();


        return list;
    }

    @ApiStatus.Internal
    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }


}
