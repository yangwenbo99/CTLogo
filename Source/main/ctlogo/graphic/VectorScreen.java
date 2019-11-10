package ctlogo.graphic;

public class VectorScreen implements Screen{

	Iterable<VectorShape> vectorShapeCollection;
	
	@Override
	public void drawLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		
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
	
	public Iterable<VectorShape> getShapeList(){
		// TODO Auto-generated method stub

		return vectorShapeCollection;
	}

}
