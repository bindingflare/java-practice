package day35.palindrome;

import java.util.Scanner;

import day34.stack.Stack;
import day34.stack.StackV2;
import day35.queue.Queue;

public class PalindromeExtra {
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

	// TODO Check error
	public static boolean isPalindrome(String str) {
		Queue queue = new Queue(str.length());
		StackV2<Character> stack = new StackV2<>(str.length());
		
		for(int i = 0; i < str.length(); i++) {
			queue.enqueue(str.charAt(i));
			stack.push(str.charAt(i));
		}
		
		for(int i = 0; i < str.length() / 2; i++) {
			if(queue.dequeue() != stack.pop()) {
				return false;
			}
		}

		return true;
	}
}
