import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreYouTheOneMain {
	//girls in alphabetical order, always stays the same
	
	//boys in alphabetical order
	private static ArrayList<String> boysMaster = new ArrayList<>(Arrays.asList(
			"Cam", "Cameron", "Gio", "John", 
			"Morgan", "Prosper", "Sam", "Stephen", "Tyler"));
	//boys in order of which girl they are matched with each week
	private static ArrayList<String> boys1 = new ArrayList<>(Arrays.asList(
			"Sam", "Prosper", "John", 
			"Asaf", "Morgan", "Gio", 
			"Cameron", "Stephen", "Tyler", "Cam"));
	private static ArrayList<String> boys2 = new ArrayList<>(Arrays.asList(
			"Morgan", "Asaf", "Prosper",
			"Sam", "Cam", "Gio",
			"Cameron", "John", "Stephen", "Tyler"));
	private static ArrayList<String> boys3 = new ArrayList<>(Arrays.asList(
			"Sam", "Asaf", "Prosper",
			"Morgan", "Tyler", "Gio",
			"Cameron", "Cam", "Stephen", "John"));
	private static ArrayList<String> boys4 = new ArrayList<>(Arrays.asList(
			"Sam", "Asaf", "Cam",
			"Tyler", "Stephen", "Gio",
			"Cameron", "Prosper", "Morgan", "John"));
	private static ArrayList<String> boys5 = new ArrayList<>(Arrays.asList(
			"Sam", "Asaf", "Cam",
			"Gio", "Morgan", "Tyler",
			"Cameron", "Stephen", "John", "Prosper"));
	private static ArrayList<String> boys6 = new ArrayList<>(Arrays.asList(
			"Sam", "Asaf", "John",
			"Gio", "Stephen", "Prosper",
			"Cameron", "Tyler", "Morgan", "Cam"));
	private static ArrayList<String> boys7 = new ArrayList<>(Arrays.asList(
			"Sam", "Tyler", "Gio",
			"Asaf", "Stephen", "John",
			"Cameron", "Cam", "Morgan", "Prosper"));
	
	
	//to add a week, create static list of boys, declare new WeekData
	public static void main(String[] args) {
	
		WeekData week1 = new WeekData(1, 3, boys1, "Tori", "Prosper", false);
		WeekData week2 = new WeekData(2, 3, boys2, "Julia", "John", false);
		WeekData week3 = new WeekData(3, 4, boys3, "Mikala", "Cameron", true);
		WeekData week4 = new WeekData(4, 4, boys4, "Tori", "Asaf", false);
		WeekData week5 = new WeekData(5, 4, boys5, "Kaylen", "Gio", false);
		WeekData week6 = new WeekData(6, 4, boys6, "Alyssa", "Sam", true);
		WeekData week7 = new WeekData(7, 4, boys7, "Victoria", "Cam", false);
		
		ShowData season4 = new ShowData(new ArrayList<WeekData>(Arrays.asList(week1, week2, week3, week4, week5, week6, week7)));
		season4.updateCertainty();
		season4.offerPossibleMatches();
		
	}
//	public static void printAllWeekGuessMatches() {
//		for (int i = 1; i <= boyGuesses.size(); i++) {
//			System.out.println("In week " + i + ":");
//			System.out.println(getOneWeekGuessMatches(girlsMaster, boyGuesses.get(i)) + "\n");
//		}
//	}
	public static String getOneWeekGuessMatches(List<String> girls, List<String> boys) {
		String result = "";
		for (int i = 0; i < girls.size(); i++) {
			result += (girls.get(i) + "  " + boys.get(i) + "\n");
		}
		return result;
	}

}
