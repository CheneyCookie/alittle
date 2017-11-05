package ooad.day03.exercise3;

public class UserServiceImpl implements IUserService{

	@Override
	public void showUsersInfo(User user) {
		if(user.getRole().getName().equals("管理员")){
			System.out.println("显示所有用户信息");
		}else{
			System.out.println("你没有权限查看");
		}
	}

}
