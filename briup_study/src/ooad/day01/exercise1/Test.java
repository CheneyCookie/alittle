package ooad.day01.exercise1;

public class Test {
	public static void main(String[] args) {
		People teacher=new People("王老师");
		People student=new People("小李同学");
		Fruit fruit1=new Apple();
		Fruit fruit2=new Banana();
		
		teacher.eat(fruit1);
		student.eat(fruit2);
	}
}
