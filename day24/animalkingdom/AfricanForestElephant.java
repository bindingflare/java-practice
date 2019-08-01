package day24.animalkingdom;

public class AfricanForestElephant extends Animal {
	private String name;
	private String localityName;

	public AfricanForestElephant(String name, int age, boolean gender, String localityName) {
		super("African Forest Elephant", "Loxodonta cyclotis", age, gender);

		this.name = name;
		this.localityName = localityName;
	}

	public void info() {
		super.info();

		System.out.println("Given name: " + name);
		System.out.println("In locality: " + localityName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
