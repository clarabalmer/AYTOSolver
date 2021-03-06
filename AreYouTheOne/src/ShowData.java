import java.util.ArrayList;

public class ShowData {
	//fields
	private ArrayList<WeekData> weekList = new ArrayList<>();
	private ArrayList<String[]> myGuesses = new ArrayList<>();
	
	//constructor
	ShowData(ArrayList<WeekData> weekList) {
		this.weekList = weekList;
	}
	
	//methods
	public void offerPossibleMatches() {
		//gives a list of possible matches
				for (int i = 0; i < weekList.size(); i++) {//unaccounted for lights
					System.out.println("Week " + (i + 1) + " has " + (weekList.get(i).getNumCorrect() - weekList.get(i).numOfMatch(weekList.get(i).getUncertainty())) + " matches unaccounted for:");
					for (int j = 0; j < 10; j++) {
						if (weekList.get(i).getUncertainty()[j] == 100) {
							System.out.println(weekList.get(i).getGirlsMaster().get(j) + " " + weekList.get(i).getBoys().get(j));
						}
					}
				}
	}
	public void guessMatch(String girl, String boy) {
		//check if guess has already been ruled out. If not, edit uncertainty array.
		for (int i = 0; i < weekList.size(); i++) { //in each WeekData
			if (boy.equalsIgnoreCase(weekList.get(i).getBoys().get(weekList.get(i).getGirlsMaster().indexOf(girl)))) { //if that match has been guessed, check certainty array
				switch (weekList.get(i).getCertaintyAtIndex(weekList.get(i).getGirlsMaster().indexOf(girl))) {
					case 0:
						System.out.println("This match has already been ruled out.");
						break;
					case 1:
						System.out.println("This match has already been proven.");
						break;
					case 100:
						weekList.get(i).matchUncertain(girl, boy);
						System.out.println("Guess received.");
					default:
						break;
				}
			}
		}
		System.out.println("This guess reduces possible solutions to approximately " + ". Recommend ");
	}
	//deduction methods
	public void updateCertainty() {
		for (int i = 0; i < weekList.size(); i++) {
			if (weekList.get(i).getTruthBoothResult()) { //if truthbooth found a match
				for (int j = 0; j < weekList.size(); j++) {
					weekList.get(j).matchCertain(weekList.get(i).getTruthBooth()[0], weekList.get(i).getTruthBooth()[1]);
				}
			} else {
				for (int j = 0; j < weekList.size(); j++) {
					weekList.get(j).noMatchCertain(weekList.get(i).getTruthBooth()[0], weekList.get(i).getTruthBooth()[1]);
				}
			}
		}
	}
}
