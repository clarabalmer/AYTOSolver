import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShowGuess {
	//fields
	private int week;
	private Map<String, String> showGuess = new TreeMap<>();
	private int numCorrect;
	private int[] certainty = new int[10];
	private int[] uncertainty = new int[10];
	//100: no guess yet. 1: match. 0: not a match.
	
	
	//constructor:
	public ShowGuess(int week, int numCorrect, List<String> girls, List<String> boys) {
		this.week = week;
		this.numCorrect = numCorrect;
		for (int i = 0; i < girls.size(); i++) {
			showGuess.put(girls.get(i), boys.get(i));
		}
		for (int i = 0; i < 10; i++) {
			setCertaintyAtIndex(i, 100);
			setUncertaintyAtIndex(i, 100);
		}
	}
	
	//methods:
	public int numOfNoGuess(int[] cert) {
		int sum = 0;
		for (int i = 0; i < cert.length; i++) {
			sum += cert[i];
		}
		return sum/100;
	}
	public int numOfMatch(int[] cert) {
		int sum = 0;
		for (int i = 0; i < cert.length; i++) {
			sum += cert[i];
		}
		return sum%100;
	}
	public int numOfNoMatch(int[] cert) {
		int sum = 0;
		for (int i = 0; i < cert.length; i++) {
			sum += cert[i];
		}
		return 10 - (numOfNoGuess(cert) + numOfMatch(cert));
	}
	
	public void certToString() {
		
	}
	
	
	
	public void setCertaintyAtIndex(int index, int num) {
		certainty[index] = num;
	}
	public int getCertaintyAtIndex(int index) {
		return certainty[index];
	}
	public void setUncertaintyAtIndex(int index, int num) {
		uncertainty[index] = num;
	}
	public int getUncertaintyAtIndex(int index) {
		return uncertainty[index];
	}
	public String getShowGuessMatch(String girl) {
		return showGuess.get(girl);
	}
	
}