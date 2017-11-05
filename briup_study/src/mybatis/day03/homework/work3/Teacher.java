package mybatis.day03.homework.work3;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private Integer id;
	private String name;
	private List<Student> students = new ArrayList<Student>();

	public Teacher() {
	}

	public Teacher(Integer id, String name, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public Teacher(String name, List<Student> students) {
		this.name = name;
		this.students = students;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", students="
				+ students.size() + "]";
	}


}
