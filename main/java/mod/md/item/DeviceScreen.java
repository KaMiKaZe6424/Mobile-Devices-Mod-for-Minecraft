package mod.md.item;

import javax.swing.JFrame;

import net.minecraft.client.gui.GuiScreen;

public class DeviceScreen extends GuiScreen {
	
	JFrame dev;
	
	public DeviceScreen() {
		dev = new JFrame();
		init();
		dev.setVisible(true);
	}

	private void init() {
		dev.setUndecorated(true);
		dev.setSize(sx(), sy());
		dev.setLocationRelativeTo(null);
	}
	
	private final int sx() {
		return 350;
	}
	
	private final int sy() {
		return 600;
	}
	
}
