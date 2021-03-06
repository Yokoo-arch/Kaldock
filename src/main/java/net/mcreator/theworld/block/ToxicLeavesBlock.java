
package net.mcreator.theworld.block;

import net.minecraft.block.material.Material;

@TheWorldModElements.ModElement.Tag
public class ToxicLeavesBlock extends TheWorldModElements.ModElement {

	@ObjectHolder("the_world:toxic_leaves")
	public static final Block block = null;

	public ToxicLeavesBlock(TheWorldModElements instance) {
		super(instance, 86);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(KaldockItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("toxic_leaves");
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
