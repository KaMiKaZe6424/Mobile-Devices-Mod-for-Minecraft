package mod.md.src;

public class RouterLink {
	
	private String worldName = "";
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	
	public void setWorldName(String name) {
		worldName = name;
	}
	
	public String getWorldName() {
		return worldName;
	}
	
}
