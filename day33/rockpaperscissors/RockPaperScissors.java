package day33.rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input 0 for rock, 1 for paper or 2 for scissors");
		int input = sc.nextInt();

		int result = play(Hand.toHand(input));
		String resultStr = "";

		switch (result) {
		case 0:
			resultStr = "won";
			break;
		case 1:
			resultStr = "drew";
			break;
		case 2:
			resultStr = "lost";
			break;
		}

		System.out.println("You " + resultStr + " the game!");
		sc.close();
	}

	// possible inputs -
	// 0 - Rock
	// 1 - Paper
	// 2 - Scissors

	// possible outputs
	// 0 = player win
	// 1 = draw
	// 2 = computer win
	public static int play(Hand playerHand) {
		Hand computerHand = Hand.toHand((int) Math.floor(Math.random() * 3));

		if (playerHand.wins(computerHand)) {
			return 0;
		} else if (playerHand == computerHand) {
			return 1;
		} else {
			return 2;
		}
	}

}
