package mybatis.day03.homework.work3;

public interface ManyToManyMapper {
	void insertStudent(Student student);
	
	void insertTeacher(Teacher teacher);
	
	void insertBridge(Student student,Teacher teacher);
	
	Student selectStudent(int id);
	
	Teacher selectTeacher(int id);
	
	Student selectStudentWithTea(int id);
	
	Teacher selectTeacherWithStu(int id);
}
