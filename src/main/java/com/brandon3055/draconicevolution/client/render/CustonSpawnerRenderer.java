package com.brandon3055.draconicevolution.client.render;

/**
 * Created by Brandon on 5/07/2014.
 */

import com.brandon3055.draconicevolution.common.lib.References;
import com.brandon3055.draconicevolution.common.tileentities.CustomSpawnerBaseLogic;
import com.brandon3055.draconicevolution.common.tileentities.TileCustomSpawner;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class CustonSpawnerRenderer extends TileEntitySpecialRenderer
{
	private final ResourceLocation texture = new ResourceLocation(References.MODID.toLowerCase(), "textures/items/draconicCore.png");

	public void renderTileEntityAt(TileCustomSpawner tile, double x, double y, double z, float p_147518_8_)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		renderTile(tile.getBaseLogic(), x, y, z, p_147518_8_);
		GL11.glPopMatrix();
	}

	public void renderTile(CustomSpawnerBaseLogic customSpawnerBaseLogic, double x, double y, double z, float p_147517_7_)
	{
		Tessellator tessellator = Tessellator.instance;

		Entity entity = customSpawnerBaseLogic.getEntityForRenderer();

		if (entity != null)
		{
			GL11.glPushMatrix();
			entity.setWorld(customSpawnerBaseLogic.getSpawnerWorld());
			float f1 = 0.4375F;
			GL11.glTranslatef(0.0F, 0.4F, 0.0F);
			GL11.glRotatef((float) (customSpawnerBaseLogic.renderRotation1 + (customSpawnerBaseLogic.renderRotation0 - customSpawnerBaseLogic.renderRotation1) * (double) p_147517_7_) * 10.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-30.0F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -0.4F, 0.0F);
			GL11.glScalef(f1, f1, f1);
			entity.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
			RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, p_147517_7_);
			GL11.glPopMatrix();
		}
		{
			GL11.glPushMatrix();
			bindTexture(texture);

			tessellator.setColorRGBA(255, 255, 255, 255);
			tessellator.setBrightness(200);

			tessellator.startDrawingQuads();
			tessellator.setNormal(0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-0.5F, 0F, -0.5F);

			tessellator.addVertexWithUV(0, 0.99D, 0, 0, 0);
			tessellator.addVertexWithUV(1, 0.99D, 0, 1, 0);
			tessellator.addVertexWithUV(1, 0.99D, 1, 1, 1);
			tessellator.addVertexWithUV(0, 0.99D, 1, 0, 1);

			tessellator.addVertexWithUV(0, 0.99D, 0, 0, 0);
			tessellator.addVertexWithUV(0, 0.99D, 1, 1, 0);
			tessellator.addVertexWithUV(1, 0.99D, 1, 1, 1);
			tessellator.addVertexWithUV(1, 0.99D, 0, 0, 1);

			tessellator.draw();

			GL11.glPopMatrix();
		}
	}
	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
	{
		this.renderTileEntityAt((TileCustomSpawner)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
	}
}