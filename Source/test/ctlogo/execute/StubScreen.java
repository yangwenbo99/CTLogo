package ctlogo.execute;

public class StubScreen implements ctlogo.graphic.Screen {
	
	public static final StubScreen theInstance = new StubScreen();

	@Override
	public void drawLine(double x1, double y1, double x2, double y2) {
	}

	@Override
	public void drawRectangle(double x1, double y1, double x2, double y2) {
	}

	@Override
	public void drawEclipse(double cx, double cy, double a, double b) {
	}

	@Override
	public void clean() {
	}

	@Override
	public void setWidth(double w) {
	}

	@Override
	public void setHeight(double h) {
	}
	
}