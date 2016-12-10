package com.aowolfie.crystals.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Brandon on 10/24/2016.
 */
public final class ModItems {

    public static Item testItem;

    public static void createItems() {
        testItem = register(new ItemBase("testItem").setCreativeTab(CreativeTabs.BREWING));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if(item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }

}
