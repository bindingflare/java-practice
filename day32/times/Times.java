package day32.times;

import java.util.Calendar;

public class Times {
	public static void main(String[] args) {
		Calendar time = Calendar.getInstance();
		
		System.out.println(time.getTime());
		
		time.set(1900, 2, 5);
		System.out.println(time.getTime());
		
		time.add(1, 1);
		System.out.println(time.getTime());
		
		time.roll(Calendar.SECOND, 55);
		System.out.println(time.getTime());
		
		time.set(Calendar.YEAR, 2019);
		System.out.println(time.getTime());
	}
}
