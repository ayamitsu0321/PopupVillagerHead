package ayamitsu.popupvillagerhead.client.render;

import ayamitsu.popupvillagerhead.entity.EntityPoppedupVillagerHead;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by ayamitsu0321 on 2014/08/12.
 */
public class RenderPoppedupVillagerHead extends RenderLiving {

    private static final ResourceLocation villagerTextures = new ResourceLocation("textures/entity/villager/villager.png");
    private static final ResourceLocation farmerVillagerTextures = new ResourceLocation("textures/entity/villager/farmer.png");
    private static final ResourceLocation librarianVillagerTextures = new ResourceLocation("textures/entity/villager/librarian.png");
    private static final ResourceLocation priestVillagerTextures = new ResourceLocation("textures/entity/villager/priest.png");
    private static final ResourceLocation smithVillagerTextures = new ResourceLocation("textures/entity/villager/smith.png");
    private static final ResourceLocation butcherVillagerTextures = new ResourceLocation("textures/entity/villager/butcher.png");

    protected ModelVillager villagerModel;

    public RenderPoppedupVillagerHead() {
        super(new ModelVillager(0.0F), 0.25F);
        this.villagerModel = (ModelVillager) this.mainModel;

        this.villagerModel.villagerHead.offsetY = 1.5F;
        this.villagerModel.villagerNose.offsetY = 0.03125F;

        for (ModelRenderer model : (List<ModelRenderer>) this.villagerModel.boxList) {
            if (model == this.villagerModel.villagerHead || model == this.villagerModel.villagerNose) {
                continue;
            }

            model.isHidden = true;
        }
    }

    protected ResourceLocation getEntityTexture(EntityPoppedupVillagerHead entity) {
        switch (entity.getProfession()) {
            case 0:
                return farmerVillagerTextures;
            case 1:
                return librarianVillagerTextures;
            case 2:
                return priestVillagerTextures;
            case 3:
                return smithVillagerTextures;
            case 4:
                return butcherVillagerTextures;
            default:
                return VillagerRegistry.getVillagerSkin(entity.getProfession(), villagerTextures);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityPoppedupVillagerHead) entity);
    }
}
