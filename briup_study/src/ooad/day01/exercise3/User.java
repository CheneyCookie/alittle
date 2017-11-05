package ooad.day01.exercise3;

public class User {
	private Integer id;
	private String name;
	private Role role;
	
	public User(Integer id,String name) {
		this.id=id;
		this.name=name;
		role=Role.VISITOR;
	}

	public User(Integer id, String name, Role role) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
}
