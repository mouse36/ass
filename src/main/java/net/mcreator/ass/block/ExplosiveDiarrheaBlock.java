
package net.mcreator.ass.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.ass.AssModElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@AssModElements.ModElement.Tag
public class ExplosiveDiarrheaBlock extends AssModElements.ModElement {
	@ObjectHolder("ass:explosive_diarrhea")
	public static final Block block = null;
	public ExplosiveDiarrheaBlock(AssModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WATER).sound(SoundType.GROUND).hardnessAndResistance(0f, 0f).setLightLevel(s -> 0)
					.doesNotBlockMovement());
			setRegistryName("explosive_diarrhea");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 6;
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.DIRT;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState blockstate, World world, BlockPos pos, Random random) {
			super.animateTick(blockstate, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 6; ++l) {
					double d0 = (double) ((float) x + 0.5) + (double) (random.nextFloat() - 0.5) * 0.6D;
					double d1 = ((double) ((float) y + 0.7) + (double) (random.nextFloat() - 0.5) * 0.6D) + 0.5;
					double d2 = (double) ((float) z + 0.5) + (double) (random.nextFloat() - 0.5) * 0.6D;
					world.addParticle(ParticleTypes.SPLASH, d0, d1, d2, 0, 0, 0);
				}
		}
	}
}
