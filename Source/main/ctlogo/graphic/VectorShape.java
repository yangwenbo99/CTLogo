package ctlogo.graphic;

import java.awt.Graphics;

public abstract class VectorShape {

	/**
	 * 
	 */
	protected double startX;
	protected double startY;
	protected double endX;
	protected double endY;

	public VectorShape(double startX, double startY, double endX, double endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}

	abstract public void draw(Graphics g);

}
