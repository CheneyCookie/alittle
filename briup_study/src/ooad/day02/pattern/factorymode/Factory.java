package ooad.day02.pattern.factorymode;
/**
 * 工厂接口
 * @author cheney
 *
 */
public interface Factory {
	/**
	 * 生产水果
	 * @return
	 */
	public Fruit provider();
}
