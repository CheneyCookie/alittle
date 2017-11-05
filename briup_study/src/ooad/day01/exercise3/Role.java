package ooad.day01.exercise3;

import java.util.ArrayList;
import java.util.List;

public enum Role {
	SUPER_ADMIN("超级管理员",Permission.ADD,Permission.DELETE,Permission.UPDATE,Permission.QUERY),
	GENERAL_ADMIN("普通管理员",Permission.ADD,Permission.UPDATE,Permission.QUERY),
	MEMBER("会员",Permission.ADD,Permission.QUERY),
	VISITOR("游客",Permission.QUERY);
	
	
	private final String Name;
	private final List<Permission> PERMISSIONS;
	
	private Role(String name,Permission... permissions) {
		Name=name;
		PERMISSIONS=new ArrayList<Permission>();
		for(int i=0;i<permissions.length;i++){
			PERMISSIONS.add(permissions[i]);
		}
	}

	public String getName() {
		return Name;
	}
	
	
}
