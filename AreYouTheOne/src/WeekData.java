import java.util.ArrayList;
import java.util.Arrays;

public class WeekData {
	//fields
	private ArrayList<String> girlsMaster = new ArrayList<>(Arrays.asList(
			"Alyssa", "Camille", "Emma", "Francesca", "Julia",
			"Kaylen", "Mikala", "Nicole", "Tori", "Victoria"));
	private int weekNumber;
	private ArrayList<String> boys;
	private String[] truthBooth = new String[2];
	private boolean truthBoothResult;
	private int numCorrect;
	private int[] certainty = new int[10];
	private int[] uncertainty = new int[10];
	//100: no guess yet. 1: match. 0: not a match.
		
		
	//constructor:
	WeekData(int weekNumber, int numCorrect, ArrayList<String> boys, String truthBoothGirl, String truthBoothBoy, boolean truthBoothResult) {
		this.weekNumber = weekNumber;
		this.numCorrect = numCorrect;
		this.boys = boys;
		truthBooth[0] = truthBoothGirl;
		truthBooth[1] = truthBoothBoy;
		this.truthBoothResult = truthBoothResult;
		for (int i = 0; i < 10; i++) {
			setCertaintyAtIndex(i, 100);
			setUncertaintyAtIndex(i, 100);
		}
	}
	//deduction methods:
	public void matchUncertain(String girl, String boy) {
		if (boys.get(girlsMaster.indexOf(girl)).equalsIgnoreCase(boy)) {
			uncertainty[girlsMaster.indexOf(girl)] = 1;
		} else {
			uncertainty[girlsMaster.indexOf(girl)] = 0;
			uncertainty[boys.indexOf(boy)] = 0;
		}
	}
	public void noMatchUncertain(String girl, String boy) {
		if (boys.get(girlsMaster.indexOf(girl)).equalsIgnoreCase(boy)) {
			uncertainty[girlsMaster.indexOf(girl)] = 0;
		}
	}
	public void matchCertain(String girl, String boy) {
		if (boys.get(girlsMaster.indexOf(girl)).equalsIgnoreCase(boy)) {
			certainty[girlsMaster.indexOf(girl)] = 1;
		} else {
			certainty[girlsMaster.indexOf(girl)] = 0;
			certainty[boys.indexOf(boy)] = 0;
		}
	}
	public void noMatchCertain(String girl, String boy) {
		if (boys.get(girlsMaster.indexOf(girl)).equalsIgnoreCase(boy)) {
			certainty[girlsMaster.indexOf(girl)] = 0;
		}
	}
	//methods:
	public int numOfNoGuess(int[] certainty) {
		int sum = 0;
		for (int i = 0; i < certainty.length; i++) {
			sum += certainty[i];
		}
		return sum/100;
	}
	public int numOfMatch(int[] certainty) {
		int sum = 0;
		for (int i = 0; i < certainty.length; i++) {
			sum += certainty[i];
		}
		return sum%100;
	}
	public int numOfNoMatch(int[] certainty) {
		int sum = 0;
		for (int i = 0; i < certainty.length; i++) {
			sum += certainty[i];
		}
		return 10 - (numOfNoGuess(certainty) + numOfMatch(certainty));
	}

	//getters/setters
	public int getCertaintyAtIndex(int index) {
		return certainty[index];
	}
	public void setCertaintyAtIndex(int index, int num) {
		certainty[index] = num;
	}
	public int getUncertaintyAtIndex(int index) {
		return uncertainty[index];
	}
	public void setUncertaintyAtIndex(int index, int num) {
		uncertainty[index] = num;
	}
	public ArrayList<String> getBoys() {
		return boys;
	}
	public ArrayList<String> getGirlsMaster() {
		return girlsMaster;
	}
	public String[] getTruthBooth() {
		return truthBooth;
	}
	public boolean getTruthBoothResult() {
		return truthBoothResult;
	}
	public int getNumCorrect() {
		return numCorrect;
	}
	public int[] getUncertainty() {
		return uncertainty;
	}
}
