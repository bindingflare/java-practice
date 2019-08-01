package day24;

public class Test {
	public static void main(String args[]) {
		Calculator calc = new Calculator();

		System.out.println(calc.add(10, 20));
		System.out.println(calc.subt(20, 5));
		System.out.println(calc.mult(4, 4));
		System.out.println(calc.divi(3, 98));
		System.out.println(calc.increm(3));
	}
}

class Calculator {
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int subt(int num1, int num2) {
		return num1 - num2;
	}

	public int mult(int num1, int num2) {
		return num1 * num2;
	}

	public double divi(int num1, int num2) {
		if (num2 == 0) {
			return 0;
		}

		return (double) num1 / num2;
	}

	public int increm(int num) {
		return ++num;
	}
}
