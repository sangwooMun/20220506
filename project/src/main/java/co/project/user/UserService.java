package co.project.user;

import java.util.List;

public interface UserService {
	
	List<User> userSelectList();
	User userInfoList(User us);
	int userModedate(User us);
	int userSysModedate(User us);
	int usershopUpdate(User us);
	int userJoin(String USERID, String USERNAME);
	public User userlogin(String USERID);
	
	
}
