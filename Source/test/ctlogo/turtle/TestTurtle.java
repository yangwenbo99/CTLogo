package ctlogo.turtle;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTurtle {

	Turtle tur = new Turtle(10);

	@Test
	void testSetGetX() {
		tur.setX(10);
		Assertions.assertEquals(10, tur.getX());
	}

	@Test
	void testSetGetY() {
		tur.setY(10);
		Assertions.assertEquals(10, tur.getY());
	}

	@Test
	void testSetGetXY() {
		tur.setXY(1, 3);
		Assertions.assertEquals(1, tur.getX());
		Assertions.assertEquals(3, tur.getY());
	}

	@Test
	void testShiftX() {
		tur.setXY(1, 1);
		tur.shiftX(9);
		Assertions.assertEquals(10, tur.getX());
		Assertions.assertEquals(1,  tur.getY());
	}

	@Test
	void testShiftY() {
		tur.setXY(1, 1);
		tur.shiftY(4);
		Assertions.assertEquals(1, tur.getX());
		Assertions.assertEquals(5, tur.getY());
	}

	@Test
	void testShiftXY() {
		tur.setXY(1, 1);
		tur.shiftXY(2, 3);
		Assertions.assertEquals(3, tur.getX());
		Assertions.assertEquals(4, tur.getY());
	}

	@Test
	void testOverflow() {
		tur.setXY(0, 0);
		for (int i=0; i<20; i++) {
			tur.shiftXY(2, 3);
		}
		Assertions.assertEquals(40, tur.getX());
		Assertions.assertEquals(60, tur.getY());
	}

	@Test
	void testGetSetPenWidth() {
		tur.setPenWidth(7);
		Assertions.assertEquals(7, tur.getPenWidth());
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> tur.setPenWidth(-1));
	}

	@Test
	void testGetSetVisible() {
		tur.setVisible(false);
		Assertions.assertFalse(tur.isVisible());
		tur.setVisible(true);
		Assertions.assertTrue(tur.isVisible());
	}

	@Test 
	void testPopLocation() {
		tur.setXY(1, 3);
		Assertions.assertEquals(1, tur.getX());
		Assertions.assertEquals(3, tur.getY());
		tur.popLocation();
		Assertions.assertEquals(0, tur.getX());
		Assertions.assertEquals(0, tur.getY());
		Assertions.assertThrows(
				NoSuchElementException.class,
				() -> tur.popLocation());
	}

	@Test
	void testSetOrientation() {
		tur.setOrientation(Math.PI);
		Assertions.assertEquals(Math.PI, tur.getOrientation());

		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> tur.setOrientation(Math.PI + 1));
		Assertions.assertThrows(
				IllegalArgumentException.class,
				() -> tur.setOrientation(-Math.PI - 1));
	}

	@Test 
	void testOffsetOrientation() {
		tur.setOrientation(Math.PI / 2);
		tur.offsetOrientation(Math.PI/4);
		Assertions.assertEquals(Math.PI * 3 / 4, tur.getOrientation());

		// overflow
		tur.setOrientation(Math.PI / 2);
		tur.offsetOrientation(Math.PI);
		Assertions.assertEquals(- Math.PI / 2, tur.getOrientation());
		// underflow
		tur.setOrientation(-Math.PI / 2);
		tur.offsetOrientation(-Math.PI);
		Assertions.assertEquals(Math.PI / 2, tur.getOrientation());
	}

	@Test
	void testGetSetDown() {
		tur.setDown(false);
		Assertions.assertFalse(tur.isDown());
		tur.setDown(true);
		Assertions.assertTrue(tur.isDown());
	}
}
