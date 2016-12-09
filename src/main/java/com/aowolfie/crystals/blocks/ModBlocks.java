package com.aowolfie.crystals.blocks;


import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Brandon on 10/27/2016.
 */
public class ModBlocks {

    public static Block testBlock;
    public static ItemBlock testBlockItem;

    public static void createBlocks(){
        GameRegistry.register(testBlockItem = (ItemBlock) new ItemBlock(testBlock = new BasicBlock("testBlock")).setRegistryName(AoCrystals.MODID + ":" + "testItemBlock"));
    }
}
