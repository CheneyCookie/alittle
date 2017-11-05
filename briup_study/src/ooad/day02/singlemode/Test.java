package ooad.day02.singlemode;

import java.lang.reflect.Constructor;

public class Test {
	public static void main(String[] args) {
//		Single s1 = Single.getInstance();
//		Single s2 = Single.getInstance();
//		Single s3 = Single.getInstance();
//		Single s4 = Single.getInstance();
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
		
		try {
			Class clazz=Class.forName("ooad.day02.singlemode.Single");
			Constructor constructor=clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			System.out.println(constructor.newInstance());
			System.out.println(constructor.newInstance());
			System.out.println(constructor.newInstance());
			System.out.println(constructor.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
