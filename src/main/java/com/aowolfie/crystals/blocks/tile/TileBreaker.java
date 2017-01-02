package com.aowolfie.crystals.blocks.tile;

import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Brandon on 12/31/2016.
 */
public class TileBreaker extends TileBase {

    private boolean beenPowered;
    private boolean jobsDone;
    private List<ItemStack> itemsCollected;
    private static int tickTiming = 2; //The timing of each layer breaking, creates a collapsing effect

    public TileBreaker(){

    }

    @Override
    public void update() {


            if (!worldObj.isRemote){
                if (worldObj.isBlockIndirectlyGettingPowered(this.getPos()) > 0){

                }
            }
    }


}
