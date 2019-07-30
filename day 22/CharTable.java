package day22;

import java.util.Scanner;

public class CharTable {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input size");
		int size = sc.nextInt();

		int startCh = 'A' + (size * size) - 1;
		
		for (int i = 0; i < size; i++) {
			int ch = startCh - i;
			
			for (int j = 0; j < size; j++) {
				System.out.print((char) ((ch - 'A') % 26 + 'A'));
				
				ch -= size;
			}
			
			System.out.println();
		}
		
		sc.close();
	}
}
