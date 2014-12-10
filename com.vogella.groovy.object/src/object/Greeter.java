package object;

public class Greeter {

	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {

		this.owner = owner;

	}

	public String greet(String name) {

		return "Hello" + name + ",I am " + owner;

	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();

		greeter.setOwner("Lars");

		System.out.println(greeter.greet("Marion"));
	}
}
