
package net.mcreator.theworld.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.theworld.itemgroup.KaldockItemGroup;
import net.mcreator.theworld.TheWorldModElements;

@TheWorldModElements.ModElement.Tag
public class EreniumChestplateItem extends TheWorldModElements.ModElement {
	@ObjectHolder("the_world:erenium_chestplate")
	public static final Item block = null;
	public EreniumChestplateItem(TheWorldModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(KaldockItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("erenium_chestplate");
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
	}
}
