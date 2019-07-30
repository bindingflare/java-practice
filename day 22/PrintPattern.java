
package day22;

import java.util.Scanner;

// Updated ver. 3 to merge all patterns into 1 for loop and simplify logic

// Updated ver. 2 to fix type 1 pattern, merge double for when printing * for type 3

public class PrintPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input tower height");
		int height = sc.nextInt();

		System.out.println("Input tower type");
		int type = sc.nextInt();

		int starNum = 0;
		int spaceNum = 0;

		for (int i = 1; i <= height; i++) {
			if (type == 1) {
				starNum = i;
				spaceNum = 0;
			} else if (type == 2) {
				starNum = height + 1 - i;
				spaceNum = 0;
			} else if (type == 3) {
				starNum = 2 * i - 1;
				spaceNum = height - i;
			}

			for (int j = 0; j < spaceNum; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k < starNum; k++) {
				System.out.print("*");
			}

			System.out.println();
		}

//		int start = 0;
//		int end = 0;
//		int change = 0;
//
//		// Special case type 3
//		if (type == 3) {
//			for (int i = 0; i < height; i++) {
//				// Type 3
//				//   *
//				//  ***
//				// *****
//				
//				for (int j = 0; j < height - i; j++) {
//					System.out.print(" ");
//				}
//
//				for (int k = 0; k < i * 2 + 1; k++) {
//					System.out.print("*");
//				}
//
////				for (int l = 0; l < i; l++) {
////					System.out.print("*");
////				}
//
//				System.out.println();
//			}
//		} else {
//			if (type == 1) {
//				// Type 1
//				// *
//				// **
//				// ***
//
//				start = 1;
//				end = height + 1;
//				change = 1;
//			} else if (type == 2) {
//				// Type 2
//				// ***
//				// **
//				// *
//
//				start = height;
//				end = 0;
//				change = -1;
//			}
//
//			// Unified print for type 1, 2
//			for (int i = start; i != end; i = i + change) {
//				for (int j = 0; j < i; j++) {
//					System.out.print("*");
//				}
//
//				System.out.println();
//			}
//		}

		sc.close();
	}
}