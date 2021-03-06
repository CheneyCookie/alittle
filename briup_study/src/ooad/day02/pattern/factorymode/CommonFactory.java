package ooad.day02.pattern.factorymode;
/**
 * 生产水果的工厂类
 * @author cheney
 *
 */
public class CommonFactory {
	
	/**
	 * 生产对象
	 * @param type 生产的类型
	 * @return 返回生产的对象
	 */
	public Fruit privider(String type){
		if(type.equals("apple")){
			return new Apple();
		}else if(type.equals("peach")){
			return new Peach();
		}
		return null;
	}
}
