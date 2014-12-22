package mod.md.item;

import java.awt.Color;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import mod.md.MDMod;
import mod.md.vm.Device;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPDA extends Item {
	
	private boolean isRunning = false;
	Minecraft mc = Minecraft.getMinecraft();
	Device dev;
	
	
	public ItemPDA() {
		dev = new Device();
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		{
			mc.displayGuiScreen(new DeviceScreen());
		}
		return stack;
	}
	
}
