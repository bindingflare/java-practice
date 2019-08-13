package day32.enums;

public enum Rainbow {
	VIOLET(1), INDIGO(2), BLUE(3), GREEN(4), YELLOW(5), ORANGE(6), RED(7); // With no manual values they are
																			// automatically indexed from 0

	private final int value;

	Rainbow(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
