
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
public class OniumHoeItem extends TheWorldModElements.ModElement {
	@ObjectHolder("the_world:onium_hoe")
	public static final Item block = null;
	public OniumHoeItem(TheWorldModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 2030;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EreniumIngotItem.block, (int) (1)));
			}
		}, -2f, new Item.Properties().group(KaldockItemGroup.tab)) {
		}.setRegistryName("onium_hoe"));
	}
}
