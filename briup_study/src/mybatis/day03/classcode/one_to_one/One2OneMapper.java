package mybatis.day03.classcode.one_to_one;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface One2OneMapper {
	Student findStudentById_1(int i);
	
	void insertAddress(int i);
}
