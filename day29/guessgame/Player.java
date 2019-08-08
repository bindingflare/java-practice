package day29.guessgame;

public class Player {
	private int number;
	private int guessNum;
	private boolean isGuessed;
	
	public void reset(int num) {
		number = num;
	}
	
	public void guess(int num) {
		guessNum = num;
		
		if(num == number) {
			isGuessed = !isGuessed;
		}
	}
	
	public boolean validateGuess() {
		if( guessNum != number) {
			if(guessNum < number) {
				GuessGame.output("Wrong number! The actual number is higher");
				
				if(guessNum + 10 > number) {
					GuessGame.characterOutput("Quite close to the bananas");
				} else if(guessNum + 25 > number) {
					GuessGame.characterOutput("You gotta work it");
				} else if(guessNum + 25 < number) {
					GuessGame.characterOutput("That's too far");
				}
			} else if(guessNum > number) {
				GuessGame.output("Wrong number! The actual number is lower");
				
				if(guessNum - 10 < number) {
					GuessGame.characterOutput("Quite close to the bananas");
				} else if(guessNum - 25 < number) {
					GuessGame.characterOutput("You gotta work it");
				} else if(guessNum - 25 >= number) {
					GuessGame.characterOutput("That's too far");
				}
			}
		} else {
			GuessGame.output("Thats the correct number!");
			GuessGame.characterOutput("Thats my man");
			isGuessed = true;
			return true;
		}
		
		return isGuessed;
	}
	
	public boolean isGuessed() {
		return isGuessed;
	}
	
	public int getNumber() {
		return number;
	}
}
