import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		String filename = args[0];
		FileImport fileSystem = new FileImport(filename);
		ArrayList<Point> points = fileSystem.getData();
		
		int populationSize = Integer.parseInt(args[1]);

	}

}
