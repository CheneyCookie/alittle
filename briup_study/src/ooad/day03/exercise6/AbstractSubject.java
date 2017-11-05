package ooad.day03.exercise6;

import java.util.Vector;

public abstract class AbstractSubject implements Subject{

	private Vector<Observer> observers=new Vector<Observer>();
	@Override
	public void add(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void delete(Observer observer) {
		observers.removeElement(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.action();
		}
	}

	
}
