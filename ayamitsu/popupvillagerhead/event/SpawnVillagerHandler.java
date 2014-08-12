package ayamitsu.popupvillagerhead.event;

import ayamitsu.popupvillagerhead.network.MessagePopupHead;
import ayamitsu.popupvillagerhead.network.PacketHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class SpawnVillagerHandler {

    public SpawnVillagerHandler() {}

    @SubscribeEvent
    public void f(LivingEvent.LivingUpdateEvent event) {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityVillager && event.entity.getEntityData().getBoolean("PoppedupHead")) {
            EntityVillager villager = (EntityVillager)event.entity;
            this.synchronizeNBT(villager);
        }
    }

    public void synchronizeNBT(EntityVillager villager) {
        PacketHandler.INSTANCE.sendToServer(new MessagePopupHead(villager));// TODO
    }

}
