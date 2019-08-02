package day25;

public class HouseDog extends Dog {
	public HouseDog(String name, DogType type, int size, int footNum) {
		super(name, type, size, footNum);
	}
	
	public HouseDog(String name, DogType type, int size) {
		super(name, type, size);
	}

	public void sleep() {
		System.out.println(getName() + " is sleeping in the house");
	}
	
	public void eat(int a) {
		System.out.println("The dog " + getName() + " ate " + a + " times in the house");
	}

	public void sleep(int hour) {
		System.out.println(getName() + " is sleeping in the house for " + hour + " hours");
	}
}
