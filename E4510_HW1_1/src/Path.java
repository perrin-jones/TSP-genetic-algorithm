
public class Path implements Comparable<Path>{
	private double distance;
	private Point source;
	private Point target;
	private boolean keep;
	
	public Path(Point point1, Point point2) {
		source = point1;
		target = point2;
		this.distance = Math.hypot(source.getX()-target.getX(), source.getY()-target.getY());
		keep = false;
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
	
	public boolean getKeep() {
		return keep;
	}
	
	public void setKeep(boolean keep) {
		this.keep = keep;
	}
	
	public int compareTo(Path other) {
		return (int)(this.distance - other.getDistance());
	}

	public void swap(Path other) {
		Point temp = this.target;
		this.target = other.target;
		other.target = temp;
	
		this.distance = Math.hypot(this.source.getX()-this.target.getX(), this.source.getY()-this.target.getY());
		other.distance = Math.hypot(other.source.getX()-other.target.getX(), other.source.getY()-other.target.getY());
	}
	
}
