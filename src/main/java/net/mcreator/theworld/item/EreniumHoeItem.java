
package net.mcreator.theworld.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.theworld.itemgroup.KaldockItemGroup;
import net.mcreator.theworld.TheWorldModElements;

@TheWorldModElements.ModElement.Tag
public class EreniumHoeItem extends TheWorldModElements.ModElement {
	@ObjectHolder("the_world:erenium_hoe")
	public static final Item block = null;
	public EreniumHoeItem(TheWorldModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1630;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EreniumIngotItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(KaldockItemGroup.tab)) {
		}.setRegistryName("erenium_hoe"));
	}
}
