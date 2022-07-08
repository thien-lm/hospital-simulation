package nodebunch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.ai.pfa.GraphPath;
import entity.TestAGV;
import screen.GameScreen;
/*created by Nguyen_van_tho Co thienepzai*/
public class NodeInitial {
	
	GameScreen gameScreen;
//	testAGV test;
//	testAGV test2;
//	testMainPlayer testMain;
//	testAgent testA;
//	testAgent testB;
//	
	private int worker;
	private int index;
	Random rand = new Random();
	
	public  Graph cityGraph;
//	public GraphPath<Node> cityPath1;
//	public GraphPath<Node> cityPath2;
//	public GraphPath<Node> cityPath3;
//	public GraphPath<City> cityPath2;
//	public GraphPath<City> cityPath1;
//	public GraphPath<City> cityPath2;
//	
	
//	public  ShapeRenderer shapeRenderer;
//	public  BitmapFont font;
//	public int currentRank = 0;
	private Node startCity;
	private Node goalCity;
	
	public List<GraphPath<Node>> cityPath = new ArrayList<GraphPath<Node>>(6);
	
	public NodeInitial(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
		 cityGraph = new Graph();
	}
	
	public float caly(int i)
	{
		i = 28 - i;
		float scale = 26;
		return i*scale - scale/2;
	}
	
	public float calx(int i)
	{

		float scale = 26;
		return i*scale + scale/2;
	}
	
	public void InitNode() {
		Node n1City = new Node(calx(1), caly(13), "N1");
		Node n2City = new Node(calx(1), caly(14), "N2");
		
		Node n3City = new Node(calx(4), caly(2), "N3");
		Node n4City = new Node(calx(4), caly(7), "N4");
		Node n5City = new Node(calx(4), caly(9), "N5");
		Node n6City = new Node(calx(4), caly(13), "N6");
		Node n7City = new Node(calx(4), caly(14), "N7");
		Node n8City = new Node(calx(4), caly(18), "N8");
		Node n9City = new Node(calx(4), caly(20), "N9");
		Node n10City = new Node(calx(4), caly(25), "N10");
		
		Node n11City = new Node(calx(6), caly(7), "N11");
		Node n12City = new Node(calx(6), caly(9), "N12");
		Node n13City = new Node(calx(6), caly(18), "N13");
		Node n14City = new Node(calx(6), caly(20), "N14");
		
		Node n15City = new Node(calx(8), caly(7), "N15");
		Node n16City = new Node(calx(8), caly(9), "N16");
		Node n17City = new Node(calx(8), caly(12), "N17");
		Node n18City = new Node(calx(8), caly(15), "N18");
		Node n19City = new Node(calx(8), caly(18), "N19");
		Node n20City = new Node(calx(8), caly(20), "N20");
		
		Node n21City = new Node(calx(10), caly(7), "N21");
		Node n22City = new Node(calx(10), caly(9), "N22");
		Node n23City = new Node(calx(10), caly(12), "N23");
		Node n24City = new Node(calx(10), caly(15), "N24");
		Node n25City = new Node(calx(10), caly(18), "N25");
		Node n26City = new Node(calx(10), caly(20), "N26");
		
		Node n27City = new Node(calx(12), caly(7), "N27");
		Node n28City = new Node(calx(12), caly(9), "N28");
		Node n29City = new Node(calx(12), caly(18), "N29");
		Node n30City = new Node(calx(12), caly(20), "N30");
		
		Node n31City = new Node(calx(15), caly(7), "N31");
		Node n32City = new Node(calx(15), caly(9), "N32");
		Node n33City = new Node(calx(15), caly(18), "N33");
		Node n34City = new Node(calx(15), caly(20), "N34");
		
		Node n35City = new Node(calx(17), caly(2), "N35");
		Node n36City = new Node(calx(17), caly(7), "N36");
		Node n37City = new Node(calx(17), caly(9), "N37");
		Node n38City = new Node(calx(17), caly(18), "N38");
		Node n39City = new Node(calx(17), caly(20), "N39");
		Node n40City = new Node(calx(17), caly(25), "N40");
		
		Node n41City = new Node(calx(19), caly(2), "N41");
		Node n42City = new Node(calx(19), caly(7), "N42");
		Node n43City = new Node(calx(19), caly(9), "N43");
		Node n44City = new Node(calx(19), caly(18), "N44");
		Node n45City = new Node(calx(19), caly(20), "N45");
		Node n46City = new Node(calx(19), caly(25), "N46");
		
		Node n47City = new Node(calx(21), caly(7), "N47");
		Node n48City = new Node(calx(21), caly(9), "N48");
		Node n49City = new Node(calx(21), caly(18), "N49");
		Node n50City = new Node(calx(21), caly(20), "N50");
		
		Node n51City = new Node(calx(23), caly(7), "N51");
		Node n52City = new Node(calx(23), caly(9), "N52");
		Node n53City = new Node(calx(23), caly(12), "N53");
		Node n54City = new Node(calx(23), caly(15), "N54");
		Node n55City = new Node(calx(23), caly(18), "N55");
		Node n56City = new Node(calx(23), caly(20), "N56");
		
		Node n57City = new Node(calx(25), caly(7), "N57");
		Node n58City = new Node(calx(25), caly(9), "N58");
		Node n59City = new Node(calx(25), caly(12), "N59");
		Node n60City = new Node(calx(25), caly(15), "N60");
		Node n61City = new Node(calx(25), caly(18), "N61");
		Node n62City = new Node(calx(25), caly(20), "N62");
		
		Node n63City = new Node(calx(27), caly(7), "N63");
		Node n64City = new Node(calx(27), caly(9), "N64");
		Node n65City = new Node(calx(27), caly(18), "N65");
		Node n66City = new Node(calx(27), caly(20), "N66");
		
		Node n67City = new Node(calx(30), caly(7), "N67");
		Node n68City = new Node(calx(30), caly(9), "N68");
		Node n69City = new Node(calx(30), caly(18), "N69");
		Node n70City = new Node(calx(30), caly(20), "N70");
		
		Node n71City = new Node(calx(32), caly(2), "N71");
		Node n72City = new Node(calx(32), caly(7), "N72");
		Node n73City = new Node(calx(32), caly(9), "N73");
		Node n74City = new Node(calx(32), caly(18), "N74");
		Node n75City = new Node(calx(32), caly(20), "N75");
		Node n76City = new Node(calx(32), caly(25), "N76");
		
		Node n77City = new Node(calx(34), caly(2), "N77");
		Node n78City = new Node(calx(34), caly(7), "N78");
		Node n79City = new Node(calx(34), caly(9), "N79");
		Node n80City = new Node(calx(34), caly(18), "N80");
		Node n81City = new Node(calx(34), caly(20), "N81");
		Node n82City = new Node(calx(34), caly(25), "N82");
		
		Node n83City = new Node(calx(36), caly(7), "N83");
		Node n84City = new Node(calx(36), caly(9), "N84");
		Node n85City = new Node(calx(36), caly(18), "N85");
		Node n86City = new Node(calx(36), caly(20), "N86");

		Node n87City = new Node(calx(38), caly(7), "N87");
		Node n88City = new Node(calx(38), caly(9), "N88");
		Node n89City = new Node(calx(38), caly(12), "N89");
		Node n90City = new Node(calx(38), caly(15), "N90");
		Node n91City = new Node(calx(38), caly(18), "N91");
		Node n92City = new Node(calx(38), caly(20), "N92");
		
		Node n93City = new Node(calx(40), caly(7), "N93");
		Node n94City = new Node(calx(40), caly(9), "N94");
		Node n95City = new Node(calx(40), caly(12), "N95");
		Node n96City = new Node(calx(40), caly(15), "N96");
		Node n97City = new Node(calx(40), caly(18), "N97");
		Node n98City = new Node(calx(40), caly(20), "N98");
		
		Node n99City = new Node(calx(42), caly(7), "N99");
		Node n100City = new Node(calx(42), caly(9), "N100");
		Node n101City = new Node(calx(42), caly(18), "N101");
		Node n102City = new Node(calx(42), caly(20), "N102");

		Node n103City = new Node(calx(45), caly(7), "N103");
		Node n104City = new Node(calx(45), caly(9), "N104");
		Node n105City = new Node(calx(45), caly(18), "N105");
		Node n106City = new Node(calx(45), caly(20), "N106");
		
		Node n107City = new Node(calx(47), caly(2), "N107");
		Node n108City = new Node(calx(47), caly(7), "N108");
		Node n109City = new Node(calx(47), caly(9), "N109");
		Node n110City = new Node(calx(47), caly(13), "N110");
		Node n111City = new Node(calx(47), caly(14), "N111");
		Node n112City = new Node(calx(47), caly(18), "N112");
		Node n113City = new Node(calx(47), caly(20), "N113");
		Node n114City = new Node(calx(47), caly(25), "N114");
		
		Node n115City = new Node(calx(50), caly(13), "N115");
		Node n116City = new Node(calx(50), caly(14), "N116");
		
		//make a list node
		cityGraph.addCity(n1City);
		cityGraph.addCity(n2City);
		cityGraph.addCity(n3City);
		cityGraph.addCity(n4City);
		cityGraph.addCity(n5City);
		cityGraph.addCity(n6City);
		cityGraph.addCity(n7City);
		cityGraph.addCity(n8City);
		cityGraph.addCity(n9City);
		
		cityGraph.addCity(n10City);
		cityGraph.addCity(n11City);
		cityGraph.addCity(n12City);
		cityGraph.addCity(n13City);
		cityGraph.addCity(n14City);
		cityGraph.addCity(n15City);
		cityGraph.addCity(n16City);
		cityGraph.addCity(n17City);
		cityGraph.addCity(n18City);
		cityGraph.addCity(n19City);
		
		cityGraph.addCity(n20City);
		cityGraph.addCity(n21City);
		cityGraph.addCity(n22City);
		cityGraph.addCity(n23City);
		cityGraph.addCity(n24City);
		cityGraph.addCity(n25City);
		cityGraph.addCity(n26City);
		cityGraph.addCity(n27City);
		cityGraph.addCity(n28City);
		cityGraph.addCity(n29City);
		
		cityGraph.addCity(n30City);
		cityGraph.addCity(n31City);
		cityGraph.addCity(n32City);
		cityGraph.addCity(n33City);
		cityGraph.addCity(n34City);
		cityGraph.addCity(n35City);
		cityGraph.addCity(n36City);
		cityGraph.addCity(n37City);
		cityGraph.addCity(n38City);
		cityGraph.addCity(n39City);
		
		cityGraph.addCity(n40City);
		cityGraph.addCity(n41City);
		cityGraph.addCity(n42City);
		cityGraph.addCity(n43City);
		cityGraph.addCity(n44City);
		cityGraph.addCity(n45City);
		cityGraph.addCity(n46City);
		cityGraph.addCity(n47City);
		cityGraph.addCity(n48City);
		cityGraph.addCity(n49City);
		
		cityGraph.addCity(n50City);
		cityGraph.addCity(n51City);
		cityGraph.addCity(n52City);
		cityGraph.addCity(n53City);
		cityGraph.addCity(n54City);
		cityGraph.addCity(n55City);
		cityGraph.addCity(n56City);
		cityGraph.addCity(n57City);
		cityGraph.addCity(n58City);
		cityGraph.addCity(n59City);
		
		cityGraph.addCity(n60City);
		cityGraph.addCity(n61City);
		cityGraph.addCity(n62City);
		cityGraph.addCity(n63City);
		cityGraph.addCity(n64City);
		cityGraph.addCity(n65City);
		cityGraph.addCity(n66City);
		cityGraph.addCity(n67City);
		cityGraph.addCity(n68City);
		cityGraph.addCity(n69City);
		
		cityGraph.addCity(n70City);
		cityGraph.addCity(n71City);
		cityGraph.addCity(n72City);
		cityGraph.addCity(n73City);
		cityGraph.addCity(n74City);
		cityGraph.addCity(n75City);
		cityGraph.addCity(n76City);
		cityGraph.addCity(n77City);
		cityGraph.addCity(n78City);
		cityGraph.addCity(n79City);
		
		cityGraph.addCity(n80City);
		cityGraph.addCity(n81City);
		cityGraph.addCity(n82City);
		cityGraph.addCity(n83City);
		cityGraph.addCity(n84City);
		cityGraph.addCity(n85City);
		cityGraph.addCity(n86City);
		cityGraph.addCity(n87City);
		cityGraph.addCity(n88City);
		cityGraph.addCity(n89City);
		
		cityGraph.addCity(n90City);
		cityGraph.addCity(n91City);
		cityGraph.addCity(n92City);
		cityGraph.addCity(n93City);
		cityGraph.addCity(n94City);
		cityGraph.addCity(n95City);
		cityGraph.addCity(n96City);
		cityGraph.addCity(n97City);
		cityGraph.addCity(n98City);
		cityGraph.addCity(n99City);
		
		cityGraph.addCity(n100City);
		cityGraph.addCity(n101City);
		cityGraph.addCity(n102City);
		cityGraph.addCity(n103City);
		cityGraph.addCity(n104City);
		cityGraph.addCity(n105City);
		cityGraph.addCity(n106City);
		cityGraph.addCity(n107City);
		cityGraph.addCity(n108City);
		cityGraph.addCity(n109City);
		
		cityGraph.addCity(n110City);
		cityGraph.addCity(n111City);
		cityGraph.addCity(n112City);
		cityGraph.addCity(n113City);
		cityGraph.addCity(n114City);
		cityGraph.addCity(n115City);
		cityGraph.addCity(n116City);
	
		//set all connect lines
		cityGraph.connectCities(n1City, n6City);
		cityGraph.connectCities(n2City, n7City);
		cityGraph.connectCities(n3City, n35City);
		cityGraph.connectCities(n4City, n3City);
		cityGraph.connectCities(n4City, n11City);
		cityGraph.connectCities(n5City, n4City);
		cityGraph.connectCities(n6City, n5City);
		cityGraph.connectCities(n7City, n8City);
		cityGraph.connectCities(n8City, n9City);
		cityGraph.connectCities(n8City, n13City);
		cityGraph.connectCities(n9City, n10City);
		cityGraph.connectCities(n10City, n40City);
		cityGraph.connectCities(n11City, n12City);
		cityGraph.connectCities(n11City, n15City);
		cityGraph.connectCities(n12City, n5City);
		cityGraph.connectCities(n13City, n19City);
		cityGraph.connectCities(n14City, n9City);
		cityGraph.connectCities(n14City, n13City);
		cityGraph.connectCities(n15City, n21City);
		cityGraph.connectCities(n16City, n12City);
		cityGraph.connectCities(n16City, n15City);
		cityGraph.connectCities(n16City, n17City);
		cityGraph.connectCities(n17City, n23City);
		cityGraph.connectCities(n18City, n17City);
		cityGraph.connectCities(n18City, n19City);
		cityGraph.connectCities(n19City, n20City);
		cityGraph.connectCities(n19City, n25City);
		cityGraph.connectCities(n20City, n14City);
		cityGraph.connectCities(n21City, n22City);
		cityGraph.connectCities(n21City, n27City);
		cityGraph.connectCities(n22City, n16City);
		cityGraph.connectCities(n23City, n22City);
		cityGraph.connectCities(n23City, n24City);
		cityGraph.connectCities(n24City, n18City);
		cityGraph.connectCities(n25City, n24City);
		cityGraph.connectCities(n25City, n29City);
		cityGraph.connectCities(n26City, n20City);
		cityGraph.connectCities(n26City, n25City);
		cityGraph.connectCities(n27City, n31City);
		cityGraph.connectCities(n28City, n22City);
		cityGraph.connectCities(n28City, n27City);
		cityGraph.connectCities(n29City, n30City);
		cityGraph.connectCities(n29City, n33City);
		cityGraph.connectCities(n30City, n26City);
		cityGraph.connectCities(n31City, n32City);
		cityGraph.connectCities(n31City, n36City);
		cityGraph.connectCities(n32City, n28City);
		cityGraph.connectCities(n33City, n38City);
		cityGraph.connectCities(n34City, n30City);
		cityGraph.connectCities(n34City, n33City);
		cityGraph.connectCities(n35City, n36City);
		cityGraph.connectCities(n35City, n41City);
		cityGraph.connectCities(n36City, n42City);
		cityGraph.connectCities(n37City, n32City);
		cityGraph.connectCities(n37City, n36City);
		cityGraph.connectCities(n38City, n39City);
		cityGraph.connectCities(n38City, n44City);
		cityGraph.connectCities(n39City, n34City);
		cityGraph.connectCities(n40City, n39City);
		cityGraph.connectCities(n40City, n46City);
		cityGraph.connectCities(n41City, n71City);
		cityGraph.connectCities(n42City, n41City);
		cityGraph.connectCities(n42City, n43City);
		cityGraph.connectCities(n43City, n37City);
		cityGraph.connectCities(n43City, n48City);
		cityGraph.connectCities(n44City, n45City);
		cityGraph.connectCities(n45City, n39City);
		cityGraph.connectCities(n45City, n46City);
		cityGraph.connectCities(n45City, n50City);
		cityGraph.connectCities(n46City, n76City);
		cityGraph.connectCities(n47City, n42City);
		cityGraph.connectCities(n48City, n47City);
		cityGraph.connectCities(n48City, n52City);
		cityGraph.connectCities(n49City, n44City);
		cityGraph.connectCities(n49City, n50City);
		cityGraph.connectCities(n50City, n56City);
		cityGraph.connectCities(n51City, n47City);
		cityGraph.connectCities(n51City, n52City);
		cityGraph.connectCities(n52City, n58City);
		cityGraph.connectCities(n53City, n52City);
		cityGraph.connectCities(n53City, n54City);
		cityGraph.connectCities(n54City, n60City);
		cityGraph.connectCities(n55City, n49City);
		cityGraph.connectCities(n55City, n54City);
		cityGraph.connectCities(n56City, n55City);
		cityGraph.connectCities(n56City, n62City);
		cityGraph.connectCities(n57City, n51City);
		cityGraph.connectCities(n58City, n57City);
		cityGraph.connectCities(n58City, n59City);
		cityGraph.connectCities(n58City, n64City);
		cityGraph.connectCities(n59City, n53City);
		cityGraph.connectCities(n60City, n59City);
		cityGraph.connectCities(n60City, n61City);
		cityGraph.connectCities(n61City, n55City);
		cityGraph.connectCities(n61City, n62City);
		cityGraph.connectCities(n62City, n66City);
		cityGraph.connectCities(n63City, n57City);
		cityGraph.connectCities(n63City, n64City);
		cityGraph.connectCities(n64City, n68City);
		cityGraph.connectCities(n65City, n61City);
		cityGraph.connectCities(n66City, n65City);
		cityGraph.connectCities(n66City, n70City);
		cityGraph.connectCities(n67City, n63City);
		cityGraph.connectCities(n68City, n67City);
		cityGraph.connectCities(n68City, n73City);
		cityGraph.connectCities(n69City, n65City);
		cityGraph.connectCities(n69City, n70City);
		cityGraph.connectCities(n70City, n75City);
		cityGraph.connectCities(n71City, n77City);
		cityGraph.connectCities(n72City, n67City);
		cityGraph.connectCities(n72City, n71City);
		cityGraph.connectCities(n72City, n73City);
		cityGraph.connectCities(n73City, n79City);
		cityGraph.connectCities(n74City, n69City);
		cityGraph.connectCities(n75City, n74City);
		cityGraph.connectCities(n75City, n76City);
		cityGraph.connectCities(n75City, n81City);
		cityGraph.connectCities(n76City, n82City);
		cityGraph.connectCities(n77City, n78City);
		cityGraph.connectCities(n77City, n107City);
		cityGraph.connectCities(n78City, n72City);
		cityGraph.connectCities(n78City, n83City);
		cityGraph.connectCities(n79City, n78City);
		cityGraph.connectCities(n80City, n74City);
		cityGraph.connectCities(n80City, n85City);
		cityGraph.connectCities(n81City, n80City);
		cityGraph.connectCities(n82City, n81City);
		cityGraph.connectCities(n82City, n114City);
		cityGraph.connectCities(n83City, n84City);
		cityGraph.connectCities(n83City, n87City);
		cityGraph.connectCities(n84City, n79City);
		cityGraph.connectCities(n85City, n91City);
		cityGraph.connectCities(n86City, n81City);
		cityGraph.connectCities(n86City, n85City);
		cityGraph.connectCities(n87City, n93City);
		cityGraph.connectCities(n88City, n84City);
		cityGraph.connectCities(n88City, n87City);
		cityGraph.connectCities(n89City, n88City);
		cityGraph.connectCities(n89City, n90City);
		cityGraph.connectCities(n90City, n96City);
		cityGraph.connectCities(n91City, n90City);
		cityGraph.connectCities(n91City, n92City);
		cityGraph.connectCities(n91City, n97City);
		cityGraph.connectCities(n92City, n86City);
		cityGraph.connectCities(n93City, n94City);
		cityGraph.connectCities(n93City, n99City);
		cityGraph.connectCities(n94City, n88City);
		cityGraph.connectCities(n94City, n95City);
		cityGraph.connectCities(n95City, n89City);
		cityGraph.connectCities(n96City, n95City);
		cityGraph.connectCities(n96City, n97City);
		cityGraph.connectCities(n97City, n101City);
		cityGraph.connectCities(n98City, n92City);
		cityGraph.connectCities(n98City, n97City);
		cityGraph.connectCities(n99City, n103City);
		cityGraph.connectCities(n100City, n94City);
		cityGraph.connectCities(n100City, n99City);
		cityGraph.connectCities(n101City, n102City);
		cityGraph.connectCities(n101City, n105City);
		cityGraph.connectCities(n102City, n98City);
		cityGraph.connectCities(n103City, n104City);
		cityGraph.connectCities(n103City, n108City);
		cityGraph.connectCities(n104City, n100City);
		cityGraph.connectCities(n105City, n112City);
		cityGraph.connectCities(n106City, n102City);
		cityGraph.connectCities(n106City, n105City);
		cityGraph.connectCities(n107City, n108City);
		cityGraph.connectCities(n108City, n109City);
		cityGraph.connectCities(n109City, n104City);
		cityGraph.connectCities(n109City, n110City);
		cityGraph.connectCities(n110City, n115City);
		cityGraph.connectCities(n111City, n116City);
		cityGraph.connectCities(n112City, n111City);
		cityGraph.connectCities(n113City, n106City);
		cityGraph.connectCities(n113City, n112City);
		cityGraph.connectCities(n114City, n113City);
		cityGraph.connectCities(n115City, n116City);
		cityGraph.connectCities(n116City, n115City);
		cityGraph.connectCities(n1City, n2City);
		cityGraph.connectCities(n2City, n1City);
		cityGraph.connectCities(n6City, n7City);
		cityGraph.connectCities(n7City, n6City);
		cityGraph.connectCities(n110City, n111City);
		cityGraph.connectCities(n111City, n110City);


		
		
//		startCity = cityGraph.cities.get((int)Math.random()*2);
//        goalCity = cityGraph.cities.get(74);
//        cityPath1 = cityGraph.findPath(startCity, goalCity);
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain));
//		gameScreen.test.get(0).setGoal(goalCity);
		//cityPath.clear();
		
//		startCity = n1City;
//		goalCity = n16City;
//		cityPath2 = cityGraph.findPath(startCity, goalCity);
//        gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain));
//		gameScreen.test.get(1).setGoal(goalCity);
//		
//		startCity = cityGraph.cities.get((int)Math.random()*2);;
//		goalCity = n58City;
//		cityPath3 = cityGraph.findPath(startCity, goalCity);
//        gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain));
//		gameScreen.test.get(2).setGoal(goalCity);
		
	//	setpath();
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(0).setGoal(goalCity);
//		
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(1).setGoal(goalCity);
//		
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(2).setGoal(goalCity);
//
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(3).setGoal(goalCity);
//
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(4).setGoal(goalCity);
//
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(5).setGoal(goalCity);
//		
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(6).setGoal(goalCity);
//
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(7).setGoal(goalCity);
//
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(8).setGoal(goalCity);
//
//		worker = rand.nextInt(100)+1;
//		System.out.println("agent number " + i +" node number " + (worker +1));
//		i++;
//		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
//		goalCity = cityGraph.cities.get(worker);
//		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain,gameScreen));
//		gameScreen.test.get(9).setGoal(goalCity);

		setpath();

	}
	
    private void setpath()
    {
    	for(int i = 0; i < gameScreen.getNumAGV(); i++)
    	{
//    		startCity = cityGraph.cities.get((int)Math.random()*2);
//    		goalCity = cityGraph.cities.get((int)Math.random()*116);
//    		cityPath.add((cityGraph.findPath(startCity, goalCity)));
//    		gameScreen.test.add(new testAGV(gameScreen.world, cityGraph, startCity,gameScreen.testMain));
//    		gameScreen.test.get(i).setGoal(goalCity);
    		
    		worker = rand.nextInt(95)+5;
    		System.out.println("AGV number " + index +" node number " + (worker +1));
    		index++;
    		startCity = cityGraph.cities.get(rand.nextInt(1)+1);
    		goalCity = cityGraph.cities.get(worker);
    		cityPath.add((cityGraph.findPath(startCity, goalCity)));
    		gameScreen.getTest().add(new TestAGV(gameScreen.getWorld(), cityGraph, startCity,gameScreen.getTestMain(),gameScreen));
    		gameScreen.getTest().get(i).setGoal(goalCity);
    	}
    }
	

}
