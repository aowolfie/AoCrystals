package com.aowolfie.crystals.blocks.tile;


import com.aowolfie.crystals.blocks.BreakerBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.Collections;
import java.util.Stack;

public class TileBreaker extends TileBase {


    private static final int MAX_LAYERS = 9; // 19x19x19 cube is large enough for now

    private boolean breaking = false;
    private boolean powered = true;

    private int size = 27;
    private int blocksPerBreak, tickDelay;

    private BlockPos startPos;
    Stack<Integer> blockPositions;


    public TileBreaker() {
    }

    @Override
    public void update() {
        if (!worldObj.isRemote) {
            if (breaking && worldObj.getWorldTime() % tickDelay == 0) {
                if (breakCubie()) {
                    breaking = false;
                }
            } else if (powered && worldObj.isBlockIndirectlyGettingPowered(this.getPos()) == 0) {
                powered = false;
            } else if (worldObj.isBlockIndirectlyGettingPowered(this.getPos()) > 0 && !powered) {
                breaking = true;
                powered = true;

                EnumFacing facing = (EnumFacing) worldObj.getBlockState(this.getPos()).getProperties().get(BreakerBlock.FACING);

                if (facing == EnumFacing.UP) {
                    generateCubieNums(this.getPos().add(0, (size / 2) + 1, 0));
                } else if (facing == EnumFacing.DOWN) {
                    generateCubieNums(this.getPos().add(0, -((size / 2) + 1), 0));
                } else if (facing == EnumFacing.SOUTH) {
                    generateCubieNums(this.getPos().add(0, 0, (size / 2) + 1));
                } else if (facing == EnumFacing.NORTH) {
                    generateCubieNums(this.getPos().add(0, 0, -((size / 2) + 1)));
                } else if (facing == EnumFacing.EAST) {
                    generateCubieNums(this.getPos().add((size / 2) + 1, 0, 0));
                } else if (facing == EnumFacing.WEST) {
                    generateCubieNums(this.getPos().add(-((size / 2) + 1), 0, 0));
                } else {
                    System.out.println("Something has gone really wrong.");
                }

            }
        }
    }

    //Check over the calculation for the time delay for each breaking sequence

    private void generateCubieNums(BlockPos center) {
        blockPositions = new Stack<Integer>();
        startPos = new BlockPos(center.getX() + (size / 2), center.getY() + (size / 2), center.getZ() + size / 2);
        blocksPerBreak = (int) (Math.log(size)/Math.log(2));
        tickDelay = (16/size) + 1;
        int numBlocks = (int) Math.pow(size, 3);
        for (int i = 0; i < numBlocks; i++) {
            blockPositions.add(i);
        }

        Collections.shuffle(blockPositions);
    }

    private boolean breakCubie() {
        for (int i = 0; i < blocksPerBreak; i++) {
            if (blockPositions.isEmpty()) {
                return true;
            }
            int blockPos = blockPositions.pop();
            int xMod = blockPos % size;
            int yMod = (blockPos / size) % size;
            int zMod = ((blockPos / size) / size) % size;
            safeBreak(startPos.add(-xMod, -yMod, -zMod), true);
        }
        return false;
    }

    private void safeBreak(BlockPos pos, boolean dropBlock) {
        worldObj.setBlockToAir(pos);
        //worldObj.destroyBlock(pos, false); //Please change back to dropBlock when testing is done :)
    }

}