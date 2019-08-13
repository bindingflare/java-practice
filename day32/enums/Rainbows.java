package day32.enums;

public class Rainbows {
	public static void main(String[] args) {
		Rainbow[] arr = Rainbow.values();

		for (Rainbow rb : arr) {
			System.out.println(rb + " " + rb.getValue() + " " + rb.ordinal());
		}
	}
}
