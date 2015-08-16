package ayamitsu.popupvillagerhead;

import ayamitsu.popupvillagerhead.entity.EntityPoppedupVillagerHead;
import ayamitsu.popupvillagerhead.event.AttackedVillagerHandler;
import ayamitsu.popupvillagerhead.event.SpawnVillagerHandler;
import ayamitsu.popupvillagerhead.network.PacketHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(
        modid = PopupVillagerHead.MODID,
        name = PopupVillagerHead.NAME,
        version = PopupVillagerHead.VERSION
)
public class PopupVillagerHead {

    public static final String MODID = "popupvillagerhead";
    public static final String NAME = "PopupVillagerHead";
    public static final String VERSION = "1.1.0";

    @Mod.Instance(PopupVillagerHead.MODID)
    public static PopupVillagerHead instance;

    @SidedProxy(clientSide = "ayamitsu.popupvillagerhead.client.ClientProxy", serverSide = "ayamitsu.popupvillagerhead.server.ServerProxy")
    public static AbstractProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        EntityRegistry.registerModEntity(EntityPoppedupVillagerHead.class, "PoppedupVillagerHead", 0, this, 80, 3, true);

        MinecraftForge.EVENT_BUS.register(new AttackedVillagerHandler());
        MinecraftForge.EVENT_BUS.register(new SpawnVillagerHandler());

        PacketHandler.init();
        this.proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        this.proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        this.proxy.postInit();
    }

}
