package ooad.day02.pattern.factorymode;
/**
 * 多工厂模式/静态工厂模式
 * @author cheney
 *
 */
public class MoreFactory {
	/**
	 * 生产苹果
	 * @return 苹果对象
	 */
	
	public static Fruit providerApple(){
		return new Apple();
	}
	/**
	 * 生产桃子
	 * @return 桃子对象
	 */
	public static Fruit providerPeach(){
		return new Peach();
	}
}
