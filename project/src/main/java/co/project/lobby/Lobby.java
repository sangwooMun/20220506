package co.project.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import co.project.Menu;
import co.project.Hamburger.Hamburger;
import co.project.user.User;
import co.project.user.UserService;
import co.project.userImpl.UserServiceImpl;
import lombok.Data;

@Data
public class Lobby extends Thread {
	private UserService dao = new UserServiceImpl();
	private Scanner scanner = new Scanner(System.in);
	User loginUser;
	User userLevel;
	User bgNum;
	User ur = new User();
	Thread1 t1 = new Thread1();
	UserService userservice = new UserServiceImpl();

//	public void run() {
//		
//		Timer timer = new Timer();
//		TimerTask timerTask = new TimerTask() {
//		
//			int times = 3;
//			@Override
//			public void run() {
//				if(times >= 0) {
//					System.out.print(times+"초 ");
//					times--;
//				}else {
//					timer.cancel();
//					System.out.println("게임 종료");
//				}
//			}
//		};
//		timer.schedule(timerTask, 1000, 1000);
//
//	}

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

	boolean choice = false;

	public void time() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			int times = 3;

			@Override
			public void run() {
				if (times >= 0) {
					System.out.print(times + "초 ");
					times--;
				} else {
					timer.cancel();
					System.out.println("게임 종료");

					Menu menu = new Menu();
					menu.mainhome();

					choice = true;
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
		if (choice) {
			test1();
		}

	}

	public void test1() {

		System.out.println(Thread.currentThread().getName());
		boolean b = false;
		int a;
		System.out.println("| 게임시작 : 1 | 종료 : 2 |");
		a = scanner.nextInt();

		if (loginUser.getUserLever() == 1) {

			switch (a) {

			case 1:
				time();
				do {
					setumei();

					Hamburger hbg = new Hamburger();

					int count = 0;
					int countLevel = 0;

					hbg.getBreadNum();
					hbg.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();

					////////////////////////////////////////////////////////////////////////////////////

					// Level 1 버거
					int b1 = (int) ((Math.random() * 3) + 1);

					int p1 = (int) ((Math.random() * 9) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 1
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");

					try {
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = hbg.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
							String num = hbg.getpattys(scanner.nextInt());

							if (y[p1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = hbg.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println("                                       " + y[p1 - 1]);
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 20 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);

					break;
				} while (!b);
			case 2:
				b = true;
				System.out.println("게임 종료");
				break;
			}

			////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 2) {
			do {
				switch (a) {
				case 1:
					setumei();

					Hamburger hbg = new Hamburger();

					int count = 0;
					int countLevel = 0;

					hbg.getBreadNum();
					hbg.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 2 버거
					int b1 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 2
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = hbg.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
							String num = hbg.getpattys(scanner.nextInt());
							String num1 = hbg.getpattys(scanner.nextInt());

							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = hbg.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println("                                       " + y[p1 - 1]);
					System.out.println("                                       " + y[p2 - 1]);
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 20 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;
				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			/////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 3) {
			do {
				switch (a) {
				case 1:
					setumei();

					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 버거
					int b1 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 3
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println("                                       " + y[p1 - 1]);
					System.out.println("                                       " + y[p2 - 1]);
					System.out.println("                                       " + y[p3 - 1]);
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 20 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 4) {
			do {
				switch (a) {
				case 1:
					setumei();

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
					int b1 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);
					int p4 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 1
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
							System.out.println("                                       " + y[p4 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)
									&& y[p4 - 1].equals(num3)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < hbg.getBreadNum().length; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println("                                       " + y[p1 - 1]);
					System.out.println("                                       " + y[p2 - 1]);
					System.out.println("                                       " + y[p3 - 1]);
					System.out.println("                                       " + y[p4 - 1]);
					System.out.println("                                       " + x[b1 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 1);
					if (loginUser.getBurgerNum() % 20 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 5) {
			do {
				switch (a) {
				case 1:
					setumei();

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
					int b1 = (int) (3 * (Math.random()) + 1);
					int b2 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);
					int p4 = (int) (9 * (Math.random()) + 1);
					int p5 = (int) (9 * (Math.random()) + 1);
					int p6 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 5
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b2 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p4 - 1]);
							System.out.println("                                       " + y[p5 - 1]);
							System.out.println("                                       " + y[p6 - 1]);
						}
						System.out.println("                                       " + x[b2 - 1]);
					}

					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						System.out.println("");
						System.out.println("(◕‿◕✿) 하나 완료~");
						System.out.println("");
						///////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
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
							if (y[p4 - 1].equals(num) && y[p5 - 1].equals(num1) && y[p6 - 1].equals(num2)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println("                            " + y[p1 - 1] + "      " + y[p4 - 1]);
					System.out.println("                            " + y[p2 - 1] + "      " + y[p5 - 1]);
					System.out.println("                            " + y[p3 - 1] + "      " + y[p6 - 1]);
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 40 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 6) {
			do {
				switch (a) {
				case 1:
					setumei();

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
					int b1 = (int) (3 * (Math.random()) + 1);
					int b2 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);
					int p4 = (int) (9 * (Math.random()) + 1);

					int p5 = (int) (9 * (Math.random()) + 1);
					int p6 = (int) (9 * (Math.random()) + 1);
					int p7 = (int) (9 * (Math.random()) + 1);
					int p8 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
							System.out.println("                                       " + y[p4 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b2 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p5 - 1]);
							System.out.println("                                       " + y[p6 - 1]);
							System.out.println("                                       " + y[p7 - 1]);
							System.out.println("                                       " + y[p8 - 1]);
						}
						System.out.println("                                       " + x[b2 - 1]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)
									&& y[p4 - 1].equals(num3)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						System.out.println("");
						System.out.println("(◕‿◕✿) 하나 완료~");
						System.out.println("");
						///////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
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
							if (y[p5 - 1].equals(num) && y[p6 - 1].equals(num1) && y[p7 - 1].equals(num2)
									&& y[p8 - 1].equals(num3)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println("                            " + y[p1 - 1] + "      " + y[p5 - 1]);
					System.out.println("                            " + y[p2 - 1] + "      " + y[p6 - 1]);
					System.out.println("                            " + y[p3 - 1] + "      " + y[p7 - 1]);
					System.out.println("                            " + y[p4 - 1] + "      " + y[p8 - 1]);
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 40 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 7) {
			do {
				switch (a) {
				case 1:
					setumei();

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
					int b1 = (int) (3 * (Math.random()) + 1);
					int b2 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);
					int p4 = (int) (9 * (Math.random()) + 1);
					int p5 = (int) (9 * (Math.random()) + 1);

					int p6 = (int) (9 * (Math.random()) + 1);
					int p7 = (int) (9 * (Math.random()) + 1);
					int p8 = (int) (9 * (Math.random()) + 1);
					int p9 = (int) (9 * (Math.random()) + 1);
					int p10 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 7
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
							System.out.println("                                       " + y[p4 - 1]);
							System.out.println("                                       " + y[p5 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b2 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p6 - 1]);
							System.out.println("                                       " + y[p7 - 1]);
							System.out.println("                                       " + y[p8 - 1]);
							System.out.println("                                       " + y[p9 - 1]);
							System.out.println("                                       " + y[p10 - 1]);
						}
						System.out.println("                                       " + x[b2 - 1]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)
									&& y[p4 - 1].equals(num3) && y[p5 - 1].equals(num4)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						System.out.println("");
						System.out.println("(◕‿◕✿) 하나 완료~");
						System.out.println("");
						///////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
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
							if (y[p6 - 1].equals(num) && y[p7 - 1].equals(num1) && y[p8 - 1].equals(num2)
									&& y[p9 - 1].equals(num3) && y[p10 - 1].equals(num4)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println("                            " + y[p1 - 1] + "      " + y[p6 - 1]);
					System.out.println("                            " + y[p2 - 1] + "      " + y[p7 - 1]);
					System.out.println("                            " + y[p3 - 1] + "      " + y[p8 - 1]);
					System.out.println("                            " + y[p4 - 1] + "      " + y[p9 - 1]);
					System.out.println("                            " + y[p5 - 1] + "      " + y[p10 - 1]);
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 40 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			///////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 8) {
			do {
				switch (a) {
				case 1:
					setumei();

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
					int b1 = (int) (3 * (Math.random()) + 1);
					int b2 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);
					int p4 = (int) (9 * (Math.random()) + 1);
					int p5 = (int) (9 * (Math.random()) + 1);
					int p6 = (int) (9 * (Math.random()) + 1);

					int p7 = (int) (9 * (Math.random()) + 1);
					int p8 = (int) (9 * (Math.random()) + 1);
					int p9 = (int) (9 * (Math.random()) + 1);
					int p10 = (int) (9 * (Math.random()) + 1);
					int p11 = (int) (9 * (Math.random()) + 1);
					int p12 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
							System.out.println("                                       " + y[p4 - 1]);
							System.out.println("                                       " + y[p5 - 1]);
							System.out.println("                                       " + y[p6 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b2 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p7 - 1]);
							System.out.println("                                       " + y[p8 - 1]);
							System.out.println("                                       " + y[p9 - 1]);
							System.out.println("                                       " + y[p10 - 1]);
							System.out.println("                                       " + y[p11 - 1]);
							System.out.println("                                       " + y[p12 - 1]);
						}
						System.out.println("                                       " + x[b2 - 1]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)
									&& y[p4 - 1].equals(num3) && y[p5 - 1].equals(num4) && y[p6 - 1].equals(num5)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						System.out.println("");
						System.out.println("(◕‿◕✿) 하나 완료~");
						System.out.println("");
						///////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
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
							if (y[p7 - 1].equals(num) && y[p8 - 1].equals(num1) && y[p9 - 1].equals(num2)
									&& y[p10 - 1].equals(num3) && y[p11 - 1].equals(num4) && y[p12 - 1].equals(num5)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println("                            " + y[p1 - 1] + "      " + y[p7 - 1]);
					System.out.println("                            " + y[p2 - 1] + "      " + y[p8 - 1]);
					System.out.println("                            " + y[p3 - 1] + "      " + y[p9 - 1]);
					System.out.println("                            " + y[p4 - 1] + "      " + y[p10 - 1]);
					System.out.println("                            " + y[p5 - 1] + "      " + y[p11 - 1]);
					System.out.println("                            " + y[p6 - 1] + "      " + y[p12 - 1]);
					System.out.println("                            " + x[b1 - 1] + "        " + x[b2 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 2);
					if (loginUser.getBurgerNum() % 40 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			//////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 9) {
			do {
				switch (a) {
				case 1:
					setumei();

					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 10 버거
					int b1 = (int) (3 * (Math.random()) + 1);
					int b2 = (int) (3 * (Math.random()) + 1);
					int b3 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (9 * (Math.random()) + 1);
					int p2 = (int) (9 * (Math.random()) + 1);
					int p3 = (int) (9 * (Math.random()) + 1);
					int p4 = (int) (9 * (Math.random()) + 1);
					int p5 = (int) (9 * (Math.random()) + 1);

					int p6 = (int) (9 * (Math.random()) + 1);
					int p7 = (int) (9 * (Math.random()) + 1);
					int p8 = (int) (9 * (Math.random()) + 1);
					int p9 = (int) (9 * (Math.random()) + 1);
					int p10 = (int) (9 * (Math.random()) + 1);

					int p11 = (int) (9 * (Math.random()) + 1);
					int p12 = (int) (9 * (Math.random()) + 1);
					int p13 = (int) (9 * (Math.random()) + 1);
					int p14 = (int) (9 * (Math.random()) + 1);
					int p15 = (int) (9 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
							System.out.println("                                       " + y[p4 - 1]);
							System.out.println("                                       " + y[p5 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b2 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p6 - 1]);
							System.out.println("                                       " + y[p7 - 1]);
							System.out.println("                                       " + y[p8 - 1]);
							System.out.println("                                       " + y[p9 - 1]);
							System.out.println("                                       " + y[p10 - 1]);
						}
						System.out.println("                                       " + x[b2 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b3 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p11 - 1]);
							System.out.println("                                       " + y[p12 - 1]);
							System.out.println("                                       " + y[p13 - 1]);
							System.out.println("                                       " + y[p14 - 1]);
							System.out.println("                                       " + y[p15 - 1]);
						}
						System.out.println("                                       " + x[b3 - 1]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)
									&& y[p4 - 1].equals(num3) && y[p5 - 1].equals(num4)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						System.out.println("");
						System.out.println("(◕‿◕✿) 하나 완료~");
						System.out.println("");
						///////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
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
							if (y[p6 - 1].equals(num) && y[p7 - 1].equals(num1) && y[p8 - 1].equals(num2)
									&& y[p9 - 1].equals(num3) && y[p10 - 1].equals(num4)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						System.out.println("");
						System.out.println("(◕‿◕✿) 둘 완료~");
						System.out.println("");
						/////////////////////////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b3 - 1].equals(num)) {
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
							if (y[p11 - 1].equals(num) && y[p12 - 1].equals(num1) && y[p13 - 1].equals(num2)
									&& y[p14 - 1].equals(num3) && y[p15 - 1].equals(num4)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b3 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println(
							"                     " + x[b1 - 1] + "         " + x[b2 - 1] + "        " + x[b3 - 1]);
					System.out.println(
							"                     " + y[p1 - 1] + "      " + y[p6 - 1] + "       " + y[p11 - 1]);
					System.out.println(
							"                     " + y[p2 - 1] + "      " + y[p7 - 1] + "       " + y[p12 - 1]);
					System.out.println(
							"                     " + y[p3 - 1] + "      " + y[p8 - 1] + "       " + y[p13 - 1]);
					System.out.println(
							"                     " + y[p4 - 1] + "      " + y[p9 - 1] + "       " + y[p14 - 1]);
					System.out.println(
							"                     " + y[p5 - 1] + "      " + y[p10 - 1] + "       " + y[p15 - 1]);
					System.out.println(
							"                     " + x[b1 - 1] + "         " + x[b2 - 1] + "        " + x[b3 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 3);
					if (loginUser.getBurgerNum() % 300 == 0) {
						loginUser.setUserLever(countLevel += 1);
					}
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);
					loginUser.toString();
					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);

			////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (loginUser.getUserLever() == 10) {
			do {
				switch (a) {
				case 1:
					setumei();

					Hamburger hbg = new Hamburger();
					Hamburger ham = new Hamburger();

					int count = 0;
					int countLevel = 0;

					ham.getBreadNum();
					ham.getPattyNum();

					String[] x = hbg.getBread();
					String[] y = hbg.getPatty();
					////////////////////////////////////////////////////////////////////////////////////
					// Level 10 버거
					int b1 = (int) (3 * (Math.random()) + 1);
					int b2 = (int) (3 * (Math.random()) + 1);
					int b3 = (int) (3 * (Math.random()) + 1);

					int p1 = (int) (7 * (Math.random()) + 1);
					int p2 = (int) (7 * (Math.random()) + 1);
					int p3 = (int) (7 * (Math.random()) + 1);
					int p4 = (int) (7 * (Math.random()) + 1);
					int p5 = (int) (7 * (Math.random()) + 1);
					int p6 = (int) (7 * (Math.random()) + 1);
					int p7 = (int) (7 * (Math.random()) + 1);

					int p8 = (int) (7 * (Math.random()) + 1);
					int p9 = (int) (7 * (Math.random()) + 1);
					int p10 = (int) (7 * (Math.random()) + 1);
					int p11 = (int) (7 * (Math.random()) + 1);
					int p12 = (int) (7 * (Math.random()) + 1);
					int p13 = (int) (7 * (Math.random()) + 1);
					int p14 = (int) (7 * (Math.random()) + 1);

					int p15 = (int) (7 * (Math.random()) + 1);
					int p16 = (int) (7 * (Math.random()) + 1);
					int p17 = (int) (7 * (Math.random()) + 1);
					int p18 = (int) (7 * (Math.random()) + 1);
					int p19 = (int) (7 * (Math.random()) + 1);
					int p20 = (int) (7 * (Math.random()) + 1);
					int p21 = (int) (7 * (Math.random()) + 1);

					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
					// Level 6
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b1 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p1 - 1]);
							System.out.println("                                       " + y[p2 - 1]);
							System.out.println("                                       " + y[p3 - 1]);
							System.out.println("                                       " + y[p4 - 1]);
							System.out.println("                                       " + y[p5 - 1]);
							System.out.println("                                       " + y[p6 - 1]);
							System.out.println("                                       " + y[p7 - 1]);
						}
						System.out.println("                                       " + x[b1 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b2 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p8 - 1]);
							System.out.println("                                       " + y[p9 - 1]);
							System.out.println("                                       " + y[p10 - 1]);
							System.out.println("                                       " + y[p11 - 1]);
							System.out.println("                                       " + y[p12 - 1]);
							System.out.println("                                       " + y[p13 - 1]);
							System.out.println("                                       " + y[p14 - 1]);
						}
						System.out.println("                                       " + x[b2 - 1]);
					}
					System.out
							.println("                ==============================================================");
					for (int i = 0; i < 1; i++) {
						System.out.println("                                       " + x[b3 - 1]);
						for (int j = 0; j < (1 * (Math.random())); j++) {
							System.out.println("                                       " + y[p15 - 1]);
							System.out.println("                                       " + y[p16 - 1]);
							System.out.println("                                       " + y[p17 - 1]);
							System.out.println("                                       " + y[p18 - 1]);
							System.out.println("                                       " + y[p19 - 1]);
							System.out.println("                                       " + y[p20 - 1]);
							System.out.println("                                       " + y[p21 - 1]);
						}
						System.out.println("                                       " + x[b3 - 1]);
					}
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
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
							String num6 = ham.getpattys(scanner.nextInt());
							if (y[p1 - 1].equals(num) && y[p2 - 1].equals(num1) && y[p3 - 1].equals(num2)
									&& y[p4 - 1].equals(num3) && y[p5 - 1].equals(num4) && y[p6 - 1].equals(num5)
									&& y[p7 - 1].equals(num6)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b1 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						///////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
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
							String num6 = ham.getpattys(scanner.nextInt());
							if (y[p8 - 1].equals(num) && y[p9 - 1].equals(num1) && y[p10 - 1].equals(num2)
									&& y[p11 - 1].equals(num3) && y[p12 - 1].equals(num4) && y[p13 - 1].equals(num5)
									&& y[p14 - 1].equals(num6)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b2 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						/////////////////////////////////////////////////////////////////////////////////////////////////////
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b3 - 1].equals(num)) {
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
							String num6 = ham.getpattys(scanner.nextInt());
							if (y[p15 - 1].equals(num) && y[p16 - 1].equals(num1) && y[p17 - 1].equals(num2)
									&& y[p18 - 1].equals(num3) && y[p19 - 1].equals(num4) && y[p20 - 1].equals(num5)
									&& y[p21 - 1].equals(num6)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
						for (int i = 0; i < 3; i++) {
							System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
							String num = ham.getbreads(scanner.nextInt());

							if (x[b3 - 1].equals(num)) {
								break;
							} else {
								System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("빵은 1 ~ 3, 속재료는 1 ~ 9 범위 내에서 입력해주세요.");
					}
					count = loginUser.getBurgerNum();
					countLevel = loginUser.getUserLever();
					System.out.println(
							"                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
					System.out.println(
							"                       " + x[b1 - 1] + "        " + x[b2 - 1] + "        " + x[b3 - 1]);
					System.out.println(
							"                       " + y[p1 - 1] + "       " + y[p8 - 1] + "       " + y[p15 - 1]);
					System.out.println(
							"                       " + y[p2 - 1] + "       " + y[p9 - 1] + "       " + y[p16 - 1]);
					System.out.println(
							"                       " + y[p3 - 1] + "       " + y[p10 - 1] + "       " + y[p17 - 1]);
					System.out.println(
							"                       " + y[p4 - 1] + "       " + y[p11 - 1] + "       " + y[p18 - 1]);
					System.out.println(
							"                       " + y[p5 - 1] + "       " + y[p12 - 1] + "       " + y[p19 - 1]);
					System.out.println(
							"                       " + y[p6 - 1] + "       " + y[p13 - 1] + "       " + y[p20 - 1]);
					System.out.println(
							"                       " + y[p7 - 1] + "       " + y[p14 - 1] + "       " + y[p21 - 1]);
					System.out.println(
							"                       " + x[b1 - 1] + "        " + x[b2 - 1] + "        " + x[b3 - 1]);
					System.out.println(
							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 ============┘");
					loginUser.setBurgerNum(count += 3);
					loginUser.getUserLever();
					userservice.userInfoUpdate(loginUser);

					break;

				case 2:
					b = true;
					System.out.println("게임 종료");
					break;
				}
			} while (!b);
		}
	}

	public void sysMode() {
	}

	public void gameEx() {
		System.out.println("                                         --- 게임 설명 ---");
		System.out.println("                        화면에 나오는 버거에 맞춰 빵과 속재료를 선택하여 만든느 게임입니다.");
		System.out.println("                                             ( 빵종류 )");
		System.out.println("                    |1.참깨빵 : ▤ ▤ ▤ ▤ | 2.호밀빵 : ■ ■ ■ ■ | 3.보리빵 : □ □ □ □ |");
		System.out.println("                                         ( 토핑 종류 )\n"
				+ "                 | 1.불고기 : ◎ ◎ ◎ ◎ ◎  | 2.새우 | § § § §  § | 3.상추 : ♧ ♧ ♧ ♧ ♧   |\n"
				+ "                 | 4.치즈 : ◇ ◇ ◇ ◇ ◇ | 5.양파 : ＠ ＠ ＠ ＠ ＠ | 6.치킨 : ○ ○ ○ ○ ○    |\n"
				+ "                 | 7.베이컨 : ▦ ▦ ▦ ▦ ▦ | 8.스테이크 : ● ● ● ● ● | 9.계란 : ◐ ◐ ◐ ◐ ◐ |");
		System.out.println("");
		System.out.println("                        만드는 순서는 맨위에서 차례로 그에 맞는 번호를 눌러 입력하면 된다.");
		System.out.println("                        레벨은 10레벨까지 있으며 레벨업은 햄버거를 만든 갯수에 따라 업한다.");
		System.out.println("              1 > 2 > 3 > 4 > 5 = 각 20개 / 5 > 6 > 7 > 8 > 9 = 각 40개 / 9 > 10 = 300개");
		System.out.println("                                      레벨마다 속재료 갯수가 증가한다");
		System.out.println("                       1 ~ 4 : 햄버거 하나, 5 ~ 8 : 햄버거 두개, 9, 10 : 햄버거 세개");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setumei() {

		System.out
				.println("   ====================================     재료 리스트     ====================================\n"
						+ "                                             ( 빵종류 )");
		System.out.println("                    |1.참깨빵 : ▤ ▤ ▤ ▤ | 2.호밀빵 : ■ ■ ■ ■ | 3.보리빵 : □ □ □ □ |");
		System.out.println("");
		System.out.println("                                         ( 토핑 종류 )\n"
				+ "                    | 1.불고기 : ◎ ◎ ◎ ◎ ◎  | 2.새우 | § § § §  § | 3.상추 : ♧ ♧ ♧ ♧ ♧   |\n"
				+ "                    | 4.치즈 : ◇ ◇ ◇ ◇ ◇ | 5.양파 : ＠ ＠ ＠ ＠ ＠ | 6.치킨 : ○ ○ ○ ○ ○    |\n"
				+ "                    | 7.베이컨 : ▦ ▦ ▦ ▦ ▦ | 8.스테이크 : ● ● ● ● ● | 9.계란 : ◐ ◐ ◐ ◐ ◐ |");
		System.out
				.println("   ====================================     재료 리스트     ====================================");
	}

}
