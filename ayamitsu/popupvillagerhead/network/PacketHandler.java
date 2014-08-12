package ayamitsu.popupvillagerhead.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("PopupVillagerHead");

    public static void init() {
        INSTANCE.registerMessage(MessagePopupHead.class, MessagePopupHead.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(MessagePopupHead.class, MessagePopupHead.class, 1, Side.SERVER);
    }

}
