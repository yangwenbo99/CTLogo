package ctlogo.graphic;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class VectorTurtle extends VectorShape {
	private double orientation;

	public VectorTurtle(double startX, double startY, double orientation) {
		super(startX, startY, startX, startY);
		this.orientation = orientation;
	}

	@Override
	public void draw(Graphics g) {
		((Graphics2D) g).setStroke(new BasicStroke((int) stroke));
		g.setColor(color);

		// TODO change hard code of turtle size 10
		g.drawLine((int) startX, (int) startY, (int) (startX + 10 * Math.cos(orientation)),
				(int) (startY + 10 * Math.sin(orientation)));
		((Graphics2D) g).draw(new Ellipse2D.Double(startX - 10, startY - 10, 20, 20));
	}

}
