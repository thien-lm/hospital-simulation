package entity;

import java.net.InetAddress;

import com.badlogic.gdx.physics.box2d.World;

import screen.GameScreen;
/*created by thienepzai*/
public class PlayerMP extends TestMainPlayer{
    
	public String username;
	public InetAddress ipAddress;
	public int port;
	
	public PlayerMP(World world,String username,InetAddress ipAddress, int port,GameScreen Gamescreen) {
		super(world, Gamescreen);
		super.defineBody();
		this.username = username;
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	
	public PlayerMP(String username,InetAddress ipAddress, int port) {
		this.username = username;
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	public PlayerMP(World world,String username,InetAddress ipAddress, int port) {
		super(world);
		this.username = username;
		this.ipAddress = ipAddress;
		this.port = port;
	}
	


	public String getUsername() {
        return this.username;
    }


}
