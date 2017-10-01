import java.util.ArrayList;

public class Algorithm {
	private double numMutate;
    private int numTourn;
    private ArrayList<Point> points;
    
    public Algorithm(double mutate, int tourn, ArrayList<Point> newPoints) {
    	numMutate = mutate;
    	numTourn = tourn;
    	points = newPoints;
    }
    
    public Population evolve (Population population) {
    	Population nextPopulation = new Population(population.getPathsSize(), points);
    	
    	for(int i = 0; i < nextPopulation.getPathsSize(); i ++) {
    		Path path1 = compete(population);
    		Path path2 = compete(population);
    		Path pathHybrid = this.crossover(path1, path2);
    		nextPopulation.setPath(i, pathHybrid);
    	}
    	
    	for(int j = 0; j < nextPopulation.getPathsSize(); j ++) {
    		nextPopulation.setPath(j, this.mutate(nextPopulation.getPath(j)));
    	}
    	
    	return nextPopulation;
    }
    
    private Path crossover(Path path1, Path path2) {
    	Path pathHybrid = new Path(points);
    	pathHybrid.clearPath();
    	
    	int start = (int) (Math.random() * path1.getPathLength());
    	int stop = (int) (Math.random() * path1.getPathLength());
    	
    	if(start > stop) {
    		//swap
    		int temp = start;
    		start = stop;
    		stop = temp;
    	}
    	
    	for(int i = 0; i < pathHybrid.getPathLength(); i++) {
    		if(i > start && i < stop) {
    			pathHybrid.setPoint(i, path1.getPoint(i));
    		}
    	}
    	
    	for(int i = 0; i < pathHybrid.getPathLength(); i++) {
    		if(!pathHybrid.contains(path2.getPoint(i))) {
    			for(int j = 0; j < pathHybrid.getPathLength(); j++) {
    				if(pathHybrid.getPoint(j) == null) {
    					pathHybrid.setPoint(j, path2.getPoint(i));
    				}
    			}
    		}
    	}
    	
    	return pathHybrid;
    }
    
    private Path compete(Population population) {
    	Population tournement = new Population(numTourn, points);
    	for(int i = 0; i < numTourn; i++) {
    		int spot = (int) (Math.random() * population.getPathsSize());
    		tournement.setPath(i, population.getPath(spot));
    	}
    	return tournement.searchFit();
    }
    
    private Path mutate(Path path) {
    	Path newPath = path;
    	for(int i = 0; i < newPath.getPathLength(); i++) {
    		if(numMutate > Math.random()) {
    			int j = (int) (Math.random() * newPath.getPathLength());
    			
    			//swap
    			Point temp = newPath.getPoint(i);
    			newPath.setPoint(i, newPath.getPoint(j));
    			newPath.setPoint(j, temp);
    		}
    	}
    	return newPath;
    }
}
