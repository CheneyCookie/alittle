package ooad.day02.exercise1.abstractfactory;

import ooad.day02.exercise1.common.ACar;
import ooad.day02.exercise1.common.Car;
/**
 * A车工厂
 * @author cheney
 *
 */
public class ACarFactory implements Factory{

	@Override
	public Car provider() {
		return new ACar();
	}

}
