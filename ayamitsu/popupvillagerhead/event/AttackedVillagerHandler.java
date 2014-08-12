package ayamitsu.popupvillagerhead.event;

import ayamitsu.popupvillagerhead.client.render.RenderPopupHeadVillager;
import ayamitsu.popupvillagerhead.entity.EntityPoppedupVillagerHead;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class AttackedVillagerHandler {

    public AttackedVillagerHandler() {
    }

    @SubscribeEvent
    public void f(AttackEntityEvent event) {
        // target's render class must be 'RenderPopupHeadVillager'
        if (event.target != null && event.target instanceof EntityVillager && !event.target.getEntityData().getBoolean("PoppedupHead") && RenderManager.instance.getEntityRenderObject(event.target).getClass() == RenderPopupHeadVillager.class) {
            EntityVillager villager = (EntityVillager) event.target;
            NBTTagCompound nbt = event.target.getEntityData();
            nbt.setBoolean("PoppedupHead", true);
            EntityPoppedupVillagerHead head = new EntityPoppedupVillagerHead(event.entityPlayer.worldObj);
            head.setLocationAndAngles(villager.posX, villager.posY, villager.posZ, villager.rotationYaw, villager.rotationPitch);
            head.setVillager(villager);

            if (!event.entityPlayer.worldObj.isRemote) {
                event.entityPlayer.worldObj.spawnEntityInWorld(head);
            }
        }
    }

}
