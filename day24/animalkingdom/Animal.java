package day24.animalkingdom;

public class Animal {
	private String localName;
	private String scientificName;

	int age;
	boolean gender; // 0 for male, 1 for female

	public Animal(String localName, String scientificName, int age, boolean gender) {
		super();
		this.localName = localName;
		this.scientificName = scientificName;
		this.age = age;
		this.gender = gender;
	}

	public void info() {
		System.out.println("Local Name: " + localName);
		System.out.println("Scientific Name: " + scientificName);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + (gender ? "Female" : "Male"));
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

}
