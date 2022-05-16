package co.project.user;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;
	private int userLever;
	private int money;
	private int BurgerNum;
	
	public String toString() {
		System.out.println("                               ┌==========  User Info  =========┐");
		System.out.println("                                       유저 아이디 : " + userId);
		System.out.println("                                       유저 이름 : " + userName);
		System.out.println("                                       레벨 : " + userLever);
		System.out.println("                                       보유한 금액 : " + money);
		System.out.println("                                       만든 버거 갯수 : " + BurgerNum);
		System.out.println("                               └============= ๑'ٮ'๑ =============┘");
		return null;
		
	}
	
}
