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
		
		System.out.println();
		System.out.println();
		System.out.println("Using arrays");
		
		char[][] table = new char[size][size];
		char cha = 'A';
		
		for(int k = size - 1; k >= 0; k--) {
			for(int l = size - 1; l >= 0; l--) {
				table[l][k] = cha;
				
				if(cha == 'Z') {
					cha = 'A';
				} else {
					cha++;
				}
				
			}
		}
		
		for(int m = 0; m < size; m++) {
			for(int n = 0; n < size; n++) {
				System.out.print(table[m][n]);
			}
			
			System.out.println();
		}
	}
}
