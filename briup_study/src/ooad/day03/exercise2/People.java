package ooad.day03.exercise2;

public class People implements Action{

	@Override
	public void say(String name) {
		System.out.println("hello "+name);
	}

}
