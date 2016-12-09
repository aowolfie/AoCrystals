package com.aowolfie.crystals.items;

import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Brandon on 10/24/2016.
 */
public class BasicItem extends Item{

    public BasicItem(String unlocalizedName){
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.MATERIALS);
        this.setRegistryName(AoCrystals.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
