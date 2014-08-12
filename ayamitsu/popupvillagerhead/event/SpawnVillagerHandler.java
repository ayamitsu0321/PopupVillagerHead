package ayamitsu.popupvillagerhead.event;

import ayamitsu.popupvillagerhead.network.MessagePopupHead;
import ayamitsu.popupvillagerhead.network.PacketHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class SpawnVillagerHandler {

    public SpawnVillagerHandler() {}

    public void synchronizeNBT(EntityVillager villager) {
        PacketHandler.INSTANCE.sendToAll(new MessagePopupHead(villager));
    }

    @SubscribeEvent
    public void g(LivingEvent.LivingUpdateEvent event) {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityVillager && event.entity.getEntityData().hasKey("PoppedupHead") && event.entity.getEntityData().getBoolean("PoppedupHead")) {
            EntityVillager villager = (EntityVillager) event.entity;
            this.synchronizeNBT(villager);
        }
    }

}
