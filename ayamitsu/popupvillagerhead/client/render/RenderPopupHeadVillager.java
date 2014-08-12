package ayamitsu.popupvillagerhead.client.render;

import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;

/**
 * Created by ayamitsu0321 on 2014/08/11.
 */
public class RenderPopupHeadVillager extends RenderVillager {

    public RenderPopupHeadVillager() {
        super();
    }

    /*public void doRender(EntityPopupVillagerHead villager, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.villagerModel.villagerHead.isHidden = this.villagerModel.villagerNose.isHidden = !villager.isPoppedHead();
        super.doRender(villager, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }*/

    @Override
    public void doRender(EntityVillager villager, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        //this.doRender((EntityPopupVillagerHead)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
        this.villagerModel.villagerHead.isHidden = this.villagerModel.villagerNose.isHidden = villager.getEntityData().getBoolean("PoppedupHead");
        super.doRender(villager, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
