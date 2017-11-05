package ooad.day01.exercise3;

public class UserServer {
	public static void main(String[] args) {
		User user=new User(1,"cheney");
		System.out.println(user);
		
		User user2=new User(2,"chen",Role.SUPER_ADMIN);
		System.out.println(user2);
	}
	
}
