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
	User loginUser;
	User userLevel;
	User bgNum;
	User ur = new User();
	UserService userservice = new UserServiceImpl();

	public void mainlogin() {
		System.out.println("로그인 할 아이디를 입력하세요");
		String userId = scanner.nextLine();
//		ur.setUserId(userId);
		loginUser = userservice.userlogin(userId);
		if (loginUser == null) {
			System.out.println("로그인실패");
		} else {
			System.out.println("로그인 성공");
		}
	}

	public void mainjoins() {
		System.out.println("회원가입할 아이디를 입력하세요");
		ur.setUserId(scanner.nextLine());
		System.out.println("가입하는 사람의 이름을 입력하세요");
		ur.setUserName(scanner.nextLine());

		int n = dao.userJoin(ur.getUserId(), ur.getUserName());
		if (n != 0) {
			System.out.println("정상적으로 회원가입 완료");
		} else {
			System.out.println("정상적으로 회원가입 실패");
		}

	}

	public void userInfo() {
		loginUser.toString();

		int s = ur.getUserLever();
		System.out.println("====== User Info ======");
		if (ur.getBurgerNum() % 20 == 0) {
			s++;
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


	public void test() {
	}

	public void test1() {
		int a;
		boolean b = false;
		if (loginUser.getUserLever() == 1) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧      |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					
					
					////////////////////////////////////////////////////////////////////////////////////
					
					
					// Level 1 버거
					int b1 = (int) (3 * (Math.random()));
					int p1 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 1
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
						}
						System.out.println(x[b1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());

						if (y[p1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("	" + x[b1]);
					System.out.println("	" + y[p1]);
					System.out.println("	" + x[b1]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		}else if(loginUser.getUserLever() == 2) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧      |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 1 버거
					int b1 = (int) (3 * (Math.random()));
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 2
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
						}
						System.out.println(x[b1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());

						if (y[p1].equals(num) && y[p2].equals(num1)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                         " + x[b1]);
					System.out.println("                         " + y[p1]);
					System.out.println("                         " + y[p2]);
					System.out.println("                         " + x[b1]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		}else if(loginUser.getUserLever() == 3) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧     |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level  버거
					int b1 = (int) (3 * (Math.random()));
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));
					int p3 = (int) (7 * (Math.random()));
					

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 3
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
							System.out.println(y[p3]);
						}
						System.out.println(x[b1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						if (y[p1].equals(num) && y[p2].equals(num1) && y[p3].equals(num2)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                         " + x[b1]);
					System.out.println("                         " + y[p1]);
					System.out.println("                         " + y[p2]);
					System.out.println("                         " + y[p3]);
					System.out.println("                         " + x[b1]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		}else if(loginUser.getUserLever() == 4) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧     |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 4 버거
					int b1 = (int) (3 * (Math.random()));
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));
					int p3 = (int) (7 * (Math.random()));
					int p4 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 1
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
							System.out.println(y[p3]);
							System.out.println(y[p4]);
						}
						System.out.println(x[b1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						if (y[p1].equals(num) && y[p2].equals(num1) && y[p3].equals(num2) && y[p4].equals(num3)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < hbg.getBreadNum().length; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                         " + x[b1]);
					System.out.println("                         " + y[p1]);
					System.out.println("                         " + y[p2]);
					System.out.println("                         " + y[p3]);
					System.out.println("                         " + y[p4]);
					System.out.println("                         " + x[b1]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			////////////////////////////////////////////////////////////////////////////////////
		}else if(loginUser.getUserLever() == 5) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧     |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 5 버거
					int b1 = (int) (3 * (Math.random()));
					int b2 = (int) (3 * (Math.random()));
					
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));
					int p3 = (int) (7 * (Math.random()));
					int p4 = (int) (7 * (Math.random()));
					int p5 = (int) (7 * (Math.random()));
					int p6 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 5
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
							System.out.println(y[p3]);
						}
						System.out.println(x[b1]);
					}
					System.out.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b2]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p4]);
							System.out.println(y[p5]);
							System.out.println(y[p6]);
						}
						System.out.println(x[b2]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						if (y[p1].equals(num) && y[p2].equals(num1) && y[p3].equals(num2)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					///////////////////////////////////////////////////////////////////
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						if (y[p4].equals(num) && y[p5].equals(num1) && y[p6].equals(num2)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					
					
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("                 " + y[p1] + " | " + y[p4]);
					System.out.println("                 " + y[p2] + " | " + y[p5]);
					System.out.println("                 " + y[p3] + " | " + y[p6]);
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		}else if(loginUser.getUserLever() == 6) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧     |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 6 버거
					int b1 = (int) (3 * (Math.random()));
					int b2 = (int) (3 * (Math.random()));
					
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));
					int p3 = (int) (7 * (Math.random()));
					int p4 = (int) (7 * (Math.random()));
					
					int p5 = (int) (7 * (Math.random()));
					int p6 = (int) (7 * (Math.random()));
					int p7 = (int) (7 * (Math.random()));
					int p8 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
							System.out.println(y[p3]);
							System.out.println(y[p4]);
						}
						System.out.println(x[b1]);
					}
					System.out.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b2]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p5]);
							System.out.println(y[p6]);
							System.out.println(y[p7]);
							System.out.println(y[p8]);
						}
						System.out.println(x[b2]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						if (y[p1].equals(num) && y[p2].equals(num1) && y[p3].equals(num2) && y[p4].equals(num3)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					///////////////////////////////////////////////////////////////////////////////////
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						if (y[p5].equals(num) && y[p6].equals(num1) && y[p7].equals(num2) && y[p8].equals(num3)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("                 " + y[p1] + " | " + y[p5]);
					System.out.println("                 " + y[p2] + " | " + y[p6]);
					System.out.println("                 " + y[p3] + " | " + y[p7]);
					System.out.println("                 " + y[p4] + " | " + y[p8]);
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
		}else if(loginUser.getUserLever() == 7) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧     |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 6 버거
					int b1 = (int) (3 * (Math.random()));
					int b2 = (int) (3 * (Math.random()));
					
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));
					int p3 = (int) (7 * (Math.random()));
					int p4 = (int) (7 * (Math.random()));
					int p5 = (int) (7 * (Math.random()));
					
					int p6 = (int) (7 * (Math.random()));
					int p7 = (int) (7 * (Math.random()));
					int p8 = (int) (7 * (Math.random()));
					int p9 = (int) (7 * (Math.random()));
					int p10 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
							System.out.println(y[p3]);
							System.out.println(y[p4]);
							System.out.println(y[p5]);
						}
						System.out.println(x[b1]);
					}
					System.out.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b2]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p6]);
							System.out.println(y[p7]);
							System.out.println(y[p8]);
							System.out.println(y[p9]);
							System.out.println(y[p10]);
						}
						System.out.println(x[b2]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						String num4 = ham.getpattys(scanner.nextInt());
						if (y[p1].equals(num) && y[p2].equals(num1) && y[p3].equals(num2) && y[p4].equals(num3) && y[p5].equals(num4)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					///////////////////////////////////////////////////////////////////////////////////
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						String num4 = ham.getpattys(scanner.nextInt());
						if (y[p6].equals(num) && y[p7].equals(num1) && y[p8].equals(num2) && y[p9].equals(num3) && y[p10].equals(num4)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("                 " + y[p1] + " | " + y[p6]);
					System.out.println("                 " + y[p2] + " | " + y[p7]);
					System.out.println("                 " + y[p3] + " | " + y[p8]);
					System.out.println("                 " + y[p4] + " | " + y[p9]);
					System.out.println("                 " + y[p5] + " | " + y[p10]);
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
			
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		}else if(loginUser.getUserLever() == 8) {
			do {
				System.out.println("| 게임시작 : 1 | 종료 : 2 |");
				a = scanner.nextInt();
				switch (a) {
				case 1:
					System.out.println(
							"   ====================================     재료 리스트     ====================================\n"
									+ "                                             ( 빵종류 )");
					System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
					System.out.println("");
					System.out.println("                                         ( 토핑 종류 )\n"
							+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧     |\n"
							+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
							+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
					System.out.println(
							"   ====================================     재료 리스트     ====================================");
					User us = new User();
					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 6 버거
					int b1 = (int) (3 * (Math.random()));
					int b2 = (int) (3 * (Math.random()));
					
					int p1 = (int) (7 * (Math.random()));
					int p2 = (int) (7 * (Math.random()));
					int p3 = (int) (7 * (Math.random()));
					int p4 = (int) (7 * (Math.random()));
					int p5 = (int) (7 * (Math.random()));
					int p6 = (int) (7 * (Math.random()));
					
					int p7 = (int) (7 * (Math.random()));
					int p8 = (int) (7 * (Math.random()));
					int p9 = (int) (7 * (Math.random()));
					int p10 = (int) (7 * (Math.random()));
					int p11 = (int) (7 * (Math.random()));
					int p12 = (int) (7 * (Math.random()));

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p1]);
							System.out.println(y[p2]);
							System.out.println(y[p3]);
							System.out.println(y[p4]);
							System.out.println(y[p5]);
							System.out.println(y[p6]);
						}
						System.out.println(x[b1]);
					}
					System.out.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println(x[b2]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println(y[p7]);
							System.out.println(y[p8]);
							System.out.println(y[p9]);
							System.out.println(y[p10]);
							System.out.println(y[p11]);
							System.out.println(y[p12]);
						}
						System.out.println(x[b2]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						String num4 = ham.getpattys(scanner.nextInt());
						String num5 = ham.getpattys(scanner.nextInt());
						if (y[p1].equals(num) && y[p2].equals(num1) && y[p3].equals(num2) && y[p4].equals(num3) && y[p5].equals(num4) && y[p6].equals(num5)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b1].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					///////////////////////////////////////////////////////////////////////////////////
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getpattys(scanner.nextInt());
						String num1 = ham.getpattys(scanner.nextInt());
						String num2 = ham.getpattys(scanner.nextInt());
						String num3 = ham.getpattys(scanner.nextInt());
						String num4 = ham.getpattys(scanner.nextInt());
						String num5 = ham.getpattys(scanner.nextInt());
						if (y[p7].equals(num) && y[p8].equals(num1) && y[p9].equals(num2) && y[p10].equals(num3) && y[p11].equals(num4) && y[p12].equals(num5)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					for (int i = 0; i < 3; i++) {
						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
						String num = ham.getbreads(scanner.nextInt());

						if (x[b2].equals(num)) {
							break;
						} else {
							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
						}
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("                 " + y[p1] + " | " + y[p7]);
					System.out.println("                 " + y[p2] + " | " + y[p8]);
					System.out.println("                 " + y[p3] + " | " + y[p9]);
					System.out.println("                 " + y[p4] + " | " + y[p10]);
					System.out.println("                 " + y[p5] + " | " + y[p11]);
					System.out.println("                 " + y[p6] + " | " + y[p12]);
					System.out.println("                 " + x[b1] + " | " + x[b2]);
					System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 30 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
					
				case 2:
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
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
