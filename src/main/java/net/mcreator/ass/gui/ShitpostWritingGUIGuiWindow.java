
package net.mcreator.ass.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ShitpostWritingGUIGuiWindow extends ContainerScreen<ShitpostWritingGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ShitpostWritingGUIGui.guistate;
	TextFieldWidget text1;
	TextFieldWidget text2;
	TextFieldWidget text3;
	TextFieldWidget text4;
	TextFieldWidget text5;
	TextFieldWidget text6;
	public ShitpostWritingGUIGuiWindow(ShitpostWritingGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("ass:textures/shitpost_writing_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		text1.render(ms, mouseX, mouseY, partialTicks);
		text2.render(ms, mouseX, mouseY, partialTicks);
		text3.render(ms, mouseX, mouseY, partialTicks);
		text4.render(ms, mouseX, mouseY, partialTicks);
		text5.render(ms, mouseX, mouseY, partialTicks);
		text6.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (text1.isFocused())
			return text1.keyPressed(key, b, c);
		if (text2.isFocused())
			return text2.keyPressed(key, b, c);
		if (text3.isFocused())
			return text3.keyPressed(key, b, c);
		if (text4.isFocused())
			return text4.keyPressed(key, b, c);
		if (text5.isFocused())
			return text5.keyPressed(key, b, c);
		if (text6.isFocused())
			return text6.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		text1.tick();
		text2.tick();
		text3.tick();
		text4.tick();
		text5.tick();
		text6.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "WRITE YOUR FUNNY SHIT", 6, 7, -12829636);
		this.font.drawString(ms, "IN THE TEXT FIELDS BELOW", 5, 19, -12829636);
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
		text1 = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 32, 120, 20, new StringTextComponent("FUNNY SHIT HERE")) {
			{
				setSuggestion("FUNNY SHIT HERE");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("FUNNY SHIT HERE");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("FUNNY SHIT HERE");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:text1", text1);
		text1.setMaxStringLength(32767);
		this.children.add(this.text1);
		text2 = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 52, 120, 20, new StringTextComponent(""));
		guistate.put("text:text2", text2);
		text2.setMaxStringLength(32767);
		this.children.add(this.text2);
		text3 = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 72, 120, 20, new StringTextComponent(""));
		guistate.put("text:text3", text3);
		text3.setMaxStringLength(32767);
		this.children.add(this.text3);
		text4 = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 92, 120, 20, new StringTextComponent(""));
		guistate.put("text:text4", text4);
		text4.setMaxStringLength(32767);
		this.children.add(this.text4);
		text5 = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 112, 120, 20, new StringTextComponent(""));
		guistate.put("text:text5", text5);
		text5.setMaxStringLength(32767);
		this.children.add(this.text5);
		text6 = new TextFieldWidget(this.font, this.guiLeft + 5, this.guiTop + 132, 120, 20, new StringTextComponent(""));
		guistate.put("text:text6", text6);
		text6.setMaxStringLength(32767);
		this.children.add(this.text6);
	}
}
