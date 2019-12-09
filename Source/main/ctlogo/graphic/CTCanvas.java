package ctlogo.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ctlogo.turtle.Turtle;
import ctlogo.turtle.TurtleManager;

public class CTCanvas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259034126975648423L;

	// TODO change hard code 400,300 to be configurable
	private double width = 400;
	private double height = 300;

	private double stroke = 1;
	private Color color = Color.black;

	private List<VectorShape> vectorShapeCollection = new ArrayList<VectorShape>();

	public double getCurrentWidth() {
		return width;
	}

	public double getCurrentHeight() {
		return height;
	}

	public double getCurrentStroke() {
		return stroke;
	}

	public Color getCurrentColor() {
		return color;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setStroke(double stroke) {
		this.stroke = stroke;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void addVectorShape(VectorShape vs) {
		synchronized (this) {
			vectorShapeCollection.add(vs);
		}
	}

	public void removeAllVectorShape() {
		synchronized (this) {
			vectorShapeCollection.clear();
		}
	}

	Canvas c;

	public CTCanvas() {
		super("CTCanvas");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// create a empty canvas
		c = new Canvas() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 7589226733217604406L;

			// paint the canvas
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				AffineTransform aftrans = new AffineTransform(getWidth() / getCurrentWidth(), 0, 0,
						-getHeight() / getCurrentHeight(), getWidth() / 2, getHeight() / 2);
				g2.transform(aftrans);

				synchronized (CTCanvas.this) {
					for (int i = 0; i < vectorShapeCollection.size(); i++) {
						vectorShapeCollection.get(i).draw(g2);
					}
				
					//draw turtle
					try {
						Turtle t = TurtleManager.getInstance().getActiveTurtle();
						if (t.isVisible()) {
							VectorShape vs = new VectorTurtle(t.getX(), t.getY(), t.getOrientation());
							vs.draw(g2);						
						}
					} catch (Exception e) {
						// will not happen
					}
				}
			}
		};

		// set background
		c.setBackground(Color.white);
		add(c);
		setSize((int) width, (int) height);
		setVisible(true);
	}

	@Override
	public void repaint() {
		super.repaint();
		c.repaint();
	}

	public void remove(VectorShape vs) {
		vectorShapeCollection.remove(vs);
	}

}
