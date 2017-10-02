
public class Point {
	private double x;
	private double y; 
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getDistance(Point other) {
		EvaluationManager.bump();
		return Math.sqrt( Math.pow((this.getX()-other.getX()),2) + Math.pow((this.getY()-other.getY()),2) );
	}

	@Override
	public String toString() {
		return x + "\t" + y;
	}
	
	
}
