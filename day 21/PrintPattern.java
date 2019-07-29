package day21;

import java.util.Scanner;

public class PrintPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input tower height");
		int height = sc.nextInt();

		System.out.println("Input tower type");
		int type = sc.nextInt();

		int start = 0;
		int end = 0;
		int change = 0;

		// Special case type 3
		if (type == 3) {
			for (int i = 0; i < height; i++) {
				// Type 3
				//   *
				//  ***
				// *****
				
				for (int j = 0; j < height - i; j++) {
					System.out.print(" ");
				}

				for (int k = 0; k <= i; k++) {
					System.out.print("*");
				}

				for (int l = 0; l < i; l++) {
					System.out.print("*");
				}

				System.out.println();
			}
		} else {
			if (type == 1) {
				// Type 1
				// *
				// **
				// ***

				start = 0;
				end = height + 1;
				change = 1;
			} else if (type == 2) {
				// Type 2
				// ***
				// **
				// *

				start = height;
				end = 0;
				change = -1;

			}

			// Unified print nested for for type 1, 2
			for (int i = start; i != end; i = i + change) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}

				System.out.println();
			}
		}
		
		sc.close();
	}
}
