package day26.animal;

public class AnimalDriver {
	public static void main(String[] args) {
		Animal animals[] = new Animal[4];

		animals[0] = new Cat();
		animals[1] = new Dog();
		animals[2] = new Rabbit();
		animals[3] = new Pig();

		for (int i = 0; i < animals.length; i++) {
			animals[i].say();
		}
	}
}
