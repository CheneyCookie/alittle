package ooad.day03.exercise4;

public class All {
	private A a;
	private B b;
	private C c;
	public All() {
		a=new A();
		b=new B();
		c=new C();
	}
	
	public void a(){
		a.a();
	}
	public void b(){
		b.b();
	}
	public void c(){
		c.c();
	}
	
	public void all(){
		a.a();
		b.b();
		c.c();
	}
}
