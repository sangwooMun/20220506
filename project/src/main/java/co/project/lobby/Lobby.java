package co.project.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.project.user.User;
import co.project.user.UserService;
import co.project.userImpl.UserServiceImpl;

public class Lobby {
	private UserService dao = new UserServiceImpl();
	private Scanner scanner = new Scanner(System.in);


	public void mainlogin() {
		User ur = new User();
		System.out.println("로그인 할 아이디를 입력하세요");
		String USERID = scanner.nextLine();
		ur.setUSERID(USERID);
		UserService userservice = new UserServiceImpl();
		userservice.userlogin(USERID);
	}

	public void mainjoins() {
		User ur = new User();
		System.out.println("회원가입할 아이디를 입력하세요");
		ur.setUSERID(scanner.nextLine());
		System.out.println("가입하는 사람의 이름을 입력하세요");
		ur.setUSERNAME(scanner.nextLine());
		
		int n = dao.userJoin(ur.getUSERID(), ur.getUSERNAME());
		if(n != 0) {
			System.out.println("정상적으로 회원가입 완료");
		}else {
			System.out.println("정상적으로 회원가입 실패");
		}
		
	}

	public void userInfo() {
		User us = new User();
		System.out.println("조회할 아이디를 입력하세요");
		String USERID = scanner.nextLine();
		us.setUSERID(USERID);
		us = dao.userInfoList(us);
		us.toString();
		System.out.println("====== User Info ======");
	}
	
	public void allRank() {
		List<User> list = new ArrayList<User>();
		list = dao.userSelectList();
		for(User us : list) {
			us.toString();
		}
	}

	public void normalMode() {
		System.out.println("=== 게임을 시작합니다 ===");

		System.out.println("====== 주문들어왔어요~ ======");

		System.out.println("=========================");
		System.out.println("빵 종류 : 1.참깨빵 : ▒ ▒ ▒ ▒	2.호밀빵 : ■ ■ ■ ■	3.보리빵 : □ □ □ □");
		System.out.println("토핑 종류 : 1.불고기 : ◎ ◎ ◎ ◎ ◎		2.새우 : § § § § §	3.상추 : ♧ ♧ ♧ ♧ ♧	4.치즈 : ◇ ◇ ◇ ◇ ◇\n"
				+ "5.양파 : ＠ ＠ ＠ ＠ ＠	6.치킨 : ※ ※ ※ ※ ※		7.베이컨 : ＆ ＆ ＆ ＆ ＆		8.스테이크 : ＃ ＃ ＃ ＃ #\n"
				+ "9.계란 : ◐ ◐ ◐ ◐ ◐	10.샐러드 : ♣ ♣ ♣ ♣ ♣");
	}

	public void sysMode() {

	}

	public void shopUp() {

	}

	public void gameEx() {
		System.out.println("--- 게임 설명 ---");
		System.out.println("햄버거 타이쿤");
		System.out.println("잘 만들어보쇼");

	}

}
