package day35.palindrome;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (;;) {
			System.out.print("Palindrome 여부를 검사할 단어를 입력하세요: ");
			String input = sc.nextLine();

			String msgComponent = "이 아닙니다";

			if (isPalindrome(input)) {
				msgComponent = "입니다";
			}

			System.out.println("이 단어는 Palindrome" + msgComponent + "!");

			System.out.println("종료하려면 1을 그렇지 않다면 다른숫자를 입력해주세요");
			input = sc.nextLine();

			if (input.equals("1")) {
				break;
			}
		}

		System.out.println("종료합니다");

		sc.close();
	}

	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}
}
