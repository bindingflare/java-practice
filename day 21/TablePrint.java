package day21;

import java.util.Scanner;

public class TablePrint {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input a number");
		int num = sc.nextInt();
		
		for(int i = 1; i <= 12; i++) {
			System.out.println(num + " x " + i + "\t= " + num * i);
		}
		
		System.out.println();
		
		sc.close();
	}
}
