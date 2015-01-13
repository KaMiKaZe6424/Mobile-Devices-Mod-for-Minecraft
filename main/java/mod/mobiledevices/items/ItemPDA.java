package mod.mobiledevices.items;

import java.io.File;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPDA extends Item {
	
	private String id;
	
	private File hd;
	
	public ItemPDA() {
		
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		setID();
		setPath();
	}
	
	private void setPath() {
		File path = new File(Minecraft.getMinecraft().theWorld.getSaveHandler().getWorldDirectory().getAbsolutePath() + "MobileDevices/HDs");
		path.mkdirs();
		hd = new File(path.getAbsolutePath() + id);
	}
	
	private void setID() {
		Date date = new Date();
		id = new Timestamp(date.getTime()).toString();
	}
}
