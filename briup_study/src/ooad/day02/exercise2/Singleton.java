package ooad.day02.exercise2;

public class Singleton {
	private static Singleton s;
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(s==null){
			s=new Singleton();
		}
		return s;
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println(Singleton.getInstance());
	}
}
