package game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screen.GameScreen;
/*created by thienepzai*/
public class MyGdxGame extends Game {
	
	private GameScreen gameScreen;
	Music music;
	public SpriteBatch batch;

	
	@Override
	public void create() {
		batch = new SpriteBatch();
        gameScreen = new GameScreen(this);
		setScreen(gameScreen);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("bocbatho.mp3"));
		music.play();
		music.setVolume(10);
		music.setLooping(true);
	}

}
