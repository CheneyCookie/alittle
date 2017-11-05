package mybatis.day03.homework.work2;

public class User {
	private Integer id;
	private String name;
	private Group group;
	public User() {
	}
	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public User(Integer id, String name, Group group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}
	public User(String name) {
		this.name = name;
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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", group=" + group.getId() + "]";
	}
	
}
