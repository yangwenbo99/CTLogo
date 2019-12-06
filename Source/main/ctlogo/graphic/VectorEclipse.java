package ctlogo.graphic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class VectorEclipse extends VectorShape{

	public VectorEclipse(double startX, double startY, double endX, double endY) {
		super(startX, startY, endX, endY);
	}
	
	@Override
	public void draw(Graphics g) {
		// OPEN FOR EXTENSION
		((Graphics2D) g).setStroke(new BasicStroke((int)stroke));
		g.setColor(color);

		((Graphics2D) g).draw(new Ellipse2D.Double(startX, startY, endX, endY));
	}

}
