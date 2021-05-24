
package net.mcreator.theworld.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.theworld.itemgroup.KaldockItemGroup;
import net.mcreator.theworld.TheWorldModElements;

import java.util.List;
import java.util.Collections;

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
