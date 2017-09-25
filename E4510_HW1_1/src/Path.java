
public class Path {
	private double distance;
	private Point source;
	private Point target;
	
	public Path(double weight, Point point1, Point point2) {
		this.distance = weight;
		this.source = point1;
		this.target = point2;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Point getSource() {
		return source;
	}

	public void setSource(Point source) {
		this.source = source;
	}

	public Point getTarget() {
		return target;
	}

	public void setTarget(Point target) {
		this.target = target;
	}
}
