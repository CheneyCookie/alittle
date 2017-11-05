package ooad.day02.exercise1.more;

import ooad.day02.exercise1.common.ACar;
import ooad.day02.exercise1.common.BCar;
import ooad.day02.exercise1.common.CCar;
import ooad.day02.exercise1.common.Car;
import ooad.day02.exercise1.common.SUV;
/**
 * 多工厂模式
 * @author cheney
 *
 */
public class MoreFactory {
	/**
	 * 处理A车
	 * @return A车对象
	 */
	public Car provideACar(){
		return new ACar();
	}
	/**
	 * 处理B车
	 * @return B车对象
	 */
	public Car provideBCar(){
		return new BCar();
	}
	/**
	 * 处理C车
	 * @return C车对象
	 */
	public Car provideCCar(){
		return new CCar();
	}
	
	/**
	 * 处理SUV
	 * @return SUV对象
	 */
	public Car provideSUV(){
		return new SUV();
	}
}
