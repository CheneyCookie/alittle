package mybatis.day03.homework.work2;

public interface OneToManyMapper {
	User selectUser(int id);
	
	Group selectGroup(int id);
	
	void addGroup(Group group);
	
	void addUser(User user);
}
