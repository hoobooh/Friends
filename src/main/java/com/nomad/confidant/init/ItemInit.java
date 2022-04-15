package com.nomad.confidant.init;
import com.nomad.confidant.Confidant;
import com.nomad.confidant.items.EffectStaff;
import com.nomad.confidant.items.FuelItem;
import com.nomad.confidant.items.TeleportStaff;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Confidant.MOD_ID);
    //
    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));
    //
    public static final RegistryObject<Item> FRUIT = ITEMS.register("chimken",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)
                    .food(new FoodProperties.Builder().nutrition(-2).saturationMod(20).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 2), 0.3F).build())));
    //
    public static final RegistryObject<Item> FUEL = ITEMS.register("gas",
            () -> new FuelItem(new Item.Properties().tab(ModCreativeTab.instance),1000));
    //
    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("ender_staff",
            () -> new TeleportStaff(new Item.Properties().tab(ModCreativeTab.instance).durability(20)));
    //
    public static final RegistryObject<Item> EFFECT_STAFF = ITEMS.register("effect_staff",
            () -> new EffectStaff(new Item.Properties().tab(ModCreativeTab.instance).durability(20)));
    //
    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.BONE);
        }
        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "confidant");
    }
}
