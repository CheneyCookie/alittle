package ooad.day03.exercise2;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDecorator extends Decorator{

	public DateDecorator(Action action) {
		super(action);
	}
	
	public void say(String name){
		name=addDate(name);
		super.say(name);
	}
	
	public String addDate(String name){
		Format format=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		return name+":"+format.format(new Date());
	}
}
