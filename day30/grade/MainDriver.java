package day30.grade;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("����, ����, ���� ������ �Է�");
		int math = Integer.parseInt(sc.nextLine());
		int science = Integer.parseInt(sc.nextLine());
		int english = Integer.parseInt(sc.nextLine());

		Grade grade = new Grade(math, science, english);
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("����� " + df.format(grade.average()));

		sc.close();
	}
}
