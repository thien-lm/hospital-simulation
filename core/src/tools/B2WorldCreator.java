package tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/*created by thienepzai using MarioBrosGame tutorial*/
public class B2WorldCreator {
	
	public B2WorldCreator(World world, tilemap.TileMap tileMap)
	{
		BodyDef bdef = new BodyDef();
    	PolygonShape shape = new PolygonShape();
    	FixtureDef fdef = new FixtureDef();
    	Body body;
    	
    	for(MapObject object : tileMap.getMap().getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
    		Rectangle rect = ((RectangleMapObject) object).getRectangle();
    		
    		bdef.type = BodyDef.BodyType.StaticBody;
    		// exact center of shape
    		bdef.position.set(rect.getX() + rect.getWidth()/ 2 ,rect.getY() +rect.getHeight() /2); 
    		
    		body = world.createBody(bdef);
    		//draw
    		shape.setAsBox(rect.getWidth() /2, rect.getHeight()/2);
    		fdef.shape = shape;
    		body.createFixture(fdef);
    		
    	}
	}

}
