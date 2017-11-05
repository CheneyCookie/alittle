package ooad.day02.pattern.factorymode;
/**
 * 链式编程
 * @author cheney
 *
 */
public class Test {
	public static void main(String[] args) {
//		CommonFactory factory = new CommonFactory();
//		Fruit fruit = factory.privider("apple");
//		fruit.sell();
		
//		MoreFactory moreFactory = new MoreFactory();
//		moreFactory.providerApple();
//		moreFactory.providerPeach();
		
//		new MoreFactory().providerApple().sell();
		
		MoreFactory.providerApple().sell();
	}
}
