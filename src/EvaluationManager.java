
public class EvaluationManager {
	static int numEval = 0;
	
	public static void bump() {
		numEval++;
	}
	
	public static String print() {
		return "" + numEval;
	}
}
