package mod.md.vm;

import java.awt.Color;
import java.io.File;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import scala.actors.threadpool.Arrays;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import mod.md.item.ItemPDA;
import net.minecraft.client.Minecraft;

public class Device extends JFrame {
	
	private JPanel screen;
	
	public Device() {
		
	}
	
	
	
	public void setScreen(JPanel scr) {
		screen = scr;
		JPanel conn = new JPanel();
		screen.getParent().add(conn);
		conn.setBounds(0, 0, 20, 5);
		conn.setBackground(Color.RED);
	}
	
	
	
	Thread update = new Thread() {
		
		 @Override
		 public void run() {
			 while (true) {
				 if (Minecraft.getMinecraft().theWorld != null) {getID();}
				 try {
					
					update.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }
		 }
		 
		 private void getID() {
			File hdp = ItemPDA.hdp;
		 	hdp = new File(Minecraft.getMinecraft().theWorld.getSaveHandler().getWorldDirectory().getAbsolutePath() + "/MobileDevices/HDs");
			hdp.mkdirs();
			{
				File[] hds = hdp.listFiles();
				Arrays.sort(hds, 0, hds.length-1, new Comparator() {
						@Override
					public int compare(Object o1, Object o2) {
						int n1 = Integer.valueOf(((File) o1).getName());
						int n2 = Integer.valueOf(((File) o2).getName());
						if (n1 < n2) {
							return -1;
						} else {
							return 1;
						}
					}});
				for (File f : hds) {
					System.out.println(f.getName());
				}
			}
		}
		 
		Thread updateSlow = new Thread() {
			@Override
			public void run() {
				
			}
		};
	
	};
	
}
