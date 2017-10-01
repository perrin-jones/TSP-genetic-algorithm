import java.util.ArrayList;
import java.util.Collections;

public class Population {
	private Path[] paths;
	private ArrayList<Point> points = new ArrayList<Point>();
	
	public Population(int size, ArrayList<Point> newPoints) {
		paths = new Path[size];
		points = newPoints;
		
		for(int i = 0; i < size; i++) {
			ArrayList<Point> temp = (ArrayList<Point>) points.clone();
			Collections.shuffle(temp);
			Path newPath = new Path(temp);
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
