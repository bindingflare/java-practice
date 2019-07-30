package day22;

import java.util.Scanner;

public class PrintTables {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input table size (a x a) and then input type");
		int size = sc.nextInt();
		int type = sc.nextInt();

		int printnum = 0;
		int change = 0;

		for (int i = 1; i <= size; i++) {
			// Set parameters
			if (type == 1) {
				printnum = i;
				change = 0;
			} else if (type == 2) {
				if (i % 2 == 1) {
					printnum = 1;
					change = 1;
				} else {
					printnum = size;
					change = -1;
				}
			} else if (type == 3) {
				printnum = i;
				change = i;
			}

			for (int j = 0; j < size; j++) {
				System.out.print(printnum + "\t");

				printnum += change;
			}

			System.out.println();
		}

		sc.close();
	}
}
