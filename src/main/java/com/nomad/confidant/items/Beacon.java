package com.nomad.confidant.items;

import com.nomad.confidant.entity.BeaconTile;
import com.nomad.confidant.init.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class Beacon extends Block implements EntityBlock {
    public Beacon(Block.Properties prop){
        super(prop);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return Register.BEACON.get().create(pos, state);
    }
    public <T extends BlockEntity>BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityTicker<T> type){
        return type == Register.BEACON.get() ? BeaconTile::tick : null;
    }
}
