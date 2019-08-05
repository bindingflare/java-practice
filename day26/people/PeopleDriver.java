package day26.people;

public class PeopleDriver {
	public static void main(String[] args) {
		Person[] people = new Person[2];

		people[0] = new Woman();
		people[1] = new Man();

		people[0].say();
		people[1].say();
		
		Firefighter[] firefighters = new Firefighter[2];
		
		firefighters[0] = new Firewoman();
		firefighters[1] = new Fireman();
		
		firefighters[0].firesup();
		firefighters[1].firesup();
	}
}
