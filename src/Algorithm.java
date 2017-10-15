import java.util.ArrayList;
import java.util.Random;

public class Algorithm {
	private double numMutate;
    private int numTourn;
    private ArrayList<Point> points;
    Random rand = new Random();
    
    public Algorithm(double mutate, int tourn, ArrayList<Point> newPoints) {
    	numMutate = mutate;
    	numTourn = tourn;
    	points = newPoints;
    }
    
    public Population evolve (Population population) {
		ArrayList<Point> tempPoints = (ArrayList<Point>) points.clone();
    	Population nextPopulation = new Population(population.getPathsSize(), tempPoints);
    	
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
		ArrayList<Point> tempPoints = (ArrayList<Point>) points.clone();
    	Path pathHybrid = new Path(tempPoints);
    	pathHybrid.clearPath();
    	
    	int start = (int) (rand.nextDouble() * path1.getPathLength());
    	int stop = (int) (rand.nextDouble() * path1.getPathLength());
    	
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
    	
    	for(int i = 0; i < path2.getPathLength(); i++) {
    		if(!pathHybrid.contains(path2.getPoint(i))) {
    			for(int j = 0; j < pathHybrid.getPathLength(); j++) {
    				if(pathHybrid.getPoint(j) == null) {
    					pathHybrid.setPoint(j, path2.getPoint(i));
    					break;
    				}
    			}
    		}
    	}
    	
    	return pathHybrid;
    }
    
    private Path compete(Population population) {
		ArrayList<Point> tempPoints = (ArrayList<Point>) points.clone();
    	Population tournement = new Population(numTourn, tempPoints);
    	String help = "";
    	for(int i = 0; i < numTourn; i++) {
    		int spot = (int) (rand.nextDouble() * population.getPathsSize());
    		tournement.setPath(i, population.getPath(spot));
    		help += spot + ",";
    	}
    	return tournement.searchFit();
    }
    
    private Path mutate(Path path) {
    	Path newPath = path;
    	for(int i = 0; i < newPath.getPathLength(); i++) {
    		if(numMutate > rand.nextDouble()) {
    			int j = (int) (rand.nextDouble() * newPath.getPathLength());
    			
    			//swap
    			Point temp = newPath.getPoint(i);
    			newPath.setPoint(i, newPath.getPoint(j));
    			newPath.setPoint(j, temp);
    		}
    	}
    	return newPath;
    }
}
