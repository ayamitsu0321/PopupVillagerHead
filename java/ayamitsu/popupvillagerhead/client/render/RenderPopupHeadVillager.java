package ayamitsu.popupvillagerhead.client.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;

/**
 * Created by ayamitsu0321 on 2014/08/11.
 */
public class RenderPopupHeadVillager extends RenderVillager {

    public RenderPopupHeadVillager(RenderManager renderManager) {
        super(renderManager);
    }

    public void doRender(EntityVillager villager, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.func_177134_g().villagerHead.isHidden = this.func_177134_g().villagerNose.isHidden = villager.getEntityData().getBoolean("PoppedupHead");
        super.doRender(villager, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        this.doRender((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
