package ooad.day03.exercise3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		Role role1=new Role("管理员");
		Role role2=new Role("普通用户");
		Role role3=new Role("访客");
		User user1=new User("cheney", role1);
		User user2=new User("ch", role2);
		User user3=new User("chen", role3);
		IUserService target=new UserServiceImpl();
		ClassLoader classLoader=target.getClass().getClassLoader();
		Class[] interfaces=target.getClass().getInterfaces();
		InvocationHandler handler=new MyHandler(target);
		IUserService proxy=(IUserService) Proxy.newProxyInstance(classLoader, interfaces, handler);
		
		proxy.showUsersInfo(user1);
		proxy.showUsersInfo(user2);
		proxy.showUsersInfo(user3);
	}
}
