package day30.rectangle;

public class MainDriver {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 2, 8, 7);
		Rectangle s = new Rectangle(5, 5, 6, 6);
		Rectangle t = new Rectangle(1, 1, 10, 10);

		r.show();
		System.out.println("s의 면적은 " + s.getArea());

		if (t.contains(r)) {
			System.out.println("t는 r를 포함한다");
		} else {
			System.out.println("t는 r를 포함하지 않는다");
		}

		if (t.contains(s)) {
			System.out.println("t는 s를 포함한다");
		} else {
			System.out.println("t는 r를 포함하지 않는다");
		}
	}
}
