
package net.mcreator.ass.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.BlockState;

import net.mcreator.ass.procedures.DispenseDiarrheaBucketProcedure;
import net.mcreator.ass.procedures.DiarrheaBucketDumpingProcedure;
import net.mcreator.ass.AssModElements;

import java.util.Map;
import java.util.HashMap;

@AssModElements.ModElement.Tag
public class DiarrheaBucketItem extends AssModElements.ModElement {
	@ObjectHolder("ass:diarrhea_bucket")
	public static final Item block = null;
	public DiarrheaBucketItem(AssModElements instance) {
		super(instance, 58);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DispenserBlock.registerDispenseBehavior(block, new OptionalDispenseBehavior() {
			public ItemStack dispenseStack(IBlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				World world = blockSource.getWorld();
				Direction direction = blockSource.getBlockState().get(DispenserBlock.FACING);
				int x = blockSource.getBlockPos().getX();
				int y = blockSource.getBlockPos().getY();
				int z = blockSource.getBlockPos().getZ();
				this.setSuccessful(true);
				boolean success = this.isSuccessful();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("direction", direction);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					DispenseDiarrheaBucketProcedure.executeProcedure($_dependencies);
				}
				if (success)
					itemstack.shrink(1);
				return itemstack;
			}
		});
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("diarrhea_bucket");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(Items.BUCKET);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
			ActionResultType retval = super.onItemUseFirst(stack, context);
			World world = context.getWorld();
			BlockPos pos = context.getPos();
			PlayerEntity entity = context.getPlayer();
			Direction direction = context.getFace();
			BlockState blockstate = world.getBlockState(pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			ItemStack itemstack = context.getItem();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("direction", direction);
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				DiarrheaBucketDumpingProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
