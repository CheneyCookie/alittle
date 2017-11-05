package ooad.day03.exercise2;

public class BriupDecorator extends Decorator{

	public BriupDecorator(Action action) {
		super(action);
	}

	@Override
	public void say(String name) {
		name=addBriup(name);
		super.say(name);
	}
	
	public String addBriup(String name){
		return "briup_"+name;
	}

}
