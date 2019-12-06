package ctlogo.turtle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCoordinate {

	private Coordinate cor0 = new Coordinate(0, 0);
	private Coordinate cor1 = new Coordinate(1.5, 2.75);
	private Coordinate cor2 = new Coordinate(-1.5, -2.75);
	private Coordinate cor3 = new Coordinate(1.5, -2.75);

	@Test
	void testGetX() {
		Assertions.assertEquals(1.5, cor1.getX());
	}

	@Test
	void testGetY() {
		Assertions.assertEquals(2.75, cor1.getY());
	}

	@Test
	void testNegate() {
		Assertions.assertEquals(cor2, cor1.negate());
	}

	@Test
	void testAddSub() {
		Assertions.assertEquals(cor1, cor0.add(cor1));
		Assertions.assertEquals(cor0, cor1.substract(cor1));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEquals() {
		Assertions.assertFalse(cor1.equals("ASDF"));
		Assertions.assertFalse(cor0.equals(cor1));
		Assertions.assertFalse(cor3.equals(cor1));
		Assertions.assertTrue(cor1.equals(cor1));
	}


}
