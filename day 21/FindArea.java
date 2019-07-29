package day21;

import java.util.Scanner;

public class FindArea {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input max length");
		int length = sc.nextInt();
		
		System.out.println("Input max height");
		int height = sc.nextInt();
		
		System.out.println();
		System.out.println("Total possible areas:");
		
		for(int i = 1; i <= length; i++) {
			for(int j = 1; j <= height; j++) {
				System.out.print("| " + j + " x " + i + "\t(" + i * j + ")\t");
			}
			
			System.out.println("|");
		}
		
		sc.close();
	}
}
