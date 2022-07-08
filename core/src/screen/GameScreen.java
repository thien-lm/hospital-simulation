package screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import entity.PlayerMP;
import entity.TestAGV;
import entity.TestAgent;
import entity.TestMainPlayer;
import game.MyGdxGame;
import network_pack.Packet00Login;
import networking.GameClient;
import networking.GameServer;
import nodebunch.Graph;
import nodebunch.Node;
import nodebunch.NodeInitial;
import tilemap.TileMap;
import tools.B2WorldCreator;
/*created by thienepzai with tons of tutorials*/
public class GameScreen implements Screen, Sundries {
	// just testing for save&load
	public static Preferences prefs;  
	// basic element for Screen
	MyGdxGame mygame;
	private TextureAtlas atlas;
	OrthographicCamera camera;
	SpriteBatch batch;
	TileMap tileMap;
	// entity; agent, player, agv
	private int numAGV = 10;
	private List<TestAGV> test = new ArrayList<>(numAGV);
	private List<TestAgent> testAgent = new ArrayList<>(18);
	private TestMainPlayer testMain;
	public List<PlayerMP> mpPlayer = new ArrayList<>(numAGV);// public for testing
	private float posx;
	private float posy;
	// physics world
	Random rand = new Random();
	private World world;
	private Body b2body;
	private int in = 0;
	private Box2DDebugRenderer b2dr;
	// graph
	private List<GraphPath<Node>> cityPath = new ArrayList<>(10);
	private Graph cityGraph;
	private Node des;// des for player
	private int desclone;
	private ShapeRenderer shapeRenderer;
	// for node web
	private BitmapFont font;
	private int currentRank = 0;
	private NodeInitial node;
	// networking
	private GameClient client;
	private GameServer server;


	public GameScreen(MyGdxGame mygame) {

		desclone = rand.nextInt(70) + 20;
		// warning: hard code
		atlas = new TextureAtlas("hentaiz.pack");
		this.mygame = mygame;
		this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(false, 1663, 897);// TRUE = VE CHUAN, FALSE = VE NGUOC

		batch = new SpriteBatch();
		tileMap = new TileMap();
		tileMap.init();

		world = new World(new Vector2(0, 0), true);
		b2dr = new Box2DDebugRenderer(/* drawBodies */ true, /* drawJoints */ false, /* drawAABBs */ false,
				/* drawInactiveBodies */ false, /* drawVelocities */ false, /* drawContacts */ true);
		new B2WorldCreator(world, tileMap);

		//player 
		testMain = new TestMainPlayer(world, this);
		
		//lrAgent
		testAgent.add(new TestAgent(world, -900, 476 * 32 / 26 + 6, this));
		testAgent.add(new TestAgent(world, -300, 476 * 32 / 26 + 6, this));
		testAgent.add(new TestAgent(world, -400, 2 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -250, 7 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -200, 20 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -750, 25 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -400, 2 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -300, 9 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -660, 7 * 32 + 16, this));
		testAgent.add(new TestAgent(world, -350, 25 * 32 + 16, this));
		// UD Agent
		testAgent.add(new TestAgent(world, -8 * 32 - 16, 450, this));
		testAgent.add(new TestAgent(world, -10 * 32 - 16, 460, this));
		testAgent.add(new TestAgent(world, -23 * 32 - 16, 470, this));
		testAgent.add(new TestAgent(world, -25 * 32 - 16, 430, this));
		testAgent.add(new TestAgent(world, -38 * 32 - 16, 420, this));
		testAgent.add(new TestAgent(world, -40 * 32 - 16, 400, this));
		// init and combine graph together
		node = new NodeInitial(this);
		node.InitNode();
		this.cityGraph = node.cityGraph;
		this.cityPath = node.cityPath;
		des = cityGraph.cities.get(desclone);
		// for drawing node
		shapeRenderer = new ShapeRenderer();
		batch = new SpriteBatch();
		font = new BitmapFont();
        prefs = Gdx.app.getPreferences("Game_Screen");//file save game
		// initial client and server
		if (JOptionPane.showConfirmDialog(null, "Do U wana initialize the server ?") == 0) {
			server = new GameServer(this);
			server.start();
		}
		client = new GameClient(this, "localhost");
		client.start();
		// check box for a client which want to access server
		PlayerMP mpPlayer1 = new PlayerMP(JOptionPane.showInputDialog(this, "Please enter a username"), null, -1);
		mpPlayer.add(mpPlayer1);
		this.buildBody(mpPlayer.get(this.in));
		// login packet: initialize player when they connect
		Packet00Login loginPacket = new Packet00Login(mpPlayer1.getUsername());
		if (server != null) {
			server.addConnection((PlayerMP) mpPlayer1, loginPacket);
		}
		loginPacket.writeData(client);

	}

	public TextureAtlas getAtlas() {
		return this.atlas;
	}

	@Override
	public void render(float delta) {

		world.step(1 / 60f, 6, 2);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		tileMap.getRenderer().setView(camera);
		tileMap.getRenderer().render();
		b2dr.render(world, camera.combined);

		des.render(shapeRenderer, batch, font, true);
		// draw all node or not
//		for (Street street : cityGraph.streets) {
//			street.render(shapeRenderer);
//		}
//		
//		for (City city : cityGraph.cities) {
//			city.render(shapeRenderer, batch, font, false);// Draw all cities blue
//		}
//
//		for (City city : cityPath.get(0)){
//			city.render(shapeRenderer, batch, font, true);// Draw cities in path green
//		}

		// moving player
		testMain.handleInput();
		testMain.update(delta);
		// mpPlayer.HandleInput();: can't use now

		// for draw sprite for body
		for (int i = 0; i < this.cityPath.size(); i++) {
			test.get(i).update(delta);
		}

		for (int i = 0; i < this.testAgent.size(); i++) {
			testAgent.get(i).update(delta);
		}
		// moving agv
		for (int i = 0; i < test.size(); i++) {
			cityPath.get(i).get(cityPath.get(i).getCount() - 1).render(shapeRenderer, batch, font, false);
			if (i == 0) {

				test.get(i).move();
			} else {
				if (test.get(i - 1).isReachend()) {
					test.get(i).move();
				}
			}
		}

		// move agent
		for (int i = 0; i <= 9; i++) {
			testAgent.get(i).setDisturbTypeLR();
		}

		for (int i = 10; i < 16; i++) {
			testAgent.get(i).setDisturbTypeUD();
		}
		// draw everything we need like text, sprite, etc...
		batch.begin();

		font.draw(batch, "" + TestAGV.counter + " AGV has came to destination", 1050, 690);
		font.draw(batch, " you have to reach to node No " + (desclone + 1), 50, 690);
		testMain.draw(batch);

		for (int i = 0; i < this.cityPath.size(); i++) {
			test.get(i).draw(batch);
		}

		for (int i = 0; i < this.testAgent.size(); i++) {
			testAgent.get(i).draw(batch);
		}

		batch.end();
		
        if(isGoal()){
        	mygame.setScreen(new EndScreen(mygame));
            dispose();
        }	
        this.save();
        this.load();		

	}
	public void save() {
        if(Gdx.input.isKeyPressed(Input.Keys.P)) {
        prefs.putInteger("des", desclone);
        prefs.putFloat("posX", this.testMain.getX());
        prefs.putFloat("posY", this.testMain.getY());
        for (int i = 0; i < 16; i++) {
        	prefs.putFloat("posAgentX" +i, this.testAgent.get(i).getX());
            prefs.putFloat("posAgentY" +i, this.testAgent.get(i).getY());
		}
        prefs.flush();
        }
	}
	
	public void load() {
		if(Gdx.input.isKeyPressed(Input.Keys.L)) {
		desclone = prefs.getInteger("des");
		des = cityGraph.cities.get(desclone);
		posx = prefs.getFloat("posX")*32/26;
		posy = prefs.getFloat("posY")*32/26;
		testMain.getB2body().setTransform(posx, posy, 0);
		
		 for (int i = 0; i < 16; i++) {
			 testAgent.get(i).getB2body().setTransform(prefs.getFloat("posAgentX"+i)*32/26, prefs.getFloat("posAgentY"+i)*32/26, 0);
			}
		}
	}

	@Override
	public void show() {
		// TODO document why this method is empty
	}

	@Override
	public void resize(int width, int height) {
		// TODO document why this method is empty
	}

	@Override
	public void pause() {
		// TODO document why this method is empty
	}

	@Override
	public void resume() {
		// TODO document why this method is empty
	}

	@Override
	public void hide() {
		// TODO document why this method is empty
	}

	@Override
	public void dispose() {

		tileMap.getMap().dispose();
		world.dispose();
		b2dr.dispose();

	}

	// for building a body from client
	@Override
	public void buildBody(PlayerMP mp) {
		BodyDef bdef = new BodyDef();
		bdef.position.set(30, 448);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);

		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(14);

		fdef.shape = shape;
		b2body.createFixture(fdef);
		shape.dispose();
		in++;

	}

	public MyGdxGame getMygame() {
		return mygame;
	}

	public void setMygame(MyGdxGame mygame) {
		this.mygame = mygame;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public int getNumAGV() {
		return numAGV;
	}

	public void setNumAGV(int numAGV) {
		this.numAGV = numAGV;
	}

	public List<TestAgent> getTestAgent() {
		return testAgent;
	}

	public void setTestAgent(List<TestAgent> testAgent) {
		this.testAgent = testAgent;
	}

	public TestMainPlayer getTestMain() {
		return testMain;
	}

	public void setTestMain(TestMainPlayer testMain) {
		this.testMain = testMain;
	}

	public List<PlayerMP> getMpPlayer() {
		return mpPlayer;
	}

	public void setMpPlayer(List<PlayerMP> mpPlayer) {
		this.mpPlayer = mpPlayer;
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

	public int getI() {
		return in;
	}

	public void setI(int i) {
		this.in = i;
	}

	public Box2DDebugRenderer getB2dr() {
		return b2dr;
	}

	public void setB2dr(Box2DDebugRenderer b2dr) {
		this.b2dr = b2dr;
	}

	public List<GraphPath<Node>> getCityPath() {
		return cityPath;
	}

	public void setCityPath(List<GraphPath<Node>> cityPath) {
		this.cityPath = cityPath;
	}

	public Graph getCityGraph() {
		return cityGraph;
	}

	public void setCityGraph(Graph cityGraph) {
		this.cityGraph = cityGraph;
	}

	public Node getDes() {
		return des;
	}

	public void setDes(Node des) {
		this.des = des;
	}

	public int getDesclone() {
		return desclone;
	}

	public void setDesclone(int desclone) {
		this.desclone = desclone;
	}

	public BitmapFont getFont() {
		return font;
	}

	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public int getCurrentRank() {
		return currentRank;
	}

	public void setCurrentRank(int currentRank) {
		this.currentRank = currentRank;
	}

	public NodeInitial getNode() {
		return node;
	}

	public void setNode(NodeInitial node) {
		this.node = node;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	public GameServer getServer() {
		return server;
	}

	public void setServer(GameServer server) {
		this.server = server;
	}

	public List<TestAGV> getTest() {
		return test;
	}

	public void setTest(List<TestAGV> test) {
		this.test = test;
	}

	public boolean isGoal() {
		double length = Vector2.dst(1603, 448, testMain.getB2body().getPosition().x, testMain.getB2body().getPosition().y);
		if(length <= 15) {
		return  true;
		}
		return false;
	}

	

}