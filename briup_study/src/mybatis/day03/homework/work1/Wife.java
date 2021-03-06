package mybatis.day03.homework.work1;

public class Wife {
	private Integer id;
	private String name;
	private Integer age;
	private Husband husband;

	public Wife() {
	}

	public Wife(Integer id, String name, Integer age, Husband husband) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.husband = husband;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return "Wife [id=" + id + ", name=" + name + ", age=" + age
				+ ", husband=" + husband + "]";
	}

}
