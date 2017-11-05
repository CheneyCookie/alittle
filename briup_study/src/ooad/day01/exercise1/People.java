package ooad.day01.exercise1;

public class People {
	String name;
	
	
	public People() {
	}

	public People(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void eat(Fruit fruit){
		System.out.println(name +"eat"+ fruit.getName());
	}

}
