import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		String filename = args[0];
		FileImport fileSystem = new FileImport(filename);
		ArrayList<Point> points = fileSystem.getData();
		
		int populationSize = 100;
		int generations = 100;
		double mutate = .03;
		int competeNum = 5;
		
		Population population = new Population(populationSize, points);
        System.out.println("Initial distance: " + population.searchFit().getDistance());
        
        Algorithm algo = new Algorithm(mutate, competeNum, points);
		
		for(int i = 0; i < generations; i++) {
			System.out.println(i + "    " + population.searchFit().getDistance());
			population = algo.evolve(population);
		}
		System.out.println("Finished");
        System.out.println("Final distance: " + population.searchFit().getDistance());
	}

}
