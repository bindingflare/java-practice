package day21;

import java.util.Scanner;

public class InputData {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input a number");
		int num = sc.nextInt();
		
		System.out.println("The number you typed is " + num);
		
		sc.close();
	}
}
