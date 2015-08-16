package ayamitsu.popupvillagerhead.client.renderer;

import ayamitsu.popupvillagerhead.PopupVillagerHead;
import ayamitsu.popupvillagerhead.client.model.ModelSpiderVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class RenderPoppedupVillagerHead extends RenderLiving {

    private static final ResourceLocation spiderVillagerTextures = new ResourceLocation(PopupVillagerHead.MODID, "textures/entity/spider_villager.png");

    @SuppressWarnings("unchecked")
    public RenderPoppedupVillagerHead(RenderManager manager) {
        super(manager, new ModelSpiderVillager(), 0.25F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return spiderVillagerTextures;
    }
}
