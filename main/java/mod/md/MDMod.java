package mod.md;

import java.io.File;
import java.util.logging.Level;

import mod.md.block.BlockRouter;
import mod.md.config.ConfigHandler;
import mod.md.config.MDBlocks;
import mod.md.config.MDItms;
import mod.md.config.Recipes;
//import mod.md.config.Items;
import mod.md.item.ItemPDA;
import mod.md.vm.PositionTable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = MDMod.MODID, version = MDMod.VERSION)

public class MDMod
{
    public static final String MODID = "mdmod";
    public static final String VERSION = "1.0";
    
    static PositionTable postab;
    
    MDMod mod = this;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	LogHelper.init();
    	
    	//ConfigHandler.init(event.getSuggestedConfigurationFile());	Works, but has no use yet. TODO Add config-options
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Initializing Mobile Devices Mod...");
        
        postab = new PositionTable();
        
        registerBlocks();
        
        MDItms.registerItems();
        
        //Recipes.addRecipes();
        
        LogHelper.info("Mobile Devices initialized.");
    }
    
    public static final CreativeTabs tabMD = new CreativeTabs("mobiledevices")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return MDItms.PDA;
        }
    };
    
    
    public static PositionTable getPositionTable() {
    	return postab;
    }
    
    private void registerItems() {
    	GameRegistry.registerItem(new ItemPDA().setCreativeTab(CreativeTabs.tabMisc).setTextureName("mdmod:PDA_1").setUnlocalizedName("PDA").setMaxStackSize(1), "PDA_1");
    }
    
    private void registerBlocks() {
    	GameRegistry.registerBlock(BlockRouter.newInstance().setBlockName("Wireless Router").setCreativeTab(CreativeTabs.tabMisc).setBlockTextureName("mdmod:Router"), "Wireless Router");
    }
    
}
