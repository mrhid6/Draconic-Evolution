package com.brandon3055.draconicevolution.common.plugins.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.GuiRecipe;
import com.brandon3055.draconicevolution.client.gui.GUIDraconiumChest;
import com.brandon3055.draconicevolution.common.utills.LogHelper;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;

/**
 * Created by Brandon on 30/10/2014.
 */
public class CraftingChestStackPositioner implements IStackPositioner
{

	@Override
	public ArrayList<PositionedStack> positionStacks (ArrayList<PositionedStack> stacks)
	{

		if (Minecraft.getMinecraft().currentScreen instanceof GuiRecipe)
		{
			GuiRecipe recipeGui = (GuiRecipe) Minecraft.getMinecraft().currentScreen;

			if (!(recipeGui.firstGui instanceof GUIDraconiumChest))
			{
				LogHelper.error("No CraftingStationGui found!");
				return stacks;
			}

			GUIDraconiumChest gui = (GUIDraconiumChest) recipeGui.firstGui;

			int offsetX = 309;
			int offsetY = 182;

			for (PositionedStack stack : stacks)
			{
				LogHelper.info(stack.relx + " " + stack.rely + " " + stack.item);
				stack.relx += offsetX;
				stack.rely += offsetY;
			}
		}

		return stacks;
	}

}
