package ctlogo.graphic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class VectorRectangle extends VectorShape{

	public VectorRectangle(double startX, double startY, double endX, double endY) {
		super(startX, startY, endX, endY);
	}

	@Override
	public void draw(Graphics g) {
		((Graphics2D) g).setStroke(new BasicStroke((int)stroke));
		g.setColor(color);

		g.drawLine((int)startX, (int)startY, (int)endX, (int)startY);
		g.drawLine((int)startX, (int)startY, (int)startX, (int)endY);
		g.drawLine((int)startX, (int)endY, (int)endX, (int)endY);
		g.drawLine((int)endX, (int)startY, (int)endX, (int)endY);
	}
	
}
