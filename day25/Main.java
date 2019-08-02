package day25;

public class Main {
	public static void main(String[] args) {
		HouseDog hsd = new HouseDog("Bro", DogType.BULLDOG, 10, 20);
		hsd.setName("baby");
		hsd.sleep();
		hsd.sleep(3);
		
		Dog d = (Dog) hsd;
		d.sleep();
		//d.sleep(3); ¿Ã∞« æ»µ 
		
		System.out.println("Dog type: " + hsd.getType());
		hsd.eat(1);
		d.eat(3);
		
		Dog dog = new Dog("Fluffles", DogType.GOLDEN_RETRIEVER, 4);
		dog.eat(10);
		
		dog.sleep();
	}
}
