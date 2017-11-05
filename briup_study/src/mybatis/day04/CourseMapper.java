package mybatis.day04;

import java.util.Map;

public interface CourseMapper {
	Course selectCourseIf(Map<String, Object> map);
	Course selectCourseChoose(Map<String, Object> map);
	Course selectCourseWhere(Map<String, Object> map);
}
