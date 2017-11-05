package mybatis.day03.homework.work1;

public interface OnetoOneMapper {
	void addWife(Wife wife);
	void addHusband(Husband husband);
	void deleteWifeAndHusband(int wId);
	void updateWife(Wife wife);
	void updateHusband(Husband husband);
	Wife selectWife(int id);
	Husband selectHusband(int id);
	void selectAll();
}
