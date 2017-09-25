import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileImport {
	private Scanner reader;
	
	public FileImport (String filename) {
		File newFile = new File(filename);
		try {
			reader = new Scanner(newFile);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR WITH READING FILE");
			e.printStackTrace();
		}
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
