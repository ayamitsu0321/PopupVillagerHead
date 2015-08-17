package ayamitsu.popupvillagerhead.client;

import ayamitsu.popupvillagerhead.AbstractProxy;
import ayamitsu.popupvillagerhead.client.render.RenderPoppedupVillagerHead;
import ayamitsu.popupvillagerhead.client.render.RenderPopupHeadVillager;
import ayamitsu.popupvillagerhead.entity.EntityPoppedupVillagerHead;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by ayamitsu0321 on 2015/08/13.
 */
public class ClientProxy extends AbstractProxy {

    @Override
    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderPopupHeadVillager(this.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPoppedupVillagerHead.class, new RenderPoppedupVillagerHead(this.getMinecraft().getRenderManager()));
    }

    public Minecraft getMinecraft() {
        return FMLClientHandler.instance().getClient();
    }

}
