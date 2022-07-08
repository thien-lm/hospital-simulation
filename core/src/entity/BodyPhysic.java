package entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import screen.GameScreen;
/*created by thienepzai*/
public abstract class BodyPhysic extends Sprite {

	protected World world;
	protected Body b2body;
	protected int speed = 1;
	protected TextureRegion marioStand;

	protected BodyPhysic() {
	}

	protected BodyPhysic(World world, GameScreen gameScreen) {
		super(gameScreen.getAtlas().findRegion("agv"));
		this.world = world;

	}

	@SuppressWarnings("unused")
	private void setTexture() {
		marioStand = new TextureRegion(getTexture(), 0, 0, 32, 32);
		setBounds(0, 0, 32, 32);
		setRegion(marioStand);
	}

	protected BodyPhysic(World world) {

		this.world = world;

	}

	public void update(float dt) {
		setPosition(b2body.getPosition().x * 26 / 32 - getWidth() / 2,
				b2body.getPosition().y * 26 / 32 - getHeight() / 2);
	}

	protected BodyPhysic(World world, int x, int y, GameScreen gameScreen) {
		this.world = world;

	}

	public void defineBody() {
		BodyDef bdef = new BodyDef();
		bdef.position.set(30, 448);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);

		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(15);

		fdef.shape = shape;
		b2body.createFixture(fdef);
		shape.dispose();
	}

	public void defineBody(float posX, float posY) {
		BodyDef bdef = new BodyDef();
		bdef.position.set(-posX, posY);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);

		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(14);

		fdef.shape = shape;
		b2body.createFixture(fdef);
		shape.dispose();
	}

	public void handleInput() {

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			if (this.b2body.getLinearVelocity().y <= 58)

				this.b2body.applyLinearImpulse(new Vector2(0, 10f), this.b2body.getWorldCenter(), true);

		} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			if (this.b2body.getLinearVelocity().y >= -58)

				this.b2body.applyLinearImpulse(new Vector2(0, -10f), this.b2body.getWorldCenter(), true);
		}

		else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			if (this.b2body.getLinearVelocity().x >= -58)

				this.b2body.applyLinearImpulse(new Vector2(-10f, 0), this.b2body.getWorldCenter(), true);
		}

		else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			if (this.b2body.getLinearVelocity().x <= 58)

				this.b2body.applyLinearImpulse(new Vector2(10f, 0), this.b2body.getWorldCenter(), true);
		} else {
			this.b2body.setLinearVelocity(0f, 0f);
		}

	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Body getB2body() {
		return b2body;
	}

	public void setB2body(Body b2body) {
		this.b2body = b2body;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public TextureRegion getMarioStand() {
		return marioStand;
	}

	public void setMarioStand(TextureRegion marioStand) {
		this.marioStand = marioStand;
	}

}
