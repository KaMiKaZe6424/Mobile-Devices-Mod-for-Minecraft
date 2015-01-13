package mod.md.item;

import java.awt.Color;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import scala.actors.threadpool.Arrays;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import mod.md.MDMod;
import mod.md.vm.Device;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPDA extends Item {
	
	Minecraft mc = Minecraft.getMinecraft();
	Device dev;
	DeviceScreen scr = new DeviceScreen();
	
	public static File hdp;
	
	private long id;
	
	
	public ItemPDA() {
		dev = scr.getDevice();
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		{
			mc.displayGuiScreen(scr);
			scr.displayNow();
		}
		return stack;
	}
	
}
