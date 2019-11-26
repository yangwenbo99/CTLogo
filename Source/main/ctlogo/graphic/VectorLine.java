package ctlogo.graphic;

import java.awt.Graphics;

public class VectorLine extends VectorShape{

	public VectorLine(double startX, double startY, double endX, double endY) {
		super(startX, startY, endX, endY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine((int)startX, (int)startY, (int)endX, (int)endY);
	}

}
