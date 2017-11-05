package mybatis.day01.homework.work1.mappers;

import java.util.List;

import mybatis.day01.homework.work1.pojo.Student;

public interface StudentMapper {
	void add(Student stu);
	void deleteById(int id);
	void update(Student stu);
	Student queryById(int id);
	List<Student> queryAll();
}
