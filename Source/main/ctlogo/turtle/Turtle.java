package ctlogo.turtle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Turtle {
	private double orientation;
	private double penWidth;
	private boolean isDown;
	
	public static final int DEFAULT_MAX_HISTORY_LENGTH = 100;
	
	private int maxHistoryLength;
	private Deque<Coordinate> history;
	
	public Turtle() {
		this(DEFAULT_MAX_HISTORY_LENGTH);
		setCoordinate(new Coordinate(0, 0));
		setDown(true);
	}

	public Turtle(int maxHistoryLength){
		history = new ArrayDeque<Coordinate>();
		this.maxHistoryLength = maxHistoryLength;
	}
	
	private void setCoordinate(Coordinate c) {
		history.addLast(c);
		if (history.size() > maxHistoryLength) 
			history.removeFirst();
	}
	
	private Coordinate getCoordinate() {
		return history.getLast();
	}
	
	public double getX() {
		return getCoordinate().getX();
	}
	public void setX(double x) {
		setCoordinate(new Coordinate(x, getCoordinate().getY()));
	}

	public void shiftX(double sx) {
		setCoordinate(getCoordinate().add(new Coordinate(sx, 0)));
	}
	public double getY() {
		return getCoordinate().getY();
	}
	public void setY(double y) {
		setCoordinate(new Coordinate(getCoordinate().getX(), y));
	}
	public void shiftY(double sy) {
		setCoordinate(getCoordinate().add(new Coordinate(0, sy)));
	}
	public void shiftXY(double sx, double sy) {
		setCoordinate(getCoordinate().add(new Coordinate(sx, sy)));
	}
	
	public double getOrientation() {
		return orientation;
	}
	
	/**
	 * Set the orientation of the turtle.
	 * 
	 * @param orientation the orientation to be set, should between -pi to pi. 
	 * 
	 * @throws IllegalArgumentException if orientation is not between -pi and pi
	 */
	public void setOrientation(double orientation) {
		if (orientation > Math.PI || orientation < - Math.PI)
			throw new IllegalArgumentException(String.format(
					"Orientation should between -pi and pi, %f given",
					orientation));
		this.orientation = orientation;
	}

	/**
	 * Set the orientation of the turtle. 
	 * 
	 * @param offOrientation offset
	 * 
	 * If the orientation is not between -pi and pi after offsetting,
	 * it will be shifted to between -pi and pi.
	 */
	public void offsetOrientation(double offOrientation) {
		orientation += offOrientation;
		while (orientation < - Math.PI)
			orientation += 2 * Math.PI;
		while (orientation > Math.PI)
			orientation -= 2 * Math.PI;
	}

	/**
	 * @throws NoSuchElementException if no history
	 */
	public void popLocation() {
		if (history.size() <= 1)
			throw new NoSuchElementException("The last history item cannot be poped.");
		history.removeLast();
	}
	public boolean hasLastLocation() {
//		TODO add hasLastLocation definition	
		return !history.isEmpty();
	}	
	
	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean down) {
		this.isDown = down;
	}
	
	public double getPenWidth() {
		return penWidth;
	}

	/**
	 * Set the pen width of current turtle.
	 * 
	 * @param penWidth the width of pen
	 * 
	 * @throws IllegalArgumentException if penwidth < 0
	 */
	public void setPenWidth(double penWidth) {
		if (penWidth < 0)
			throw new IllegalArgumentException("Pen width cannot be negative");
		this.penWidth = penWidth;
	}
}
