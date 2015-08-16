package ayamitsu.popupvillagerhead.event;

import ayamitsu.popupvillagerhead.entity.EntityPoppedupVillagerHead;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class AttackedVillagerHandler {

    public AttackedVillagerHandler() {
    }

    @SubscribeEvent
    public void f(AttackEntityEvent event) {
        // target's renderer class must be 'RenderPopupHeadVillager'
        if (event.target != null && event.target instanceof EntityVillager && !((EntityVillager)event.target).isChild() && !event.target.getEntityData().getBoolean("PoppedupHead")) {
            EntityVillager villager = (EntityVillager)event.target;
            NBTTagCompound nbt = event.target.getEntityData();
            nbt.setBoolean("PoppedupHead", true);
            EntityPoppedupVillagerHead head = new EntityPoppedupVillagerHead(event.entityPlayer.worldObj);
            // hard coding: 1.6F
            head.motionY += 1.6F;
            head.setVillager(villager);

            if (!event.entityPlayer.worldObj.isRemote) {
                // hard coding: 1.175D(1.8F - 0.625F)
                head.setLocationAndAngles(villager.posX, villager.posY + 1.175D, villager.posZ, villager.rotationYaw, villager.rotationPitch);
                event.entityPlayer.worldObj.spawnEntityInWorld(head);
            }
        }
    }

}
