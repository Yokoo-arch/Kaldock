
package net.mcreator.theworld.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.theworld.itemgroup.KaldockItemGroup;
import net.mcreator.theworld.TheWorldModElements;

@TheWorldModElements.ModElement.Tag
public class OniumSwordItem extends TheWorldModElements.ModElement {
	@ObjectHolder("the_world:onium_sword")
	public static final Item block = null;
	public OniumSwordItem(TheWorldModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
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
				return 3;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EreniumIngotItem.block, (int) (1)));
			}
		}, 3, -2f, new Item.Properties().group(KaldockItemGroup.tab)) {
		}.setRegistryName("onium_sword"));
	}
}
