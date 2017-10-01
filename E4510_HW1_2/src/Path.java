import java.util.ArrayList;
import java.util.Collections;

public class Path {
	private ArrayList<Point> path = new ArrayList<Point>();
	private double distance = 0;
	private double fitness = 0;
	
	public Path (ArrayList<Point> newPath) {
		path = newPath;
		Collections.shuffle(path);
	}
	
	public Point getPoint(int pos) {
		return path.get(pos);
	}
	
	public void setPoint(int pos, Point point) {
		path.set(pos, point);
		this.resetValues();
	}
	
	public double getDistance() {
		if(distance == 0) {
			distance = path.get(0).getDistance(path.get(path.size()-1));
			for (int i = 0; i < path.size()-1; i++) {
				distance += path.get(i).getDistance(path.get(i+1));
			}
		}
		return distance;
	}
	
	public double getFitness() {
		if(fitness == 0) {
			fitness = 1/this.getDistance();
		}
		return fitness;
	}
	
	private void resetValues() {
		distance = 0;
		fitness = 0;
	}
	
	public ArrayList<Point> shufflePath() {
		Collections.shuffle(path);
		return path;
	}
	
	public int getPathLength() {
		return path.size();
	}
	
	public void clearPath() {
		for(int i = 0; i < this.getPathLength(); i++) {
			this.path.set(i, null);
		}
	}
	
	public boolean contains(Point point) {
		return path.contains(point);
	}
}
