package day25;

public class Dog extends Animal {
	private int size;
	private int footNum;
	private DogType type;
	
	public Dog(String name, DogType type,  int size, int footNum) {
		setName(name);
		
		this.size = size;
		this.footNum = footNum;
		this.setType(type);
	}
	
	public Dog(String name, DogType type, int size) {
		this(name, type, size, 0);
	}
	
	public void sleep() {
		System.out.println(getName() + " is sleeping");
	}
	
	public void eat(int a) {
		System.out.println("The dog " + getName() + " ate " + a + " times");
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getFootNum() {
		return footNum;
	}

	public void setFootNum(int footNum) {
		this.footNum = footNum;
	}

	public String getType() {
		return type.toString();
	}

	public void setType(DogType type) {
		this.type = type;
	}
}
