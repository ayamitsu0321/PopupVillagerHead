package ayamitsu.popupvillagerhead.network;


import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("PopupVillagerHead");

    public static void init() {
        INSTANCE.registerMessage(MessagePopupHead.class, MessagePopupHead.class, 0, Side.CLIENT);
    }

}
