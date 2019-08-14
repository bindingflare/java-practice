package day33.rockpaperscissors3;

import java.util.Scanner;

// Rock paper scissors using nested switch case
public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input 0 for rock, 1 for paper or 2 for scissors");
		int input = sc.nextInt();

		int result = play(input);
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

	public static int play(int playerInput) {
		int compInput = (int) Math.floor(Math.random() * 3);

		switch (playerInput) {
		case 0:
			switch (compInput) {
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 0;
			}
		case 1:
			switch (compInput) {
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 2;
			}
		case 2:
			switch (compInput) {
			case 0:
				return 2;
			case 1:
				return 0;
			case 2:
				return 1;
			}
		}

		return -1;
	}

}
