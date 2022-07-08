package nodebunch;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
/*created by thienepzai using happycodings tutorial*/
public class Graph implements IndexedGraph<Node> {

	  NodeHeuristic cityHeuristic = new NodeHeuristic();
	  public Array<Node> cities = new Array<>();
	  public Array<Street> streets = new Array<>();

	  /** Map of Cities to Streets starting in that City. */
	  ObjectMap<Node, Array<Connection<Node>>> streetsMap = new ObjectMap<>();

	  private int lastNodeIndex = 0;

	  public void addCity(Node city){
	    city.index = lastNodeIndex;
	    lastNodeIndex++;
	    cities.add(city);
	  }

	  public void connectCities(Node fromCity, Node toCity){
	    Street street = new Street(fromCity, toCity);
	    if(!streetsMap.containsKey(fromCity)){
	      streetsMap.put(fromCity, new Array<Connection<Node>>());
	    }
	    streetsMap.get(fromCity).add(street);
	    streets.add(street);
	  }

	  public GraphPath<Node> findPath(Node startCity, Node goalCity){
	    GraphPath<Node> cityPath = new DefaultGraphPath<>();
	    new IndexedAStarPathFinder<>(this).searchNodePath(startCity, goalCity, cityHeuristic, cityPath);
	    return cityPath;
	  }

	  @Override
	  public int getIndex(Node node) {
	    return node.index;
	  }

	  @Override
	  public int getNodeCount() {
	    return lastNodeIndex;
	  }

	  @Override
	  public Array<Connection<Node>> getConnections(Node fromNode) {
	    if(streetsMap.containsKey(fromNode)){
	      return streetsMap.get(fromNode);
	    }

	    return new Array<>(0);
	  }
	}