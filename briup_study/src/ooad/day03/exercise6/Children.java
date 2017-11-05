package ooad.day03.exercise6;

public class Children extends AbstractSubject{

	@Override
	public void operation() {
		System.out.println("孩子病了");
		notifyObservers();
	}

}
