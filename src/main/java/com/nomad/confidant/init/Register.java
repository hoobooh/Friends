package com.nomad.confidant.init;

import com.nomad.confidant.Confidant;
import com.nomad.confidant.items.EffectStaff;
import com.nomad.confidant.items.FuelItem;
import com.nomad.confidant.items.TeleportStaff;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        ENTITIES.register(bus);
    }
    //BLOCKS
    public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block",
            () -> new Block(Block.Properties.of(Material.DIRT).requiresCorrectToolForDrops().strength(10,10000).lightLevel((state) -> 3)));
    //ITEMS
    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(Setup.ModCreativeTab.instance)));
    //
    public static final RegistryObject<Item> CHIMKEN = ITEMS.register("chimken",
            () -> new Item(new Item.Properties().tab(Setup.ModCreativeTab.instance)
                    .food(new FoodProperties.Builder().nutrition(-2).saturationMod(20).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 2), 0.3F).build())));
    //
    public static final RegistryObject<Item> FUEL = ITEMS.register("gas",
            () -> new FuelItem(new Item.Properties().tab(Setup.ModCreativeTab.instance),1000));
    //
    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("ender_staff",
            () -> new TeleportStaff(new Item.Properties().tab(Setup.ModCreativeTab.instance).durability(20)));
    //
    public static final RegistryObject<Item> EFFECT_STAFF = ITEMS.register("effect_staff",
            () -> new EffectStaff(new Item.Properties().tab(Setup.ModCreativeTab.instance).durability(20)));
    //ENTITIES
    }
