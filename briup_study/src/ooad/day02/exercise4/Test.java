package ooad.day02.exercise4;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		C c=new C();
		B b=new B(c);
		A a=new A(b);
		System.out.println(a);
		try {
			System.out.println(a.clone());
			System.out.println(a.deepClone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
