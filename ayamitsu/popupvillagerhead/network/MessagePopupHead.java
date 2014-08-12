package ayamitsu.popupvillagerhead.network;

import ayamitsu.popupvillagerhead.PopupVillagerHead;
import ayamitsu.popupvillagerhead.client.ClientProxy;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class MessagePopupHead implements IMessage, IMessageHandler<MessagePopupHead, IMessage> {

    public int entityId = 0;
    public boolean data = false;
    public boolean sent = false;

    public MessagePopupHead() {}

    public MessagePopupHead(EntityVillager villager) {
        this.entityId = villager.getEntityId();
        this.data = villager.getEntityData().getBoolean("PoppedupHead");
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        NBTTagCompound nbt = ByteBufUtils.readTag(buf);
        this.entityId = nbt.getInteger("entityId");
        this.data = nbt.getBoolean("PoppedupHead");

        System.out.println("puts " + this.entityId + this.data);

        for (Entity entity : (List<Entity>)((ClientProxy)PopupVillagerHead.proxy).getWorld().getLoadedEntityList()) {
            if (entity.getEntityId() == this.entityId) {
                entity.getEntityData().setBoolean("PoppedupHead", this.data);
                System.out.println("puts setBoolean");
            }
        }

        System.out.println("puts fromBytes");
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("entityId", this.entityId);
        nbt.setBoolean("PoppedupHead", this.data);
        ByteBufUtils.writeTag(buf, nbt);

        System.out.println("puts toBytes");
    }

    @Override
    public IMessage onMessage(MessagePopupHead message, MessageContext ctx) {
        return null;
    }
}
