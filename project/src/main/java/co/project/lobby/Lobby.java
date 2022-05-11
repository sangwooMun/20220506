package co.project.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.project.Menu;
import co.project.Hamburger.Hamburger;
import co.project.user.User;
import co.project.user.UserService;
import co.project.userImpl.UserServiceImpl;

public class Lobby {
	private UserService dao = new UserServiceImpl();
	private Scanner scanner = new Scanner(System.in);
	User loginUser ;
	User ur = new User();
	UserService userservice = new UserServiceImpl();
	
	public void mainlogin() {
		System.out.println("로그인 할 아이디를 입력하세요");
		String userId = scanner.nextLine();
		ur.setUserId(userId);
		loginUser = userservice.userlogin(userId);
		if(loginUser == null) {
			System.out.println("로그인실패");
		}else {
			System.out.println("로그인 성공");
			Menu menu = new Menu();
			menu.mainList();
		}
	}

	public void mainjoins() {
		User ur = new User();
		System.out.println("회원가입할 아이디를 입력하세요");
		ur.setUserId(scanner.nextLine());
		System.out.println("가입하는 사람의 이름을 입력하세요");
		ur.setUserName(scanner.nextLine());

		int n = dao.userJoin(ur.getUserId(), ur.getUserName());
		if (n != 0) {
			System.out.println("정상적으로 회원가입 완료");
			Menu menu = new Menu();
			menu.mainhome();
		} else {
			System.out.println("정상적으로 회원가입 실패");
		}

	}

	public void userInfo() {
//		System.out.println("로그인 할 아이디를 입력하세요");
//		String userId = scanner.nextLine();
//		ur.setUserId(userId);
//		loginUser = userservice.userlogin(userId);
//		User abc = loginUser;
//		ur.userIdInfo("test");
		ur.setUserId("test");
//		userservice.userInfo(ur).equals(loginUser);
		userservice.userInfo(ur).toString();
//		userservice.userInfo(abc).toString();
//		int s = ur.getUserLever();
		System.out.println("====== User Info ======");
//		for (int i = 0; i < ur.getBurgerNum(); i++) {
//			if (ur.getBurgerNum() % 20 == 0) {
//				s++;
//			}
//			System.out.println(s);
//		}
	}

	public void allRank() {
		List<User> list = new ArrayList<User>();
		list = dao.userSelectList();
		for (User us : list) {
			us.toString();
		}
	}

	public void normalMode() {
		
		System.out.println("======================");
		System.out.println("빵 종류 : 0.참깨빵 : ▤ ▤ ▤ ▤	1.호밀빵 : ■ ■ ■ ■	2.보리빵 : □ □ □ □");
		System.out.println("토핑 종류 : 0.불고기 : ◎ ◎ ◎ ◎ ◎		1.새우 : § § § §  §	2.상추 : ♧ ♧ ♧ ♧ ♧	3.치즈 : ◇ ◇ ◇ ◇ ◇\n"
				+ "4.양파 : ＠ ＠ ＠ ＠ ＠	5.치킨 : ※ ※ ※ ※ ※		6.베이컨 : ＆ ＆ ＆ ＆ ＆		7.스테이크 : ＃ ＃ ＃ ＃ #\n"
				+ "8.계란 : ◐ ◐ ◐ ◐ ◐");
		System.out.println("======================");
		User us = new User();
		Hamburger hbg = new Hamburger();
		Hamburger ham = new Hamburger();
		
		int conut = 0;
				
		ham.getBreadNum();
		ham.getPattyNum();

		String[] x = hbg.getBread();
		String[] y = hbg.getPatty();
		int b1 = (int) (3 * (Math.random()));
		int p1 = (int) (4 * (Math.random()));

		for (int i = 0; i < 1; i++) {
			System.out.println(x[b1]);
			for (int j = 0; j < (1 * (Math.random())); j++) {
				System.out.println(y[p1]);
			}
			System.out.println(x[b1]);
		}

		for (int i = 0; i < hbg.getBreadNum().length; i++) {
			System.out.println("빵 선택");
			String num = ham.getbreads(scanner.nextInt());
			
			if (x[b1].equals(num)) {
				System.out.println(x[b1]);
				break;
			} else{
				System.out.println("ㄴㄴ");
			}
		}
		
		for (int i = 0; i < hbg.getBreadNum().length; i++) {
			System.out.println("속재료 선택");
			String num = ham.getpattys(scanner.nextInt());
			
			if (y[p1].equals(num)) {
				System.out.println(y[p1]);
				break;
			} else{
				System.out.println("ㄴㄴ");
			}
		}
		for (int i = 0; i < hbg.getBreadNum().length; i++) {
			System.out.println("빵 선택");
			String num = ham.getbreads(scanner.nextInt());
			
			if (x[b1].equals(num)) {
				System.out.println(x[b1]);
				break;
			} else{
				System.out.println("ㄴㄴ");
			}
		}
		
		int number = conut++;
		us.setBurgerNum(number);
		
		int u = dao.userInfoUpdate(us);
		if(u != 0) {
			System.out.println("햄버거 만든 갯수 : " + us.getBurgerNum());
		}else {
			System.out.println("실패");
		}
		
		
	}

	public void test() {
		Hamburger hbg = new Hamburger();
		Hamburger ham = new Hamburger();
		ham.getBreadNum();
		ham.getPattyNum();

//		for(int i=0; i< ham.getBreadNum().length; i++) {
//			ham.getBreadNum()[i] = (int) (Math.random() * 3) + 1;
//		}

//		for(int j=0; j< ham.getPattyNum().length; j++) {
//			ham.getPattyNum()[j] = (int) (Math.random() * 9) + 1;
//		}

		String[] x = hbg.getBread();
		String[] y = hbg.getPatty();
		int b1 = (int) (3 * (Math.random()));
		int p1 = (int) (4 * (Math.random()));

		for (int i = 0; i < 1; i++) {
			System.out.println(x[b1]);
			for (int j = 0; j < (1 * (Math.random())); j++) {
				System.out.println(y[p1]);
			}
			System.out.println(x[b1]);
		}

		for (int i = 0; i < hbg.getBreadNum().length; i++) {
			System.out.println("빵 선택");
			String num = ham.getbreads(scanner.nextInt());
			
			if (x[b1].equals(num)) {
				System.out.println(x[b1]);
				break;
			} else{
				System.out.println("ㄴㄴ");
			}
		}
		
		for (int i = 0; i < hbg.getBreadNum().length; i++) {
			System.out.println("속재료 선택");
			String num = ham.getpattys(scanner.nextInt());
			
			if (y[p1].equals(num)) {
				System.out.println(y[p1]);
				break;
			} else{
				System.out.println("ㄴㄴ");
			}
		}
		for (int i = 0; i < hbg.getBreadNum().length; i++) {
			System.out.println("빵 선택");
			String num = ham.getbreads(scanner.nextInt());
			
			if (x[b1].equals(num)) {
				System.out.println(x[b1]);
				break;
			} else{
				System.out.println("ㄴㄴ");
			}
		}
		

//		for (int i = 0; i < hbg.getBreadNum().length; i++) {
//			System.out.println("빵 선택");
//			String num = ham.getbreads(scanner.nextInt());
//			if (x[0] == num) {
//				if (x[0] == num) {
//					System.out.println(x[0]);
//					break;
//				} else if (b1 != 1) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (b1 == 2) {
//				if (b1 == num) {
//					System.out.println(x[1]);
//					break;
//				} else if (b1 != 2) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (b1 == 3) {
//				if (b1 == num) {
//					System.out.println(x[2]);
//					break;
//				} else if (b1 != 3) {
//					System.out.println("ㄴㄴ");
//				}
//			}
//			
//		}

//		for (int j = 0; j < 1; j++) {
//			System.out.println("속재료 선택");
//			int num = scanner.nextInt();
//			if (num == 1) {
//				if (hbg.getPattyNum()[0] == 1) {
//					System.out.println(y[0]);
//					break;
//				} else if (hbg.getPattyNum()[0] != 1) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (num == 2) {
//				if (hbg.getPattyNum()[1] == 2) {
//					System.out.println(y[1]);
//				} else if (hbg.getPattyNum()[1] == 2) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (num == 3) {
//				if (hbg.getPattyNum()[2] == 3) {
//					System.out.println(y[2]);
//				} else if (hbg.getPattyNum()[2] == 3) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (num == 4) {
//				if (hbg.getPattyNum()[3] == 4) {
//					System.out.println(y[3]);
//				} else if (hbg.getPattyNum()[3] == 4) {
//					System.out.println("ㄴㄴ");
//				}
//			}
//		}
//		
//		for (int i = 0; i < hbg.getBreadNum().length; i++) {
//			System.out.println("빵 선택");
//			int num = scanner.nextInt();
//			if (num == 1) {
//				if (hbg.getBreadNum()[0] == 1) {
//					System.out.println(x[0]);
//					break;
//				} else if (hbg.getBreadNum()[0] != 1) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (num == 2) {
//				if (hbg.getBreadNum()[1] == 2) {
//					System.out.println(x[1]);
//					break;
//				} else if (hbg.getBreadNum()[1] == 2) {
//					System.out.println("ㄴㄴ");
//				}
//			} else if (num == 3) {
//				if (hbg.getBreadNum()[2] == 3) {
//					System.out.println(x[2]);
//					break;
//				} else if (hbg.getBreadNum()[2] == 3) {
//					System.out.println("ㄴㄴ");
//				}
//			}
//			
//		}

//		for (int i = 0; i < ham.getBreadNum().length; i++) {
//			System.out.println("빵");
//			ham.getbreads(scanner.nextInt());
//			if (x[i] == ham.getBread()[i]) {
//				if (ham.getBreadNum()[i] == 1) {
//					System.out.println(ham.getbreads(1));
//					break;
//				}else {
//					System.out.println("잘못입력");
//				}
//			}
//		}

//			} else if (bb == 2) {
//				if (ham.getBreadNum()[i] == 2) {
//					System.out.println(ham.getbreads(2));
//					break;
//				} else if (ham.getBreadNum()[i] != 2) {
//					System.out.println("이거 아니야!");
//				}
//			} else if (num == 3) {
//				if (ham.getBreadNum()[i] == 3) {
//					System.out.println(ham.getbreads(3));
//					break;
//				} else if (ham.getBreadNum()[i] != 3) {
//					System.out.println("이거 아니야!");
//				}
//			} else {
//				System.out.println("잘못고름");
//			}
//		}

	}

	public void sysMode() {
//		Hamburger ham = new Hamburger();
//		ham.getBreadNum();
//		ham.getPattyNum();
//		if (ham.getBreadNum()[0] == 1) {
//			System.out.println(" ▤ ▤  ▤ ▤");
//		}
//		if (ham.getBreadNum()[1] == 2) {
//			System.out.println(" ■ ■  ■ ■");
//		}
//		if (ham.getBreadNum()[2] == 3) {
//			System.out.println(" □ □  □ □");
//		}
//
//		for(int i =0; i< ham.getBreadNum().length; i++) {
//			System.out.println("빵");
//			int num = scanner.nextInt();
//			if(num == 1) {
//				if(ham.getBreadNum()[i] == 1) {
//					System.out.println(ham.getbreads(1));
//					break;
//				}else if(ham.getBreadNum()[i] != 1) {
//					System.out.println("이거 아니야!");
//				}
//			}else if(num == 2) {
//				if(ham.getBreadNum()[i] == 2) {
//					System.out.println(ham.getbreads(2));
//					break;
//				}else if(ham.getBreadNum()[i] != 2) {
//					System.out.println("이거 아니야!");
//				}
//			}else if(num == 3) {
//				if(ham.getBreadNum()[i] == 3) {
//					System.out.println(ham.getbreads(3));
//					break;
//				}else if(ham.getBreadNum()[i] != 3) {
//					System.out.println("이거 아니야!");
//				}
//			}else {
//				System.out.println("잘못고름");
//			}
//		}
	}

	public void shopUp() {

	}

	public void gameEx() {
		System.out.println("--- 게임 설명 ---");
		System.out.println("햄버거 타이쿤");
		System.out.println("잘 만들어보쇼");
	}

}
