package entity;



import java.util.Random;

import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Queue;

import nodebunch.Node;
import screen.GameScreen;
import nodebunch.Graph;
/*created by thienepzai*/
public class TestAGV extends BodyPhysic {
	// re-define world and b2body make bugs here
	Random rand = new Random();

	private float posX = 0;
	private float posY = 0;
	TestMainPlayer testMain;
    private int steps = 0;
    
	Graph cityGraph;
	float deltaX = 0;
	float deltaY = 0;
	private boolean reachend = false;
	private boolean reachendPos = false;
	private boolean finish = false;
	Node previousCity;
	Queue<Node> pathQueue = new Queue<>();

	private  int count = 0;
	public static int counter = 0;
	private  boolean canRender = true;

	public TestAGV(World world, Graph cityGraph, Node start, TestMainPlayer testMain,GameScreen gameScreen) {
		super(world,gameScreen);
		this.cityGraph = cityGraph;
		this.posX = start.x * 32 / 26;
		this.posY = start.y * 32 / 26;
		this.previousCity = start;
		this.testMain = testMain;
		super.defineBody(posX, posY);
	}
	
	public TestAGV(World world, Graph cityGraph, Node start, TestMainPlayer testMain) {
		super(world);
		this.cityGraph = cityGraph;
		this.posX = start.x * 32 / 26;
		this.posY = start.y * 32 / 26;
		this.previousCity = start;
		this.testMain = testMain;
		super.defineBody(posX, posY);
	}


	private void render() {
		if (canRender) {
			b2body.setTransform(posX, posY, 90);
			b2body.setAwake(true);
		}
	}

	public void move() {
		step();
		render();
	}

	private void step() {
		if (Vector2.dst(posX, posY, testMain.b2body.getPosition().x, testMain.b2body.getPosition().y) <= 14 + 13)
			canRender = false;
		else
			canRender = true;
		if (canRender) {
			posX += deltaX;
			posY += deltaY;
			checkCollision();
		}
	}

	private void checkCollision() {
		if (pathQueue.size > 0) {

			Node targetCity = pathQueue.first();

			if (Vector2.dst(posX, posY, targetCity.x * 32 / 26, targetCity.y * 32 / 26) <= 1) {
				steps++;
				if(steps == 2) reachend = true;
				reachNextCity();
			}
		}
	}

	private void reachNextCity() {

		Node nextCity = pathQueue.first();

		// Set the position to keep the Agent in the middle of the path

		this.posX = nextCity.x * 32 / 26;
		this.posY = nextCity.y * 32 / 26;

		this.previousCity = nextCity;
		pathQueue.removeFirst();

		if (pathQueue.size == 0) {
			deltaX = 0;
			deltaY = 0;
			this.b2body.setLinearVelocity(0f, 0f);
			reachDestination();
		} else {
			setSpeedToNextCity();
		}
	}

	@SuppressWarnings("static-access")
	private void reachDestination() {
		this.count++;
		if(count == 2) 
			{
			reachendPos = false;
			this.finish = true;
			this.counter++;
			}
		
		if(count == 1) {
		reachendPos = true;	
		setGoal(cityGraph.cities.get((int)(Math.random()*2+114)));
		}
		else {
			world.destroyBody(b2body);
		}
	}

	public void setGoal(Node goal) {
		GraphPath<Node> graphPath = cityGraph.findPath(previousCity, goal);
		for (int i = 1; i < graphPath.getCount(); i++) {
			pathQueue.addLast(graphPath.get(i));
		}
		setSpeedToNextCity();
	}

	private void setSpeedToNextCity() {
		Node nextCity = pathQueue.first();
		float angle = MathUtils.atan2(nextCity.y * 32 / 26 - previousCity.y * 32 / 26,
				nextCity.x * 32 / 26 - previousCity.x * 32 / 26);
		deltaX = MathUtils.cos(angle) * speed;
		deltaY = MathUtils.sin(angle) * speed;
	}


	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public TestMainPlayer getTestMain() {
		return testMain;
	}

	public void setTestMain(TestMainPlayer testMain) {
		this.testMain = testMain;
	}

	public Graph getCityGraph() {
		return cityGraph;
	}

	public void setCityGraph(Graph cityGraph) {
		this.cityGraph = cityGraph;
	}

	public float getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(float deltaX) {
		this.deltaX = deltaX;
	}

	public float getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(float deltaY) {
		this.deltaY = deltaY;
	}

	public boolean isReachend() {
		return reachend;
	}

	public void setReachend(boolean reachend) {
		this.reachend = reachend;
	}

	public boolean isReachendPos() {
		return reachendPos;
	}

	public void setReachendPos(boolean reachendPos) {
		this.reachendPos = reachendPos;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public Node getPreviousCity() {
		return previousCity;
	}

	public void setPreviousCity(Node previousCity) {
		this.previousCity = previousCity;
	}

	public Queue<Node> getPathQueue() {
		return pathQueue;
	}

	public void setPathQueue(Queue<Node> pathQueue) {
		this.pathQueue = pathQueue;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		TestAGV.counter = counter;
	}

	public boolean isCanRender() {
		return canRender;
	}

	public void setCanRender(boolean canRender) {
		this.canRender = canRender;
	}
	
	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}


}