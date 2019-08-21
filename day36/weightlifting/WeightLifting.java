package day36.weightlifting;

import java.util.Scanner;

public class WeightLifting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ropeCount = Integer.parseInt(sc.nextLine());

		int min = 100000;

		// Get minimum possible weight distr.
		for (int i = 0; i < ropeCount; i++) {
			int weightLimit = sc.nextInt();

			if (weightLimit < min) {
				min = weightLimit;
			}
		}

		System.out.println(ropeCount * min);

		sc.close();

	}

}
