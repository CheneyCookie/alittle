package ooad.day03.exercise2;

public class Test {
	public static void main(String[] args) {
		// Action a=new People();
		// Action a=new DateDecorator(new People());
		// Action a=new BriupDecorator(new People());
		// Action a = new BriupDecorator(new DateDecorator(new People()));
		Action a = new DateDecorator(new BriupDecorator(new People()));

		a.say("cheney");
	}
}
