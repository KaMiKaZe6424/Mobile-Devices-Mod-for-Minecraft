package mod.md.item;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;

import mod.md.vm.Device;
import net.minecraft.client.gui.GuiScreen;

public class DeviceScreen extends GuiScreen {
	
	Device dev;
	JPanel bg;
	JPanel screen;
	
	DeviceScreen scr = this;
	
	public DeviceScreen() {
		dev = new Device();
		init();
		dev.setScreen(screen);
		dev.setVisible(false);
	}

	private void init() {
		dev.setUndecorated(true);
		dev.setSize(sx(), sy());
		dev.setLocationRelativeTo(null);
		dev.addFocusListener(fl);
		dev.getContentPane().setBackground(new Color(240 ,240, 240));
		{
			bg = new JPanel();
			dev.add(bg);
			bg.setLayout(null);
			{
				screen = new JPanel();
				bg.add(screen);
				screen.setBounds(10, 10, sx()-20, sy()-60);
				screen.setBackground(Color.black);
			}
		}
	}
	
	private final int sx() {
		return 350;
	}
	
	public Device getDevice() {
		return dev;
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
