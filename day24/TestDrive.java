package day24;

public class TestDrive {
	public static void main(String args[]) {
		Dog dog = new Dog("James", 4, true);
		dog.bark();

		Dog[] pets = new Dog[7];

		pets[0] = new Dog("Andy", 9, true);
		pets[1] = dog;
		pets[2] = new Dog("Ruffles", 2, false);

		System.out.println(pets[0].getAge());
		pets[1].bark();
		pets[2].info();
	}
}

class Dog {
	private String name;
	private int age;
	private boolean treated;

	private boolean pet;
	private String owner;

	public Dog(String name, int age, boolean treated) {
		super();
		this.name = name;
		this.age = age;
		this.treated = treated;
	}

	public void bark() {
		System.out.println(getName() + " says: Ruff! Ruff!");
	}

	public void info() {
		System.out.println(getName() + " is " + age + " years old, is " + (treated ? "treated" : "not treated"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isTreated() {
		return treated;
	}

	public void setTreated(boolean treated) {
		this.treated = treated;
	}

	public boolean isPet() {
		return pet;
	}

	public void setPet(boolean pet) {
		this.pet = pet;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
