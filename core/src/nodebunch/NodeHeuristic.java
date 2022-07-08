package nodebunch;

import com.badlogic.gdx.ai.pfa.Heuristic;
import com.badlogic.gdx.math.Vector2;
/*created by thienepzai using happycodings tutorial*/
public class NodeHeuristic  implements Heuristic<Node> {

	  @Override
	  public float estimate(Node currentCity, Node goalCity) {
	    return Vector2.dst(currentCity.x, currentCity.y, goalCity.x, goalCity.y);
	  }
	}
