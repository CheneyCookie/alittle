package mybatis.day03.homework.work1;

public class Husband {
	private Integer id;
	private String name;
	private Integer age;
	public Husband() {
	}
	public Husband(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
	@Override
	public String toString() {
		return "Husband [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
