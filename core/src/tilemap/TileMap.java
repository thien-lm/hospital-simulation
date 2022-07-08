package tilemap;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
/*created by thienepzai using happycodings tutorial*/
public class TileMap {
	
	 TmxMapLoader maploader;
	 private TiledMap map;
	 private OrthogonalTiledMapRenderer renderer;
	 
	 	public void init()
	 {
		 maploader = new TmxMapLoader();
	     map = maploader.load("map1.tmx");
	     renderer = new OrthogonalTiledMapRenderer(map);
	 }

	 
	 public TmxMapLoader getMaploader() {
		return maploader;
	}

	public void setMaploader(TmxMapLoader maploader) {
		this.maploader = maploader;
	}

	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}

	public OrthogonalTiledMapRenderer getRenderer() {
		return renderer;
	}

	public void setRenderer(OrthogonalTiledMapRenderer renderer) {
		this.renderer = renderer;
	}


}