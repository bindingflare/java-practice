package day29.guessgame;

import java.util.Scanner;

public class GuessGame {
	private Player[] players = new Player[3];
	
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < players.length; i++) {
			players[i] = new Player();
		}
		
		output("Guess a number between 0 to 50!");
		
		int newNum = (int) (Math.random() * 50);
		
		for(Player player : players) {
			player.reset(newNum);
		}
		
		boolean gameOver = false;
		
		for(;;) {
			output("P1 its your turn to guess the number!");
			players[0].guess(Integer.parseInt(sc.nextLine()));
			
			output("P2 its your turn to guess the number!");
			players[1].guess(Integer.parseInt(sc.nextLine()));
			
			output("P3 its your turn to guess the number!");
			players[2].guess(Integer.parseInt(sc.nextLine()));
			
			continuation();
			
			for(Player player : players) {
				if (player.validateGuess()) {
					gameOver = true;
				}
				
				continuation();
			}
			
			if(gameOver) {
				output("Game over! The number was " + newNum);
				break;
			}
		}
		
		sc.close();
	}
	
	public Player getPlayer(int index) {
		return players[index];
	}
	
	public static void output(String msg) {
		System.out.println("[GuessingGame] " + msg);
	}
	
	public static void characterOutput(String msg) {
		System.out.println("[GuessingMonkey] " + msg);
	}
	
	public static void continuation() {
		Scanner scanner = new Scanner(System.in);
		
		output("Press any key to continue");
		scanner.nextLine();
		
		scanner.close();
	}
}
