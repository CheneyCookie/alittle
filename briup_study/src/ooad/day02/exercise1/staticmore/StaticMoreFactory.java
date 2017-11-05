package ooad.day02.exercise1.staticmore;

import ooad.day02.exercise1.common.ACar;
import ooad.day02.exercise1.common.BCar;
import ooad.day02.exercise1.common.CCar;
import ooad.day02.exercise1.common.Car;
import ooad.day02.exercise1.common.SUV;
/**
 * 静态工厂模式
 * @author cheney
 *
 */
public class StaticMoreFactory {
	/**
	 * 处理A车
	 * @return A车对象
	 */
	public static Car provideACar(){
		return new ACar();
	}
	/**
	 * 处理B车
	 * @return B车对象
	 */
	public static Car provideBCar(){
		return new BCar();
	}
	/**
	 * 处理C车
	 * @return C车对象
	 */
	public static Car provideCCar(){
		return new CCar();
	}
	
	/**
	 * 处理SUV
	 * @return SUV对象
	 */
	public static Car provideSUV(){
		return new SUV();
	}
}
