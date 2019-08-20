package day35.queue;

import java.util.Scanner;

public class DriverClass {
	public static void main(String[] args) {
		Queue queue = new Queue(100);
		
		Scanner sc = new Scanner(System.in);

		for (;;) {
			printMenu();
			int input = Integer.parseInt(sc.nextLine());

			switch (input) {
			case 1:
				System.out.println("추가할 숫자를 입력하세요");
				int number = Integer.parseInt(sc.nextLine());

				queue.enqueue(number);
				
				break;
			case 2:
				System.out.println("dequeue: " + queue.dequeue());

				break;
			case 3:
				queue.print();

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
		System.out.println("1.enqueue\t2.dequeue\t3.print\t4.종료");
	}
}
