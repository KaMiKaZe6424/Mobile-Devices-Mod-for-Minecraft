package mod.mobiledevices;

import mod.mobiledevices.blocks.BlockRouter;
import mod.mobiledevices.items.PDA;
import mod.mobiledevices.proxy.MobileDevicesProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = MobileDevices.modid, name = MobileDevices.name, version = MobileDevices.version)
public class MobileDevices {
	
	public static final String modid = "mdmod";
	public static final String name = "Mobile Devices";
	public static final String version = "0.1";
	
	@SidedProxy(clientSide = "mod.mobiledevices.proxy.MobileDevicesClientProxy", serverSide = "mod.mobiledevices.proxy.MobileDevicesProxy")
	public static MobileDevicesProxy proxy;
	
	@Instance(value = modid)
	public MobileDevices instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.registerRenderers();
		
		registerBlocks(e);
		
		
		registerItems(e);
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	
	public void registerBlocks(FMLInitializationEvent e) {
		BlockRouter blockRouter = new BlockRouter();
		
		GameRegistry.registerBlock(blockRouter.setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("blockRouter"), "blockRouter");
		
		if (e.getSide() == Side.CLIENT) {
			System.out.println("Registering Block Icons");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(blockRouter), 0, new ModelResourceLocation(modid + ":" + "blockRouter", "inventory"));
		}
	}
	
	public void registerItems(FMLInitializationEvent e) {
		
		PDA pda = new PDA();
		
		GameRegistry.registerItem(pda, "pda", modid);
		
		if (e.getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(pda.setCreativeTab(CreativeTabs.tabMisc), 0, new ModelResourceLocation(modid + ":" + "pda", "inventory"));
		}
	}
	
}
