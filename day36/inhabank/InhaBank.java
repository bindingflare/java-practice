package day36.inhabank;

import java.util.Scanner;

public class InhaBank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numPpl = Integer.parseInt(sc.nextLine());

		int[] indivTimeSpent = new int[numPpl];

		for (int i = 0; i < numPpl; i++) {
			indivTimeSpent[i] = sc.nextInt();
		}

		int cumulativeTime = 0;
		int totalTime = 0;

		for (int i = 0; i < numPpl; i++) {
			int minIndex = 0;
			int min = 10000;

			for (int j = 0; j < numPpl; j++) {
				if (indivTimeSpent[j] < min) {
					min = indivTimeSpent[j];
					minIndex = j;
				}
			}

			indivTimeSpent[minIndex] = 10000;

			cumulativeTime += min;
			totalTime += cumulativeTime;
		}

		System.out.println(totalTime);

		sc.close();
	}
}
