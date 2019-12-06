package ctlogo.graphic;

import java.awt.Color;

public class VectorScreen implements Screen {

	private CTCanvas currentCTCanvas = new CTCanvas();

	@Override
	public void drawLine(double x1, double y1, double x2, double y2) {

		// double startX = x1 + CTCanvas.getCurrentWidth() / 2;
		// double startY = -y1 + CTCanvas.getCurrentHeight() / 2;
		// double endX = x2 + CTCanvas.getCurrentWidth() / 2;
		// double endY = -y2 + CTCanvas.getCurrentHeight() / 2;

		VectorShape vs = new VectorLine(x1, y1, x2, y2);
		vs.setStroke(currentCTCanvas.getCurrentStroke());
		vs.setColor(currentCTCanvas.getCurrentColor());
		currentCTCanvas.addVectorShape(vs);
		currentCTCanvas.repaint();
	}

	@Override
	public void drawRectangle(double x1, double y1, double x2, double y2) {
		VectorShape vs = new VectorRectangle(x1, y1, x2, y2);
		vs.setStroke(currentCTCanvas.getCurrentStroke());
		vs.setColor(currentCTCanvas.getCurrentColor());
		currentCTCanvas.addVectorShape(vs);
		currentCTCanvas.repaint();
	}

	@Override
	public void drawEclipse(double cx, double cy, double a, double b) {
		VectorShape vs = new VectorEclipse(cx, cy, a, b);
		vs.setStroke(currentCTCanvas.getCurrentStroke());
		vs.setColor(currentCTCanvas.getCurrentColor());
		currentCTCanvas.addVectorShape(vs);
		currentCTCanvas.repaint();
	}

	@Override
	public void clean() {
		currentCTCanvas.removeAllVectorShape();
		currentCTCanvas.repaint();
	}

	@Override
	public void setWidth(double w) {
		currentCTCanvas.setWidth(w);
		currentCTCanvas.repaint();
	}

	@Override
	public void setHeight(double h) {
		currentCTCanvas.setHeight(h);
		currentCTCanvas.repaint();
	}

	@Override
	public void setStroke(double s) {
		currentCTCanvas.setStroke(s);
		currentCTCanvas.repaint();
	}

	@Override
	public void setColor(String color) {
		Color c;
		try {
			c = (Color) Color.class.getField(color).get(null);
		} catch (Exception e) {
			c = currentCTCanvas.getCurrentColor();
		}
		currentCTCanvas.setColor(c);
		currentCTCanvas.repaint();
	}

}
