package mybatis.day03.classcode;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ResultMapper {
	List<Student> findAllStudent();
	Set<Student> findStudent_Set();
	Map<String, Object> findStudentById_Map(int i);
	List<Map<String, Object>> findStudent_ListMap();
}
