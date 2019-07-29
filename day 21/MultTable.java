package day21;

public class MultTable {
	public static void main(String args[]) {
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j <= 12; j++) {
				System.out.print(j + " x " + i + " = " + i * j + "\t");
			}
			
			System.out.println("");
		}
	}
}
