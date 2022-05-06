package co.project.lobby;

import java.util.Scanner;

import co.project.user.User;
import co.project.user.UserService;
import co.project.userImpl.UserServiceImpl;

public class Lobby {
	private UserService dao = new UserServiceImpl();
	private Scanner scanner = new Scanner(System.in);
	
	int array[] = new int[3];
	int arr[] = new int[11];
	
	// 로그인
//	public void logins() {
//		User ur = new User();
//		String id = scanner.nextLine();
//		ur.setUSERID(id);
//		System.out.println("로그인에 성공");
//		ur = dao.userInfoList(ur);
//	}

	public void userInfo() {
		User ur = new User();
		String id = scanner.nextLine();
		ur.setUSERID(id);
		ur = dao.userInfoList(ur);
		System.out.println("====== User Info ======");
		ur.toString();
		System.out.println("====== User Info ======");
		System.out.println("메뉴로 돌아가려면 아무키나 눌러주세요");
		scanner.nextLine();
	}

	public void normalMode() {
		System.out.println("=== 게임을 시작합니다 ===");
		for(int i = 0; i<array.length; i++) {
			array[i] = (int)(Math.random() * 3) + 1;
		}
		
		
		
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
		System.out.println("");

	}

}
