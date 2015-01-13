package mod.mobiledevices.blocks.src;

import mod.mobiledevices.blocks.BlockRouter;
import net.minecraft.world.World;

public class RouterLocationLink {
	
	private String id;
	
	private int x, y, z;
	
	public RouterLocationLink(BlockRouter router) {
		id = router.getID();
		x = router.getX();
		y = router.getY();
		z = router.getZ();
	}
	
	public String getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
}
