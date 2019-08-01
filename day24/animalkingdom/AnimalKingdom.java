package day24.animalkingdom;

public class AnimalKingdom {
	public static void main(String[] args) {
		Animal dog = new Animal("Golden Retriever", "Canis lupus familiaris", 5, false);
		AfricanForestElephant elephant = new AfricanForestElephant("London", 6, true, "Republic of the congo");

		Animal elephant2 = elephant;

		dog.info();
		System.out.println();

		elephant.info();
		System.out.println();

		elephant2.info();
		// elephant2.getName(); This is undefined

		elephant.getAge(); // This is possible
		
		System.out.println();
		System.out.println();
		
		Animal cat = new Animal("House Cat", "Felis catus", 7, true);
		Animal lion = new Animal("Lion", "Panthera leo", 8, false);
		Animal snake = new Animal("Barbados threadsnake", "Tetracheilostoma carlae", 8, false);
		
		Animal[] animals = {dog, elephant, cat, lion, snake};
		
		for(Animal animal : animals) {
			animal.info();
			System.out.println();
		}
	}
}
