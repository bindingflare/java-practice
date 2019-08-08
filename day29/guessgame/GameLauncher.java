package day29.guessgame;

public class GameLauncher {
	public static void main(String[] args) {
		System.out.println("Launching game....");
		
		GuessGame game = new GuessGame();
		game.startGame();
	}
}
