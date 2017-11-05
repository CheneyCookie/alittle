package mybatis.day03.homework.improve2;

public interface UserMapper {
	void addUser(User user);
	User selectUser(int id);
}
