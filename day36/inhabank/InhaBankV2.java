package day36.inhabank;

import java.util.Scanner;

public class InhaBankV2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numPpl = Integer.parseInt(sc.nextLine());

		int[] indivTimeSpent = new int[numPpl];

		for (int i = 0; i < numPpl; i++) {
			indivTimeSpent[i] = sc.nextInt();
		}

		int totalTime = 0;

		for (int i = 0; i < numPpl; i++) {
			int minIndex = 0;
			int min = 100;

			// Get min time
			for (int j = 0; j < numPpl; j++) {
				if (indivTimeSpent[j] < min) {
					min = indivTimeSpent[j];
					minIndex = j;
				}
			}

			// Remove the min time
			indivTimeSpent[minIndex] = 100;

			// Calculate total time
			totalTime += min * (numPpl - i);
		}

		System.out.println(totalTime);

		sc.close();
	}
}
