package ctlogo.turtle;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTurtleManager {

	TurtleManager mgr = TurtleManager.getInstance();
	Turtle t = new Turtle();

	@Test
	void test() {
		mgr.newTurtle(t);
		mgr.activateTurtleByIndex(1);
		Assertions.assertSame(t, mgr.getActiveTurtle());
		mgr.activateTurtleByIndex(0);
		Assertions.assertSame(t, TurtleManager.getInstance().getTurtleByIndex(1));
		Assertions.assertThrows(
				NoSuchElementException.class,
				() -> mgr.getTurtleByIndex(3));
	}

}
