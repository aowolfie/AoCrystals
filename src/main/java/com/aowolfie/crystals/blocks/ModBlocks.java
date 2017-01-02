package com.aowolfie.crystals.blocks;


import com.aowolfie.crystals.blocks.tile.TileBreaker;
import com.aowolfie.crystals.items.ItemModelProvider;
import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Brandon on 10/27/2016.
 */
public class ModBlocks {

    public static Block breakerBlock;


    public static void init(){
        createBlocks();
        registerTile();
    }

    public static void createBlocks(){
        breakerBlock = register(new BreakerBlock());
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

    private static void registerTile(){
     registerTile(TileBreaker.class, breakerBlock.getUnlocalizedName());
    }

    private static void registerTile(Class<? extends TileEntity> tile, String string) {
        GameRegistry.registerTileEntity(tile, AoCrystals.MODID + string);
    }
}
