package com.aowolfie.crystals.blocks;

import com.aowolfie.crystals.items.ItemModelProvider;
import com.aowolfie.crystals.main.AoCrystals;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

/**
 * Created by Brandon on 12/31/2016.
 */
public class TileBlockBase extends BlockContainer implements ItemModelProvider {

    protected String name;


    public TileBlockBase(Material materialIn, String name) {
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
    public TileBlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
