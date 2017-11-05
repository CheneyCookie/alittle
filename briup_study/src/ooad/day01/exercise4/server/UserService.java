package ooad.day01.exercise4.server;

import java.util.List;

import ooad.day01.exercise4.bean.Role;
import ooad.day01.exercise4.bean.User;

public interface UserService {
	String login(String name,String password,List<User> users);
	
	String register(String name,String password,String rePassword,List<User> users);
	
	boolean query(String name,List<User> users);
	
	boolean setPermission(String name,Role role,List<User> users);
	
	boolean isExist(String name,List<User> users);
}
