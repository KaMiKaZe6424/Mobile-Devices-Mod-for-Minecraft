package mod.md.config;

import mod.md.MDMod;
import mod.md.item.ItemPDA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.registry.GameData;

public class MDItms extends Item {
	
	public static final RegistryNamespaced itemRegistry = GameData.getItemRegistry();
	public static Item PDA = new ItemPDA().setCreativeTab(CreativeTabs.tabMisc).setTextureName("mdmod:PDA_1").setUnlocalizedName("PDA").setMaxStackSize(1);

	public static void registerItems() {
	
		itemRegistry.addObject(999, "pda", (new ItemPDA().setCreativeTab(MDMod.tabMD).setTextureName("mdmod:PDA_1").setUnlocalizedName("PDA").setMaxStackSize(1)));
		
	}

	public static void MDItms() {
		// TODO Auto-generated method stub
		
	}
	
}
