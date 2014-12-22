package mod.md.item;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class DeviceScreen extends GuiScreen {
	
	JFrame dev;
	DeviceScreen scr = this;
	
	public DeviceScreen() {
		dev = new JFrame();
		init();
		dev.setVisible(false);
	}

	private void init() {
		dev.setUndecorated(true);
		dev.setSize(sx(), sy());
		dev.setLocationRelativeTo(null);
		dev.setBackground(new Color(15 ,15, 15));
		dev.addFocusListener(fl);
		dev.setLayout(new BorderLayout());
	}
	
	private final int sx() {
		return 350;
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	private final int sy() {
		return 600;
	}
	
	@Override
	public void onGuiClosed() {
		dev.setVisible(false);
	}
	
	private FocusListener fl = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			dev.setVisible(false);
			mc.thePlayer.closeScreen();
		}
		
	};
	
	public void displayNow() {
		dev.setVisible(true);
		dev.requestFocus();
	}
	
}
