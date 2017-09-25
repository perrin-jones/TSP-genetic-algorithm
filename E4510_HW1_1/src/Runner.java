import java.util.ArrayList;

public class Runner {
	//Runs the algorithm, decides how often it runs
	public static void main(String[] args) {
		String filename = args[1];
		File fileSystem = new File(filename);
		ArrayList<Point> points = fileSystem.getData();
		int numKeep = Integer.parseInt(args[3]);
		HillClimber algo = new HillClimber(points, numKeep);
		
		String archivePath = args[2];
		Archive arch = new Archive(archivePath);
		

		int iteration = Integer.parseInt(args[0]);
		int i = 0;
		double result;
		while(i < iteration) {
			result = algo.run();
			arch.save(iteration, result);
		}
		
		arch.closeArchive();
	}

}
