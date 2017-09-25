import java.util.ArrayList;
import java.util.Collections;

public class HillClimber {
	private ArrayList<Point> points;
	private ArrayList<Path> route;
	private int numKeep;
	
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
			route.add(newPath);
		}
	}
	
	public double run() {
		Collections.sort(route);
		int kept = 0;
		ArrayList<Path> newRoute = new ArrayList<Path>();
		
		for(int i = 0; i < route.size(); i++) {
			Path newPath = route.get(i);
			if(!newPath.getKeep()) {
				if(kept < numKeep) {
					newPath.setKeep(true);
					newRoute.add(newPath);
					route.remove(i);
					i--;
					kept++;
				} else { 
					break;
				} 
			} else if(newPath.getKeep()) {
				newRoute.add(newPath);
				route.remove(i);
				i--;
			}
		}
		
		Collections.shuffle(route);
		
		if(route.size() % 2 == 1) {
			newRoute.add(route.get(route.size()-1));
			route.remove(route.size()-1);
		}
		for(int i = 0; i < route.size(); i+=2) {
			route.get(i).swap(route.get(i+1));
			newRoute.add(route.get(i));
			newRoute.add(route.get(i+1));
		}
		
		route = newRoute;

		return this.getRouteDistance();
	}
	
	private double getRouteDistance() {
		double totalDistance = 0;
		for(int i = 0; i < route.size(); i++) {
			totalDistance += route.get(i).getDistance();
		}
		return totalDistance;
	}
	
	public void getEvalNum() {
		long number = 0;
		for (int i=0; i < route.size(); i++) {
			number += 0;
		}
		System.out.println(number);
	}
}
