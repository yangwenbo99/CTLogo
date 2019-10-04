package ctlogo.turtle;

public class Coordinate {
	private double x;
	private double y;
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() { return x; }
	public double getY() { return y; } 
	
	public boolean equals(Object other) {
		if (!(other instanceof Coordinate))
			return false;
		Coordinate otherCoordinate = (Coordinate) other;
		return this.x == otherCoordinate.x && this.y == otherCoordinate.y;
	}
	
	public Coordinate add(Coordinate other) {
		return new Coordinate(this.x + other.x, this.y + other.y);
	}
	
	public Coordinate substract(Coordinate other) {
		return new Coordinate(this.x - other.x, this.y - other.y);
	}
	
	public Coordinate negate() {
		return new Coordinate(-x, -y);
	}
	
}
