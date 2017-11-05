package ooad.day02.exercise1.abstractfactory;

import ooad.day02.exercise1.common.ACar;
import ooad.day02.exercise1.common.Car;
/**
 * C车工厂
 * @author cheney
 *
 */
public class CCarFactory implements Factory{

	@Override
	public Car provider() {
		return new ACar();
	}

}
