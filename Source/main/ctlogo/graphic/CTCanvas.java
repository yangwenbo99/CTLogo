package ctlogo.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class CTCanvas extends JFrame {

	public static List<VectorShape> vectorShapeCollection = new ArrayList<VectorShape>();

	public static void addVectorShape(VectorShape vs) {
		vectorShapeCollection.add(vs);
	}

	public CTCanvas() {
		super("CTCanvas");

		// create a empty canvas
		Canvas c = new Canvas() {

			// paint the canvas
			public void paint(Graphics g) {
				for(int i= 0;i<vectorShapeCollection.size();i++) {
					vectorShapeCollection.get(i).draw(g);
				}
			}
		};

		// set background
		c.setBackground(Color.white);
		add(c);
		setSize(400, 300);
		show();
	}

}