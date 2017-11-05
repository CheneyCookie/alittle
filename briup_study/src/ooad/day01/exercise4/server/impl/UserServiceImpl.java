package ooad.day01.exercise4.server.impl;

import java.util.List;

import ooad.day01.exercise4.bean.Role;
import ooad.day01.exercise4.bean.User;
import ooad.day01.exercise4.server.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public String login(String name, String password, List<User> users) {
		for (User user : users) {
			if (name.equals(user.getName())
					&& password.equals(user.getPassword())) {
				if(user.getRole()==Role.SUPER_ADMIN){
					return "sa";
				}else if(user.getRole()==Role.GENERAL_ADMIN){
					return "a";
				}else{
					return "m";
				}
			}
		}
		return "false";
	}

	@Override
	public String register(String name, String password,String rePassword, List<User> users) {
		for (User user : users) {
			if(name.equals(user.getName())){
				return "isExist";
			}
		}
		if(!password.equals(rePassword)){
			return "notEqual";
		}else{
			User user=new User(users.size()+1,name,password);
			users.add(user);
			return "success";
		}
		
	}

	@Override
	public boolean setPermission(String name,Role role, List<User> users) {
		for (User user : users) {
			if(name.equals(user.getName())){
				user.setRole(role);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean query(String name,List<User> users) {
		for (User user : users) {
			if(name==user.getName()){
				System.out.println(user);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isExist(String name, List<User> users) {
		for (User user : users) {
			if(name.equals(user.getName())){
				return true;
			}
		}
		return false;
	}
}
