package ooad.day02.exercise1.abstractfactory;

import ooad.day02.exercise1.common.ACar;
import ooad.day02.exercise1.common.Car;
/**
 * B车工厂
 * @author cheney
 *
 */
public class BCarFactory implements Factory{

	@Override
	public Car provider() {
		return new ACar();
	}

}
