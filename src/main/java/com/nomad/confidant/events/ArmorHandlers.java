package com.nomad.confidant.events;

import com.nomad.confidant.util.ArmorEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorHandlers {
    @SubscribeEvent
    public static void armorAttackHandler(LivingDamageEvent event){
        for (ItemStack armor : event.getEntityLiving().getArmorSlots()){
            if (armor.getItem() instanceof ArmorEvent.IDamageHandlingArmor){
                float newDamage = ((ArmorEvent.IDamageHandlingArmor)armor.getItem()).onDamaged(event.getEntityLiving(), armor.getEquipmentSlot(), event.getSource(), event.getAmount());
                event.setAmount(newDamage);
            }
        }
    }
}
