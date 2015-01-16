package mod.md.config;

import mod.md.MDMod;
import mod.md.block.BlockRouter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.registry.GameData;

public class MDBlocks {
	
	public static final RegistryNamespaced blockRegistry = GameData.getBlockRegistry();
	
	public static void registerBlocks() {
		
		blockRegistry.addObject(998, "Wireless Router", (BlockRouter.newInstance().setBlockName("Wireless Router").setCreativeTab(MDMod.tabMD).setBlockTextureName("mdmod:Router")));
		
	}

}
