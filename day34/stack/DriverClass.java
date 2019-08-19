package day34.stack;

import java.util.Scanner;

public class DriverClass {
	public static void main(String[] args) {
		StackV2<Integer> stack = new StackV2<>(100);
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			printMenu();
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input) {
			case 1:
				System.out.println("추가할 숫자를 입력하세요");
				int number = Integer.parseInt(sc.nextLine());
				
				stack.push(number);
				
				break;
			case 2:
				System.out.println("pop: " + stack.pop());
				
				break;
			case 3:
				stack.print();
				
				break;
			case 4:
				System.out.println("프로그렘을 종료합니다");
				sc.close();
				System.exit(0);
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("원하시는 기능을 선택하세요");
		System.out.println("1.push\t2.pop\t3.print\t4.종료");
	}
}
