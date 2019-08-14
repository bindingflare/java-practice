package day33.rockpaperscissors2;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] outcomes = { { "drew", "lost", "won" }, { "won", "drew", "lost" }, { "lost", "won", "drew" } };

		System.out.println("Input 0 for rock, 1 for paper or 2 for scissors");
		int input = sc.nextInt();
		int compInput = (int) Math.floor(Math.random() * 3);

		System.out.println("You " + outcomes[input][compInput] + " the game!");
		sc.close();
	}
}
