package ctlogo.turtle;

import java.util.ArrayList;

public class TurtleManager {
	private static TurtleManager instance = null;
	private ArrayList<Turtle> allTurtles;

	private TurtleManager() {
		allTurtles = new ArrayList<Turtle>();
	}

	public static TurtleManager getInstance() {
		if (instance == null)
			instance = new TurtleManager();
		return instance;
	}

	public Turtle newTurtle(Turtle t) {
		allTurtles.add(t);
		return t;
	}

	public Turtle getTurtleByIndex(int index) {
//		FIXME  may be exception		
		return allTurtles.get(index);
	}

	public boolean activateTurtleByIndex(int index) throws Exception {
//		FIXME  have problem with the design and have no idea why it is designed like this	
		throw new Exception("Function not defined yet.");
	}

}
