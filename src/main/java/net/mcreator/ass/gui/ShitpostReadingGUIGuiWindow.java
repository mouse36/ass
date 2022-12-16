
package net.mcreator.ass.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.ass.AssMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ShitpostReadingGUIGuiWindow extends ContainerScreen<ShitpostReadingGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ShitpostReadingGUIGui.guistate;
	public ShitpostReadingGUIGuiWindow(ShitpostReadingGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Funny shit from " + (entity.getPersistentData().getString("name")) + "", -119, -31, -1);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("shitpost1")) + "", -117, -3, -1);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("shitpost2")) + "", -117, 13, -1);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("shitpost3")) + "", -117, 29, -1);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("shitpost4")) + "", -117, 45, -1);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("shitpost5")) + "", -117, 61, -1);
		this.font.drawString(ms, "" + (entity.getPersistentData().getString("shipost6")) + "", -117, 76, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 132, this.guiTop + 126, 55, 20, new StringTextComponent("AW MAN"), e -> {
			if (true) {
				AssMod.PACKET_HANDLER.sendToServer(new ShitpostReadingGUIGui.ButtonPressedMessage(0, x, y, z));
				ShitpostReadingGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
