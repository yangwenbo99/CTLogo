package ctlogo.graphic;

public interface Screen {

	/**
	 * Draw line from (x1,y1) to (x2,y2)
	 * 
	 * @param x1 start point x1
	 * @param y1 start point y1
	 * @param x2 end point x2
	 * @param y2 end point y2
	 */
	public void drawLine(double x1, double y1, double x2, double y2);

	/**
	 * Draw Rectangle from (x1,y1) to (x2,y2)
	 * 
	 * @param x1 start point x1
	 * @param y1 start point y1
	 * @param x2 end point x2
	 * @param y2 end point y2
	 */
	public void drawRectangle(double x1, double y1, double x2, double y2);

	/**
	 * Draw Eclipse fit in the rectangle start from (cx,cy)
	 * 
	 * @param cx start point x
	 * @param cy start point y
	 * @param a  rectangle width a
	 * @param b  rectangle height b
	 */
	public void drawEclipse(double cx, double cy, double a, double b);

	/**
	 * Clean all shapes on the screen
	 */
	public void clean();

	/**
	 * set the width of the screen
	 * 
	 * @param w new width of the screen
	 */
	public void setWidth(double w);

	/**
	 * set the height of the screen
	 * 
	 * @param h
	 */
	public void setHeight(double h);

	/**
	 * set the weight of the stroke of the screen
	 * 
	 * @param s
	 */
	public void setStroke(double s);

	/**
	 * set the color of the painter
	 * 
	 * @param color
	 */
	public void setColor(String color);
}
