package mybatis.day03.homework.improve2;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private Integer id;
	private String name;
	private List<User> users=new ArrayList<User>();
	public Group() {
	}
	public Group(Integer id, String name, List<User> users) {
		this.id = id;
		this.name = name;
		this.users = users;
	}
	public Group(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
}
