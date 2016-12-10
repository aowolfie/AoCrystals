package com.aowolfie.crystals.blocks;


import com.aowolfie.crystals.items.ItemModelProvider;
import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Brandon on 10/27/2016.
 */
public class ModBlocks {

    public static Block testBlock;

    public static void createBlocks(){
        testBlock = register(new BlockBase(Material.ROCK,"testBlock").setCreativeTab(CreativeTabs.BREWING));
    }

    private static <T extends Block> T register (T block, ItemBlock itemBlock) {

        GameRegistry.register(block);
        if(itemBlock != null) {
            GameRegistry.register(itemBlock);
        }

        if(block instanceof ItemModelProvider) {
            ((ItemModelProvider)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
