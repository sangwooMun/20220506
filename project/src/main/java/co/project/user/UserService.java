package co.project.user;

import java.util.List;


public interface UserService {
	
	List<User> userSelectList();
	public User userInfo(User ur);
	int userJoin(String userId, String userName);
	public User userlogin(String userId);
	int userInfoUpdate(User ur);
	
}
