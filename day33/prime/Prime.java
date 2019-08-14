package day33.prime;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Input a number");
			int num = sc.nextInt();

			boolean isPrime = isPrime(num);
			System.out.println(num + " is " + (isPrime ? "" : "not ") + "a prime number");
			
			if(isPrime) {
				break;
			}
		}

		System.out.println("Program will exit");
		sc.close();
	}

	public static boolean isPrime(int num) {
		int cnt = 0;
		if (num == 1) {
			return false;
		}

		for (int i = 2; i < num / 2; i++) {
			cnt++;
			if (num % i == 0) {
				System.out.println("cnt : "+cnt);
				return false;
			}
		}
		System.out.println("cnt : "+cnt);
		return true;
	}
}
