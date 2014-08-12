package ayamitsu.popupvillagerhead.client;

import ayamitsu.util.proxy.AbstractClientProxy;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class ClientProxy extends AbstractClientProxy {

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

    }

    @Override
    public void postInit() {

    }

    public WorldClient getWorld() {
        return FMLClientHandler.instance().getWorldClient();
    }
}
