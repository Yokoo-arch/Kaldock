
package net.mcreator.theworld.block;

import net.minecraft.block.material.Material;

@TheWorldModElements.ModElement.Tag
public class ToxicGrassBlock extends TheWorldModElements.ModElement {

	@ObjectHolder("the_world:toxic_grass")
	public static final Block block = null;

	public ToxicGrassBlock(TheWorldModElements instance) {
		super(instance, 83);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(KaldockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(0)
					.harvestTool(ToolType.SHOVEL));

			setRegistryName("toxic_grass");
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
