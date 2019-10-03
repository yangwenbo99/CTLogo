package ctlogo.turtle;

public class Turtle {
	private double x;
	private double y;
	private double orientation;
	private double penWidth;
//	TODO set down definition
	private boolean down;

	public Turtle(){}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void shiftX(double sx) {
//		TODO revise shift definition
		this.x += sx;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void shiftY(double sy) {
//		TODO revise shift definition
		this.y += sy;
	}
	public void shiftXY(double sx, double sy) {
//		TODO revise shift definition
		this.x += sx;
		this.y += sy;
	}
	
	public double getOrientation() {
		return orientation;
	}
	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
	public void offsetOrientation(double offOrientation) throws Exception {
//		TODO add offsetOrientation definition		
		throw new Exception("Function not defined yet.");
	}

	public void popLocation() throws Exception {
//		TODO add popLocation definition		
		throw new Exception("Function not defined yet.");
	}
	public void hasLastLocation() throws Exception {
//		TODO add hasLastLocation definition	
		throw new Exception("Function not defined yet.");
	}	
	
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	
	public double getPenWidth() {
		return penWidth;
	}
	public void setPenWidth(double penWidth) {
		this.penWidth = penWidth;
	}
}
