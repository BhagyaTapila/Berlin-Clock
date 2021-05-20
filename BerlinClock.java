package Clock;

import java.util.Scanner;
import java.util.stream.Stream;

public class BerlinClock {

	public String convertTime(String aTime) {
		int[] parts = Stream.of(aTime.split(":")).mapToInt(Integer::parseInt).toArray(); // HH:MM:SS is converted into the HH,MM,SS
		
		StringBuffer time = new StringBuffer();
		
		return time.append(getSeconds(parts[2])).append(System.getProperty("line.separator"))
		.append(getTopHours(parts[0])).append(System.getProperty("line.separator")) 
		.append(getBottomHours(parts[0])).append(System.getProperty("line.separator"))
		.append(getTopMinutes(parts[1])).append(System.getProperty("line.separator")) 
		.append(getBottomMinutes(parts[1])).toString(); //  returns the substrings in the same sequence as written and gets printed line by line
		}
		private String getSeconds(int number) {
		if (number % 2 == 0)  // Checks if the remainder is 0
		return "Y";       // if remainder is 0 then Y will be printed
		else
		return "O";      // when if condition is not equal to zero then O is printed.
		}
		
		//for getting topHours
		private String getTopHours(int number)  {
		return getOnOff(4, getTopNumberOfOnSigns(number)); //returns to the getOnOff method with two parameters
		}
		private String getBottomHours(int number) {
		return getOnOff(4, number % 5); 
		}
		private String getTopMinutes(int number) {
		return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR"); // If the onsign is continuosly YYY then replace with YYR
		}
		private String getBottomMinutes(int number) {
		return getOnOff(4, number % 5, "Y");
		}
		private String getOnOff(int lamps, int onSigns) {
		return getOnOff(lamps, onSigns, "R");
		}
		private String getOnOff(int lamps, int onSigns, String onSign) {
		String out = "";
		for (int i = 0; i < onSigns; i++) {
		out += onSign; 
		}
		for (int i = 0; i < (lamps - onSigns); i++) {
		out += "O"; 
		}
		return out;
		}
		private int getTopNumberOfOnSigns(int number) {
		return (number - (number % 5)) / 5; 
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		BerlinClock berlinClock = new BerlinClock();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter time in HH:MM:SS format: ");  
		String time = scan.next();


		System.out.println(berlinClock.convertTime(time));



		}

}
