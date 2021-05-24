
package net.mcreator.theworld.block;

import net.minecraft.block.material.Material;

@TheWorldModElements.ModElement.Tag
public class ToxicLogBlock extends TheWorldModElements.ModElement {

	@ObjectHolder("the_world:toxic_log")
	public static final Block block = null;

	public ToxicLogBlock(TheWorldModElements instance) {
		super(instance, 85);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(KaldockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.AXE));

			setRegistryName("toxic_log");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
