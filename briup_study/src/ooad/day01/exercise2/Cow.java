package ooad.day01.exercise2;

public class Cow {
	private int age;

	public Cow() {
		age = 0;
	}

	public Cow(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void growUp() {
		age++;
	}

	public Cow birthCow() {
		Cow cow = null;
		if (age >= 4) {
			cow = new Cow();
		}
		return cow;
	}
}
