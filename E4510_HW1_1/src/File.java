import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class File {
	private Scanner reader;
	
	public File(String filename) {
		reader = new Scanner(filename);
	}
	
	public ArrayList<Point> getData() {
		ArrayList<Point> data = new ArrayList<Point>();
		
		while(reader.hasNextDouble()) {
			double x = reader.nextDouble();
			double y = reader.nextDouble();
			data.add(new Point(x,y));
		}
		
		Collections.shuffle(data);
		return data;
	}
}
