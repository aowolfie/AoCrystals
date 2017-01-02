package com.aowolfie.crystals.blocks;
import com.aowolfie.crystals.items.ItemModelProvider;
import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class BlockBase extends Block implements ItemModelProvider {

    protected String name;

    public BlockBase(Material materialIn, String name) {
        super(materialIn);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BREWING);
    }

    @Override
    public void registerItemModel(Item itemBlock) {
        AoCrystals.proxy.registerItemRenderer(itemBlock, 0, name);

    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}