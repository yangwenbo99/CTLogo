package ctlogo.graphic;

public class VectorScreen implements Screen{

//	private static List<VectorShape> vectorShapeCollection= new ArrayList<VectorShape>();
//	
//	public static void addVectorShape(VectorShape vs) {
//		vectorShapeCollection.add(vs);
//	}

	@Override
	public void drawLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		VectorShape vs = new VectorLine(x1,y1,x2,y2);
		CTCanvas.addVectorShape(vs);
		new CTCanvas();
	}

	@Override
	public void drawRectangle(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		// FIXME don't know what kind of rectangle to draw and don't know the meaning of 4 parameters
	}

	@Override
	public void drawEclipse(double cx, double cy, double a, double b) {
		// TODO Auto-generated method stub
		// FIXME don't know what kind of rectangle to draw and don't know the meaning of 4 parameters
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		CTCanvas.removeAllVectorShape();
		new CTCanvas();
	}

	@Override
	public void setWidth(double w) {
		// TODO Auto-generated method stub
		CTCanvas.setWidth(w);
		new CTCanvas();
	}

	@Override
	public void setHeight(double h) {
		// TODO Auto-generated method stub
		CTCanvas.setHeight(h);
		new CTCanvas();
	}
	
//	public Iterable<VectorShape> getShapeList(){
//		// TODO Auto-generated method stub
//
//		return vectorShapeCollection;
//	}

}
