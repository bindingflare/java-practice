package day30.circle;

public class Circle {
	private double x;
	private double y;
	private double radius;

	public Circle(double x, double y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void show() {
		System.out.println("x=" + x + " y=" + y + " r=" + radius);
		System.out.println("≥–¿Ã: " + String.format("%.2f", radius * radius * 3.142));
		System.out.println("µ—∑π: " + String.format("%.2f", 2 * radius * 3.142));
	}
}
