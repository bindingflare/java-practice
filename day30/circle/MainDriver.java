package day30.circle;

import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Circle c[] = new Circle[3];
		
		for(int i = 0; i < c.length; i++) {
			System.out.println("x, y, radius");
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			double r = sc.nextDouble();
			
			c[i] = new Circle(x, y, r);
		}
		
		for(int i = 0; i < c.length; i++) {
			c[i].show();
		}
		
		sc.close();
	}
}
