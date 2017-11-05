package ooad.day02.pattern.factorymode;
/**
 * 苹果工厂
 * @author cheney
 *
 */
public class AppleFactory implements Factory{

	@Override
	public Fruit provider() {
		
		return new Apple();
	}

}
