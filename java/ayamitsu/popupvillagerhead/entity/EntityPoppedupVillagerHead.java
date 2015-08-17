package ayamitsu.popupvillagerhead.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class EntityPoppedupVillagerHead extends EntityLiving {

    protected int profession = 0;

    public EntityPoppedupVillagerHead(World world) {
        super(world);
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
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
    public boolean interact(EntityPlayer player) {
        this.mountEntity(player);
        return true;
    }

    @Override
    public double getYOffset() {
        return 0.55F;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.ridingEntity != null) {
            if (this.isAIEnabled()) {
                this.setNoAI(true);
            } else {
                this.rotationYaw = this.ridingEntity.rotationYaw;
                this.rotationYawHead = this.ridingEntity.rotationYaw;
                this.rotationPitch = 0F;//this.ridingEntity.rotationPitch;
            }
        } else {
            if (!this.isAIEnabled()) {
                this.setNoAI(false);
            }
        }
    }

    /**
     *  EntityLiving#isAIDisabled がprivateなのでつくった
     * @return is AI enabled
     */
    protected boolean isAIEnabled() {
        return this.dataWatcher.getWatchableObjectByte(15) == 0;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    /*@Override
    public boolean isAIEnabled() {
        return false;
    }*/

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
