package mod.md;

import mod.md.vm.PositionTable;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = MDMod.MODID, version = MDMod.VERSION)
public class MDMod
{
    public static final String MODID = "mdmod";
    public static final String VERSION = "1.0";
    
    PositionTable postab;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Initializing Mobile Devices Mod...");
        postab = new PositionTable();
    }
    
    
}
