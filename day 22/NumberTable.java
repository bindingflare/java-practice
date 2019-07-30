package day22;

import java.util.Scanner;

public class NumberTable {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input a number");
		int size = sc.nextInt();

		int count = 1;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(count + "\t");

				count++;
			}

			System.out.println();
		}

		sc.close();
	}
}
