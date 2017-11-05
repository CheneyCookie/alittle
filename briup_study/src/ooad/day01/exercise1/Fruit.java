package ooad.day01.exercise1;

public abstract class Fruit {
	String name;

	public Fruit() {
		super();
	}

	public Fruit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}

}
