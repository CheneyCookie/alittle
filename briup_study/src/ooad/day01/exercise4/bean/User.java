package ooad.day01.exercise4.bean;


public class User {
	private Integer id;
	private String name;
	private String password;
	private Role role;
	
	public User(Integer id,String name,String password) {
		this.id=id;
		this.name=name;
		this.password=password;
		role=Role.MEMBER;
	}

	public User(Integer id, String name,String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password=password;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}
