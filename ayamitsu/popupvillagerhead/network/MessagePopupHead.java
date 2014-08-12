package ayamitsu.popupvillagerhead.network;

import cpw.mods.fml.client.FMLClientHandler;
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
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("entityId", this.entityId);
        nbt.setBoolean("PoppedupHead", this.data);
        ByteBufUtils.writeTag(buf, nbt);
    }

    @Override
    public IMessage onMessage(MessagePopupHead message, MessageContext ctx) {
        for (Entity entity : (List<Entity>)FMLClientHandler.instance().getWorldClient().getLoadedEntityList()) {

            // use param(message)
            if (entity.getEntityId() == message.entityId) {
                entity.getEntityData().setBoolean("PoppedupHead", message.data);
            }
        }

        return null;
    }
}
