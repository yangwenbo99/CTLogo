package ctlogo.graphic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class VectorLine extends VectorShape{

	public VectorLine(double startX, double startY, double endX, double endY) {
		super(startX, startY, endX, endY);
	}

	@Override
	public void draw(Graphics g) {
		((Graphics2D) g).setStroke(new BasicStroke((int)stroke));
		g.setColor(color);

		g.drawLine((int)startX, (int)startY, (int)endX, (int)endY);
	}

}
