package day36.change;

import java.util.Scanner;

public class ChangeReturn {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int changeReq = 1000 - sc.nextInt();

		int[] coinDenoms = { 500, 100, 50, 10, 5, 1 };
		int coinCount = 0;

		for (int coinDenom : coinDenoms) {
			coinCount += changeReq / coinDenom; // Integer division, answer always 
															// rounded down
			changeReq = changeReq % coinDenom;
			// Also %= operator could be used
		}

		System.out.println(coinCount);

		sc.close();
	}
}
