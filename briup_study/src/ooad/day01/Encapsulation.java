package ooad.day01;
/**
 * 测试封装特性
 * @author cheney
 * 2017.8.18
 */
public class Encapsulation {
	public static void main(String[] args) {
		Student s=new Student();
		s.doWork(new Work() {
			
			@Override
			public void doWork() {
				System.out.println("吃饭");
			}
		});
		double random = Math.random();
	}
}
