package ctlogo.graphic;

import java.awt.Color;
import java.awt.Graphics;

public abstract class VectorShape {

	/**
	 * 
	 */
	protected double startX;
	protected double startY;
	protected double endX;
	protected double endY;
	protected double stroke = 1;
	protected Color color = Color.black;

	public VectorShape(double startX, double startY, double endX, double endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	abstract public void draw(Graphics g);

	public void setStroke(double currentStroke) {
		this.stroke = currentStroke;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
