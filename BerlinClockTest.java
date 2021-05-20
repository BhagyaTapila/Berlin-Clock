package Clock;

import static org.junit.Assert.*;


import org.junit.Test;

public class BerlinClockTest {

	@Test
	public void testTime1() {
		String Time="15:15:15";
		String expectedResult="O\r\n" + "RRRO\r\n" + "OOOO\r\n" + "YYROOOOOOOO\r\n" + "OOOO";
		BerlinClock berlinClock = new BerlinClock();
		String actualResult=berlinClock.convertTime(Time);
		assertEquals(expectedResult,actualResult);
		
	}
	@Test

	public void testTime2() {
		String Time="12:26:04";
		String expectedResult="Y\r\n" + "RROO\r\n" + "RROO\r\n" + "YYRYYOOOOOO\r\n" + "YOOO";
		BerlinClock berlinClock = new BerlinClock();
		String actualResult=berlinClock.convertTime(Time);
		assertEquals(expectedResult,actualResult);
		
	}

	@Test
     // In this the if the test is continuously on for three times then the YYY is replaced with YYR
	public void testTime3() {
		String Time="23:59:59";
		String expectedResult="O\r\n" + "RRRR\r\n" + "RRRO\r\n" + "YYRYYRYYRYY\r\n" + "YYYY";
		BerlinClock berlinClock = new BerlinClock();
		String actualResult=berlinClock.convertTime(Time);
		assertEquals(expectedResult,actualResult);
		
	}


	@Test
       // In this test minutes row(4th and 5th)of berlin clock are off 
	public void testTime4() {   
		String Time="24:00:00";
		String expectedResult="Y\r\n" + "RRRR\r\n" + "RRRR\r\n" + "OOOOOOOOOOO\r\n" + "OOOO";
		BerlinClock berlinClock = new BerlinClock();
		String actualResult=berlinClock.convertTime(Time);
		assertEquals(expectedResult,actualResult);
		
	}
}
