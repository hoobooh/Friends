package com.nomad.confidant.entity;

import com.nomad.confidant.init.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BeaconTile extends BlockEntity {
    public BeaconTile(BlockPos pos, BlockState state) {
        super(Register.BEACON.get(), pos, state);
    }

    boolean isActive = false;
    int timer = 0;
    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T be) {
        BeaconTile tile = (BeaconTile) be;
        //all the actual behavior of the tick, work on this tomorrow
        if (!level.isClientSide() && tile.isActive){
            tile.timer++;
            if (tile.timer > 20){
                tile.timer = 0;

                // only do this once per second
                tile.smiteMobs();
            }
        }
    }
    private void smiteMobs(){ //remember that static means that the method is connected to the whole class, not the object

    }

}
