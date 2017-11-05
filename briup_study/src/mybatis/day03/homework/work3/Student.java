package mybatis.day03.homework.work3;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private Integer id;
	private String name;
	private List<Teacher> teachers=new ArrayList<Teacher>();
	public Student() {
	}
	public Student(String name, List<Teacher> teachers) {
		super();
		this.name = name;
		this.teachers = teachers;
	}
	public Student(Integer id, String name, List<Teacher> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.teachers = teachers;
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
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", teachers="
				+ teachers.size() + "]";
	}
}
