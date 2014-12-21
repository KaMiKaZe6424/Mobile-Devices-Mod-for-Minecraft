package mod.md;

import mod.md.block.BlockRouter;
import mod.md.vm.PositionTable;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MDMod.MODID, version = MDMod.VERSION)
public class MDMod
{
    public static final String MODID = "mdmod";
    public static final String VERSION = "1.0";
    
    static PositionTable postab;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing Mobile Devices Mod...");
        postab = new PositionTable();
        
        registerBlocks();
        
        System.out.println("Mobile Devices initialized.");
    }
    
    public static PositionTable getPositionTable() {
    	return postab;
    }
    
    private void registerBlocks() {
    	GameRegistry.registerBlock(BlockRouter.newInstance().setBlockName("Wireless Router").setCreativeTab(CreativeTabs.tabMisc), "Wireless Router");
    }
    
}
