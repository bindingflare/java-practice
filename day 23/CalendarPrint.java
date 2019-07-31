package day23;

public class CalendarPrint {
	public static void main(String args[]) {
		final int monthSizes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		
		for(int month = 1; month <= 12; month++) {
			System.out.println(" -- " + month + "월 -- ");
			
			for(int day = 1; day <= monthSizes[month - 1]; day++) {
				System.out.print(day + "일 ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Solution #2");
		
		int mSize;
		
		for(int i = 1; i <= 13; i++) {
			// Inline if case to shift August to December down 1
			System.out.println(" -- " + (i < 9? i: i-1) + "월 --");
			
			// Extra 0 month between July and August for pattern consistency
			if(i == 8) {
				i++;
			}
			
			// General rule
			mSize = (i % 2 == 0? 30: 31);
			
			// Special case February
			if(i == 2) {
				mSize = 28;
			}
			
			for(int j = 1; j <= mSize; j++) {
				System.out.print(j + "일 ");
			}
			
			System.out.println();
		}
	}
}
