package ooad.day02.singlemode;

/**
 * 单例模式/饿汉模式/懒汉模式
 * 
 * @author cheney
 *
 */
public class Single {
	/*
	 * 饿汉模式 private static Single single=new Single(); private Single(){
	 * 
	 * }
	 * 
	 * public static Single getInstance(){ return single; }
	 */
	/*
 	private static Single single = null;

	private Single() {
	}

	public static Single getInstance() {
		if (single == null) {
			synchronized (single) {
				if (single == null) {
					single = new Single();//原子操作
				}
			}
		}
		return single;
	}
	*/
	
	private volatile static boolean flag;
	
	private static class SingleFactory{
		private static Single single=new Single();
	}
	
	private Single(){
		if(!flag){
			flag=true;
		}else{
			throw new RuntimeException("重复");
		}
	}
	
	public static Single getInstance(){
		return SingleFactory.single;
	}
	private Object readResolver(){
		return SingleFactory.single;
	}
}
