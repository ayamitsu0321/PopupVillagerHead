package ayamitsu.popupvillagerhead;

import ayamitsu.popupvillagerhead.client.render.RenderPoppedupVillagerHead;
import ayamitsu.popupvillagerhead.client.render.RenderPopupHeadVillager;
import ayamitsu.popupvillagerhead.entity.EntityPoppedupVillagerHead;
import ayamitsu.popupvillagerhead.event.AttackedVillagerHandler;
import ayamitsu.popupvillagerhead.event.SpawnVillagerHandler;
import ayamitsu.popupvillagerhead.network.PacketHandler;
import ayamitsu.util.proxy.AbstractProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.common.MinecraftForge;

@Mod(
        modid = "ayamitsu0321.popupvillagerhead",
        name = "PopupVillagerHead",
        version = "1.0.0"
)
public class PopupVillagerHead {

    @Mod.Instance("ayamitsu.popupvillagerhead")
    public static PopupVillagerHead instance;

    @SidedProxy(clientSide = "ayamitsu.popupvillagerhead.client.ClientProxy", serverSide = "ayamitsu.popupvillagerhead.server.ServerProxy")
    public static AbstractProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderPopupHeadVillager());

        EntityRegistry.registerModEntity(EntityPoppedupVillagerHead.class, "PoppedupVillagerHead", 0, this, 80, 3, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityPoppedupVillagerHead.class, new RenderPoppedupVillagerHead());

        MinecraftForge.EVENT_BUS.register(new AttackedVillagerHandler());
        MinecraftForge.EVENT_BUS.register(new SpawnVillagerHandler());

        PacketHandler.init();
    }

}
