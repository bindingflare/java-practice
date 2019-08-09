package day30.rectangle;

public class Rectangle {
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public Rectangle(int startX, int startY, int endX, int endY) {
		super();
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}

	public int getArea() {
		return (endY - startY) * (endX - startX);
	}

	public boolean contains(Rectangle rect) {
		if (startX <= rect.getStartX() && endX >= rect.getEndX() && startY <= rect.getStartY()
				&& endY >= rect.getEndY()) {
			return true;
		} else if (startX >= rect.getStartX() && endX <= rect.getEndX() && startY >= rect.getStartY()
				&& endY <= rect.getEndY()) {
			return true;
		}

		return false;
	}

	public void show() {
		System.out.println("(" + startX + ", " + startY + " -> " + endX + ", " + endY + ")이고 크기는 " + (endX - startX)
				+ "x" + (endY - startY) + "인 사각형");
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}
}
