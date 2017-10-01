import java.util.ArrayList;

public class Population {
	private Path[] paths;
	private ArrayList<Point> points;
	
	public Population(int size, ArrayList<Point> newPoints) {
		paths = new Path[size];
		points = newPoints;
		
		for(int i = 0; i < size; i++) {
			Path newPath = new Path(points);
			newPath.shufflePath();
			paths[i] = newPath;
		}
	}
	
	public Path getPath(int pos) {
		return paths[pos];
	}
	
	public void setPath(int pos, Path newPath) {
		paths[pos] = newPath;
	}
	
	public int getPathsSize() {
		return paths.length;
	}
	
	//Searches for the most fit path and returns it
	public Path searchFit() {
		Path top = paths[0];
		for(int i = 1; i < this.getPathsSize(); i++) {
			if(top.getFitness() < paths[i].getFitness()) {
				top = paths[i];
			}
		}
		return top;
	}
}
