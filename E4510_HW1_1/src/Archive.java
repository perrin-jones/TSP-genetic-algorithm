import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Archive {
	private FileWriter writer;
	private String path;
	
	public Archive(String newPath) {
		this.path = newPath;
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String filename = "result_" + timeStamp;
		try {
			writer = new FileWriter(path + filename);
		} catch (IOException e) {
			System.out.println("ERROR GENERATING RESULT FILE");
			e.printStackTrace();
		}
	}
	
	public void save(int step, double distance) {
		try {
			writer.write(step + "\t" + distance);
		} catch (IOException e) {
			System.out.println("ERROR SAVING DATA TO RESULT FILE");
			e.printStackTrace();
		}
	}
	
	public void closeArchive() {
		try {
			writer.close();
		} catch (IOException e) {
			System.out.println("ERROR CLOSING RESULT FILE");
			e.printStackTrace();
		}
	}
}
