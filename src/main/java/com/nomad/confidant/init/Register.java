package com.nomad.confidant.init;

import com.nomad.confidant.Confidant;
import com.nomad.confidant.entity.BeaconTile;
import com.nomad.confidant.items.Beacon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Register {
    //Deferred Registry
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Confidant.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Confidant.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Confidant.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Confidant.MOD_ID);
    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        ENTITIES.register(bus);
        TILE_ENTITY_TYPES.register(bus);
    }
    //BLOCKS
    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block",
            () -> new Block(Block.Properties.of(Material.DIRT).requiresCorrectToolForDrops().strength(10,10000).lightLevel((state) -> 3)));
    public static final RegistryObject<Block> TEST_BEACON = BLOCKS.register("test_beacon",
            () -> new Beacon(Block.Properties.copy(Blocks.DIRT)));
    //TILE ENTITIES
    public static final RegistryObject<BlockEntityType<BeaconTile>> BEACON = TILE_ENTITY_TYPES.register("beacon",
            () -> BlockEntityType.Builder.of(BeaconTile::new, Register.TEST_BEACON.get()).build(null));
    //ITEMS
    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(Setup.ModCreativeTab.instance)));
    //ENTITIES
    }
