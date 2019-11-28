package ctlogo.graphic;

import java.awt.Color;

public class VectorScreen implements Screen {

//	private static List<VectorShape> vectorShapeCollection= new ArrayList<VectorShape>();
//	
//	public static void addVectorShape(VectorShape vs) {
//		vectorShapeCollection.add(vs);
//	}

	@Override
	public void drawLine(double x1, double y1, double x2, double y2) {

		double startX = x1 + CTCanvas.getCurrentWidth() / 2;
		double startY = -y1 + CTCanvas.getCurrentHeight() / 2;
		double endX = x2 + CTCanvas.getCurrentWidth() / 2;
		double endY = -y2 + CTCanvas.getCurrentHeight() / 2;

		VectorShape vs = new VectorLine(startX, startY, endX, endY);
		vs.setStroke(CTCanvas.getCurrentStroke());
		vs.setColor(CTCanvas.getCurrentColor());
		CTCanvas.addVectorShape(vs);
		new CTCanvas();
	}

	@Override
	public void drawRectangle(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		// 4 parameters
	}

	@Override
	public void drawEclipse(double cx, double cy, double a, double b) {
		// TODO Auto-generated method stub
		// 4 parameters
	}

	@Override
	public void clean() {
		CTCanvas.removeAllVectorShape();
		new CTCanvas();
	}

	@Override
	public void setWidth(double w) {
		CTCanvas.setWidth(w);
		new CTCanvas();
	}

	@Override
	public void setHeight(double h) {
		CTCanvas.setHeight(h);
		new CTCanvas();
	}

	@Override
	public void setStroke(double s) {
		CTCanvas.setStroke(s);
		new CTCanvas();
	}

	@Override
	public void setColor(String color) {
		Color c;
		try {
			c = (Color) Color.class.getField(color).get(null);
		} catch (Exception e) {
			c = CTCanvas.getCurrentColor();
		}
		CTCanvas.setColor(c);
		new CTCanvas();
	}

}
