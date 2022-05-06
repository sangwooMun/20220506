package co.project.user;

import lombok.Data;

@Data
public class User {
	private String USERID;
	private int USERLEVEL;
	private int MONETY;
	private int BURGERNUM;
	
	public String toString() {
		System.out.println("유저 아이디 : " + USERID);
		System.out.println(" 레벨 : " + USERLEVEL);
		System.out.println(" 보유한 금액 : " + MONETY);
		System.out.println(" 만든 버거 갯수 : " + BURGERNUM);
		return null;
		
	}

}
