package com.aowolfie.crystals.blocks;

import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Brandon on 10/27/2016.
 */
public class BasicBlock extends Block  {

    public BasicBlock(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.BREWING);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setRegistryName(AoCrystals.MODID + ":" + this.getUnlocalizedName().substring(5));
    }

    public BasicBlock(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.ROCK, hardness, resistance);
    }

    public BasicBlock(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }


}
