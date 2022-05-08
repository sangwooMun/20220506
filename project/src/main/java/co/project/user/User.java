package co.project.user;

import lombok.Data;

@Data
public class User {
	private String USERID;
	private String USERNAME;
	private int USERLEVEL;
	private int MONEY;
	private int BURGERNUM;
	private int BURGER_MAX;
	
	public String toString() {
		System.out.println("====== User Info ======");
		System.out.println("유저 아이디 : " + USERID);
		System.out.println("유저 이름 : " + USERNAME);
		System.out.println(" 레벨 : " + USERLEVEL);
		System.out.println(" 보유한 금액 : " + MONEY);
		System.out.println(" 만든 버거 갯수 : " + BURGERNUM);
		System.out.println(" 만들 수 있는 버거 갯수 : " + BURGER_MAX);
		return null;
		
	}

}
