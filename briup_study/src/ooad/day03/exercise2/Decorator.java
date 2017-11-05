package ooad.day03.exercise2;

public class Decorator implements Action{
	private Action action;

	public Decorator(Action action) {
		super();
		this.action = action;
	}

	@Override
	public void say(String name) {
		this.action.say(name);
	}
	
}
