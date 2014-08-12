package ayamitsu.popupvillagerhead.entity;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class EntityPoppedupVillagerHead extends EntityLiving {

    protected int profession = 0;

    public EntityPoppedupVillagerHead(World world) {
        super(world);
        this.setSize(0.6F, 0.625F);// TODO
    }

    public EntityPoppedupVillagerHead(World world, EntityVillager villager) {
        this(world);
        this.setVillager(villager);
    }

    public void setVillager(EntityVillager villager) {
        this.profession = villager.getProfession();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    public boolean isAIEnabled() {
        return false;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
    }

    public int getProfession() {
        return this.profession;
    }
}
