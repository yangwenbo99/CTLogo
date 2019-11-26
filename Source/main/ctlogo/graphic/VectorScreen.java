package ctlogo.graphic;

import java.util.ArrayList;

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
		
	}

	@Override
	public void drawEclipse(double cx, double cy, double a, double b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(double w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(double h) {
		// TODO Auto-generated method stub
		
	}
	
//	public Iterable<VectorShape> getShapeList(){
//		// TODO Auto-generated method stub
//
//		return vectorShapeCollection;
//	}

}
