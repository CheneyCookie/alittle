package ooad.day02.exercise1.common;

/**
 * 处理汽车业务的工厂
 * 
 * @author cheney
 *
 */
public class CommonFactory {
	/**
	 * 生产对象
	 * @param type 生产的类型
	 * @return 生产的对象
	 */
	public Car privider(String type) {
		if (type.equals("ACar")) {
			return new ACar();
		} else if (type.equals("BCar")) {
			return new BCar();
		} else if (type.equals("CCar")) {
			return new CCar();
		} else if (type.equals("SUV")) {
			return new SUV();
		}
		return null;

	}
}
