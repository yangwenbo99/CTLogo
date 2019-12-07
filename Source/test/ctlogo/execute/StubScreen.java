package ctlogo.execute;

public class StubScreen implements ctlogo.graphic.Screen {

	public static final StubScreen theInstance = new StubScreen();
	private int noLine = 0;
	private int noClean = 0;

	@Override
	public void drawLine(double x1, double y1, double x2, double y2) {
		noLine++;
	}

	@Override
	public void drawRectangle(double x1, double y1, double x2, double y2) {
	}

	@Override
	public void drawEclipse(double cx, double cy, double a, double b) {
	}

	@Override
	public void clean() {
		noClean++;
	}

	@Override
	public void setWidth(double w) {
	}

	@Override
	public void setHeight(double h) {
	}

	@Override
	public void setStroke(double s) {
	}

	@Override
	public void setColor(String color) {
	}

	/**
	 * @return the number of line
	 */
	public int getNoLine() {
		return noLine;
	}

	/**
	 * @return the number of clean
	 */
	public int getNoClean() {
		return noClean;
	}

	@Override
	public void draw() {
	}

}
