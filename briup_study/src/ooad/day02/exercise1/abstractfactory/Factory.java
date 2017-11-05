package ooad.day02.exercise1.abstractfactory;

import ooad.day02.exercise1.common.Car;
/**
 * 工厂接口
 * @author cheney
 *
 */
public interface Factory {
	/**
	 * 处理汽车
	 * @return 汽车对象
	 */
	public Car provider();
}
