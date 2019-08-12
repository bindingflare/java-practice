package day31.counter;

public class Counter {
	static int count = 0;
	
	Counter() {
		count++;
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		Counter c1 = new Counter(); //c1.count
		Counter c2 = new Counter(); //c2.count
		
		System.out.println(Counter.count); //변수 및 메소드 불어올수있음
	}
}
