import java.util.ArrayList;
import java.util.Collections;

public class HillClimber {
	private ArrayList<Point> points;
	private ArrayList<Path> route;
	private int numKeep = 1;
	
	public HillClimber(ArrayList<Point> newPoints, int newNumKeep) {
		points = newPoints;
		this.setRoute();
		numKeep = newNumKeep;
	}
	
	private void setRoute() {
		route = new ArrayList<Path>();
		Path newPath = new Path(points.get(points.size()-1), points.get(0));
		route.add(newPath);
		
		for(int i = 0; i < points.size()-1; i++) {
			newPath = new Path(points.get(i), points.get(i+1));
		}
	}
	
	public double run() {
		Collections.sort(route);
		int kept = 0;
		ArrayList<Path> newRoute = new ArrayList<Path>();
		
		for(int i = 0; i < route.size(); i++) {
			Path newPath = route.get(i);
			if(!newPath.getKeep() && kept < numKeep) {
				if(kept < numKeep) {
					newPath.setKeep(true);
					route.remove(i);
				} else { 
					break;
				} 
			} 
		}
		
		Collections.shuffle(route);
		
		if(route.size() % 2 == 1) {
			newRoute.add(route.get(route.size()-1));
			route.remove(route.size()-1);
		}
		for(int i = 0; i < route.size(); i+=2) {
			route.get(i).swap(route.get(i+1));
		}

		return this.getRouteDistance();
	}
	
	private double getRouteDistance() {
		double totalDistance = 0;
		for(int i = 0; i < route.size(); i++) {
			totalDistance += route.get(i).getDistance();
		}
		return totalDistance;
	}
}
