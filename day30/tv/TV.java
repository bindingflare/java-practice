package day30.tv;

public class TV {
	private String brand;
	private int prodYear;
	private int size;

	public TV(String brand, int prodYear, int size) {
		super();
		this.brand = brand;
		this.prodYear = prodYear;
		this.size = size;
	}

	public void show() {
		System.out.println(brand + "에서 만든 " + prodYear + "년형 " + size + "인치 TV");
	}

	public String getBrand() {
		return brand;
	}

	public int getProdYear() {
		return prodYear;
	}

	public int getSize() {
		return size;
	}
}
