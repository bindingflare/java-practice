package day23;

public class OOP {
	public static void main(String args[]) {
		Animal cat = new Animal("Andy", 4);
		
		System.out.println("You now have a pet " + cat.getName() + " who is " + cat.getSize() + "m in height");
	}
}

class Animal {
	private String name;
	private int size;

	public Animal(String name, int size) {
		super();
		setName(name);
		setSize(size);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if(size > 0) {
			this.size = size;
		} else {
			System.out.println("Error! Pet size cannot be 0 or less");
		}
	}
}
