
package net.mcreator.theworld.block;

import net.minecraft.block.material.Material;

@TheWorldModElements.ModElement.Tag
public class KaldockStoneBlock extends TheWorldModElements.ModElement {

	@ObjectHolder("the_world:kaldock_stone")
	public static final Block block = null;

	public KaldockStoneBlock(TheWorldModElements instance) {
		super(instance, 83);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(KaldockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE));

			setRegistryName("kaldock_stone");
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
