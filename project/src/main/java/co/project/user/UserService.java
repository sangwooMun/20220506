package co.project.user;

import java.util.List;


public interface UserService {
	
	List<User> userSelectList();
	int userInfoList(User us);
	int userJoin(String userId, String userName);
	public User userlogin(String userId);
	int userInfoUpdate(User us);
	
}
