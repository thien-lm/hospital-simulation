package entity;

import com.badlogic.gdx.physics.box2d.World;

import screen.GameScreen;
/*created by thienepzai*/
public class TestMainPlayer extends BodyPhysic{
	//re-define world and b2body make bugs here
	
	public TestMainPlayer() {
		
	}
	
	public TestMainPlayer(World world, GameScreen gameScreen) {
	   super(world, gameScreen);
       super.defineBody();
       
	}
	public TestMainPlayer(World world) {
		  super(world);
	      super.defineBody();
		   
		}
	
	public TestMainPlayer(World world, int i) {
		  super(world); 
		}
	//để đây kẻo bọn m éo hiểu
	@Override
	public void handleInput() {
    super.handleInput();
	}

	

}
