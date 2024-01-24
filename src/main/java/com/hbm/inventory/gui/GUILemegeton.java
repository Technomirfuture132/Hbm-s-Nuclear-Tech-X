package com.hbm.inventory.gui;

import org.lwjgl.opengl.GL11;

import com.hbm.inventory.container.ContainerLemegeton;
import com.hbm.lib.RefStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUILemegeton extends GuiContainer {

	public static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/processing/gui_lemegeton.png");

	public GUILemegeton(InventoryPlayer player) {
		super(new ContainerLemegeton(player));
		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int mX, int mY) {

		Minecraft.getMinecraft().standardGalacticFontRenderer.drawString("Material Upgrade Conversion", 28, 6, 4210752);
		Minecraft.getMinecraft().standardGalacticFontRenderer.drawString("Standard Inventory", 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float inter, int mX, int mY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int left = (this.width - this.xSize) / 2;
		int top = (this.height - this.ySize) / 2;

		this.drawTexturedModalRect(left, top, 0, 0, this.xSize, this.ySize);

		if(this.inventorySlots.getSlot(0).getHasStack())
			this.drawTexturedModalRect(left + 7, top + 22, 0, 166, 162, 42);
	}
}
