package co.project.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.project.Hamburger.Hamburger;
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
		if (n != 0) {
			System.out.println("정상적으로 회원가입 완료");
		} else {
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
		int s = us.getUSERLEVEL();
		System.out.println("====== User Info ======");
		for (int i = 0; i < us.getBURGERNUM(); i++) {
			if (us.getBURGERNUM() % 20 == 0) {
				s++;
			}
			System.out.println(s);
		}
	}

	public void allRank() {
		List<User> list = new ArrayList<User>();
		list = dao.userSelectList();
		for (User us : list) {
			us.toString();
		}
	}

	public void normalMode() {
		Hamburger hbg = new Hamburger();
		String[] x = hbg.getBread();
		String[] y = hbg.getPatty();

//		System.out.println(x[(int) (3 * (Math.random()))]);
//		for (int i = 0; i < (10 * (Math.random())); i++) {
//			System.out.println(y[(int) (9 * (Math.random()))]);
//		}
//		System.out.println(x[(int) (3 * (Math.random()))]);

//		System.out.println("번호 입력");
		for (int i = 0; i < 1; i++) {
			System.out.println(x[(int) (3 * (Math.random()))]);
			for (int j = 0; j < (3 * (Math.random())); j++) {
				System.out.println(y[(int) (4 * (Math.random()))]);
			}
			System.out.println(x[(int) (3 * (Math.random()))]);
		
		}
//		System.out.println("======================");
//		System.out.println("빵 종류 : 1.참깨빵 : ▤ ▤ ▤ ▤	2.호밀빵 : ■ ■ ■ ■	3.보리빵 : □ □ □ □");
//		System.out.println("토핑 종류 : 1.불고기 : ◎ ◎ ◎ ◎ ◎		2.새우 : § § § §  §	3.상추 : ♧ ♧ ♧ ♧ ♧	4.치즈 : ◇ ◇ ◇ ◇ ◇\n"
//				+ "5.양파 : ＠ ＠ ＠ ＠ ＠	6.치킨 : ※ ※ ※ ※ ※		7.베이컨 : ＆ ＆ ＆ ＆ ＆		8.스테이크 : ＃ ＃ ＃ ＃ #\n"
//				+ "9.계란 : ◐ ◐ ◐ ◐ ◐");

	}

	public void test() {
		Lobby lobby = new Lobby();
		Hamburger ham = new Hamburger();
		Hamburger hbg = new Hamburger();
		lobby.normalMode();
		String[] x = hbg.getBread();
		String[] y = hbg.getPatty();
		
		if(lobby.equals(x)) {
			System.out.println("");
		}
		
		System.out.println(ham.getbreads(scanner.nextInt()));
		System.out.println(ham.getpattys(scanner.nextInt()));
		if (ham.getbreads(1).equals(x[0])) {
			System.out.println(ham.getbreads(1));
		}else {
			System.out.println("아님");
		}
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
