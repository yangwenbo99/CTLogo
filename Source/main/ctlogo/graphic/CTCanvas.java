package ctlogo.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class CTCanvas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259034126975648423L;
	// TODO change hard code 400,300 to be configurable
	private static double width = 400;
	private static double height = 300;

	private static double stroke = 1;
	private static Color color = Color.black;

	private static List<VectorShape> vectorShapeCollection = new ArrayList<VectorShape>();

	public static double getCurrentWidth() {
		return CTCanvas.width;
	}

	public static double getCurrentHeight() {
		return CTCanvas.height;
	}

	public static double getCurrentStroke() {
		return CTCanvas.stroke;
	}

	public static Color getCurrentColor() {
		return CTCanvas.color;
	}

	public static void setWidth(double width) {
		CTCanvas.width = width;
	}

	public static void setHeight(double height) {
		CTCanvas.height = height;
	}

	public static void setStroke(double stroke) {
		CTCanvas.stroke = stroke;
	}

	public static void setColor(Color color) {
		CTCanvas.color = color;
	}

	public static void addVectorShape(VectorShape vs) {
		vectorShapeCollection.add(vs);
	}

	public static void removeAllVectorShape() {
		vectorShapeCollection.clear();
	}

	public CTCanvas() {
		super("CTCanvas");

		// create a empty canvas
		Canvas c = new Canvas() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 7589226733217604405L;

			// paint the canvas
			public void paint(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				for (int i = 0; i < vectorShapeCollection.size(); i++) {
					vectorShapeCollection.get(i).draw(g2);
				}
			}
		};

		// set background
		c.setBackground(Color.white);
		add(c);
		setSize((int) width, (int) height);
		setVisible(true);
	}

}