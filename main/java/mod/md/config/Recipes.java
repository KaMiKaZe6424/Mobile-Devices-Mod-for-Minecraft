package mod.md.config;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class Recipes {
	
	public static CraftingManager recipeRegistry = CraftingManager.getInstance();

	public static void addRecipes() {
		
		recipeRegistry.addRecipe(new ItemStack(MDItms.PDA, 1), new Object[] {"###", "#A#", "#X#", '#', Blocks.glass_pane, 'A', Items.quartz, 'X', Items.redstone});
		
	}
}
