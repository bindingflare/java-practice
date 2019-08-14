package day33.rockpaperscissors;

public enum Hand {
	ROCK, PAPER, SCISSORS;
	
	public static Hand toHand(int index) {
		for(Hand hand : Hand.values()) {
			if(hand.ordinal() == index) {
				return hand;
			}
		}
		
		return null;
	}
	
	public boolean wins(Hand hand2) {
		if(this == PAPER && hand2 == ROCK || this == ROCK && hand2 == SCISSORS || this == SCISSORS && hand2 == PAPER) {
			return true;
		}
		
		return false;
	}
}
