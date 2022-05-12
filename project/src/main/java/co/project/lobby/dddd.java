package co.project.lobby;

import co.project.Hamburger.Hamburger;
import co.project.user.User;

public class dddd {
	
//	public void normalMode() {
//		int a;
//		boolean b = false;
//		do {
//			System.out.println("| 게임시작 : 1 | 종료 : 2 |");
//			a = scanner.nextInt();
//			switch (a) {
//			case 1:
//				System.out.println(
//						"   ====================================     재료 리스트     ====================================\n"
//								+ "                                             ( 빵종류 )");
//				System.out.println("                    |0.참깨빵 : ▤ ▤ ▤ ▤ | 1.호밀빵 : ■ ■ ■ ■ | 2.보리빵 : □ □ □ □ |");
//				System.out.println("");
//				System.out.println("                                         ( 토핑 종류 )\n"
//						+ "                    | 0.불고기 : ◎ ◎ ◎ ◎ ◎  | 1.새우 | § § § §  § | 2.상추 : ♧ ♧ ♧ ♧ ♧      |\n"
//						+ "                    | 3.치즈 : ◇ ◇ ◇ ◇ ◇ | 4.양파 : ＠ ＠ ＠ ＠ ＠ | 5.치킨 : ※ ※ ※ ※ ※     |\n"
//						+ "                    | 6.베이컨 : ＆ ＆ ＆ ＆ ＆ | 7.스테이크 : ＃ ＃ ＃ ＃ # | 8.계란 : ◐ ◐ ◐ ◐ ◐ |");
//				System.out.println(
//						"   ====================================     재료 리스트     ====================================");
//				User us = new User();
//				Hamburger hbg = new Hamburger();
//				Hamburger ham = new Hamburger();
//
//				int count = 0;
//				int countLevel = 0;
//
//				ham.getBreadNum();
//				ham.getPattyNum();
//
//				String[] x = hbg.getBread();
//				String[] y = hbg.getPatty();
//				////////////////////////////////////////////////////////////////////////////////////
//				// Level 1 버거
//				int b1 = (int) (3 * (Math.random()));
//				int p1 = (int) (7 * (Math.random()));
//				// Level 2 버거
//				int b2 = (int) (3 * (Math.random()));
//				int p2 = (int) (7 * (Math.random()));
//				// Level 3 버거
//				int b3 = (int) (3 * (Math.random()));
//				int p3 = (int) (7 * (Math.random()));
//				// Level 4 버거
//				int b4 = (int) (3 * (Math.random()));
//				int p4 = (int) (7 * (Math.random()));
//				// Level 5 버거
//				int b5 = (int) (3 * (Math.random()));
//				int p5 = (int) (7 * (Math.random()));
//				// Level 6 버거
//				int b6 = (int) (3 * (Math.random()));
//				int p6 = (int) (7 * (Math.random()));
//				// Level 7 버거
//				int b7 = (int) (3 * (Math.random()));
//				int p7 = (int) (7 * (Math.random()));
//				// Level 8 버거
//				int b8 = (int) (3 * (Math.random()));
//				int p8 = (int) (7 * (Math.random()));
//				// Level 9 버거
//				int b9 = (int) (3 * (Math.random()));
//				int p9 = (int) (7 * (Math.random()));
//				// Level 10 버거
//				int b10 = (int) (3 * (Math.random()));
//				int p10 = (int) (7 * (Math.random()));
//				////////////////////////////////////////////////////////////////////////////////////
//				System.out
//						.println("                ┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┐");
//				// Level 1
//				for (int i = 0; i < 1; i++) {
//					System.out.println(x[b1]);
//					for (int j = 0; j < (1 * (Math.random())); j++) {
//						System.out.println(y[p1]);
//					}
//					System.out.println(x[b1]);
//				}
//
//				System.out
//						.println("                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				// Level 2
//				if (loginUser.getUserLever() == 2) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b2]);
//						for (int j = 0; j < (2 * (Math.random())); j++) {
//							System.out.println(y[p2]);
//						}
//						System.out.println(x[b2]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 3
//				if (loginUser.getUserLever() == 3) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b3]);
//						for (int j = 0; j < (3 * (Math.random())); j++) {
//							System.out.println(y[p3]);
//						}
//						System.out.println(x[b3]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 4
//				if (loginUser.getUserLever() == 4) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b4]);
//						for (int j = 0; j < (4 * (Math.random())); j++) {
//							System.out.println(y[p4]);
//						}
//						System.out.println(x[b4]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 5
//				if (loginUser.getUserLever() == 5) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b5]);
//						for (int j = 0; j < (5 * (Math.random())); j++) {
//							System.out.println(y[p5]);
//						}
//						System.out.println(x[b5]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 6
//				if (loginUser.getUserLever() == 6) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b6]);
//						for (int j = 0; j < (6 * (Math.random())); j++) {
//							System.out.println(y[p6]);
//						}
//						System.out.println(x[b6]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 7
//				if (loginUser.getUserLever() == 7) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b7]);
//						for (int j = 0; j < (7 * (Math.random())); j++) {
//							System.out.println(y[p7]);
//						}
//						System.out.println(x[b7]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 8
//				if (loginUser.getUserLever() == 8) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b8]);
//						for (int j = 0; j < (8 * (Math.random())); j++) {
//							System.out.println(y[p8]);
//						}
//						System.out.println(x[b8]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 9
//				if (loginUser.getUserLever() == 9) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b9]);
//						for (int j = 0; j < (8 * (Math.random())); j++) {
//							System.out.println(y[p9]);
//						}
//						System.out.println(x[b9]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				// Level 10
//				if (loginUser.getUserLever() == 10) {
//					for (int i = 0; i < 1; i++) {
//						System.out.println(x[b10]);
//						for (int j = 0; j < (8 * (Math.random())); j++) {
//							System.out.println(y[p10]);
//						}
//						System.out.println(x[b10]);
//					}
//					System.out.println(
//							"                └============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 주문! =============┘");
//				}
//				////////////////////////////////////////////////////////////////////////////////////
//				// Level 10// Level 10// Level 10// Level 10// Level 10// Level 10// Level 10
//				if (loginUser.getUserLever() == 10) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b10].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("속재료 선택");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p10].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b10].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 9// Level 9// Level 9// Level 9// Level 9// Level 9// Level 9// Level 9
//				if (loginUser.getUserLever() == 9) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b9].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 속재료를 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p9].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b9].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 8// Level 8// Level 8// Level 8// Level 8// Level 8// Level 8// Level 8
//				if (loginUser.getUserLever() == 8) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b8].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("속재료 선택");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p8].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b8].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 7// Level 7// Level 7// Level 7// Level 7// Level 7// Level 7// Level 7
//				if (loginUser.getUserLever() == 7) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b7].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("속재료 선택");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p7].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b7].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 6// Level 6// Level 6// Level 6// Level 6// Level 6// Level 6// Level 6
//				if (loginUser.getUserLever() == 6) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b6].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("속재료 선택");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p6].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b6].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 5// Level 5// Level 5// Level 5// Level 5// Level 5// Level 5// Level 5
//				if (loginUser.getUserLever() == 5) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b5].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("속재료 선택");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p5].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b5].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 4// Level 4// Level 4// Level 4// Level 4// Level 4// Level 4// Level 4
//				if (loginUser.getUserLever() == 4) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b4].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("속재료 선택");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p4].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b4].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 3// Level 3// Level 3// Level 3// Level 3// Level 3// Level 3// Level 3
//				if (loginUser.getUserLever() == 3) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b3].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p3].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p3].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p3].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b3].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 2// Level 2// Level 2// Level 2// Level 2// Level 2// Level 2// Level 2
//				if (loginUser.getUserLever() == 2) {
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b2].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p2].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getpattys(scanner.nextInt());
//
//						if (y[p2].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//					for (int i = 0; i < hbg.getBreadNum().length; i++) {
//						System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//						String num = ham.getbreads(scanner.nextInt());
//
//						if (x[b2].equals(num)) {
//							break;
//						} else {
//							System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//						}
//					}
//				}
//				// Level 1// Level 1// Level 1// Level 1// Level 1// Level 1// Level 1// Level 1
//				for (int i = 0; i < hbg.getBreadNum().length; i++) {
//					System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//					String num = ham.getbreads(scanner.nextInt());
//
//					if (x[b1].equals(num)) {
//						break;
//					} else {
//						System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//					}
//				}
//				for (int i = 0; i < hbg.getBreadNum().length; i++) {
//					System.out.println("( ˙⤙˙ ) 토핑을 선택해 주세요 ( ˙⤙˙ )");
//					String num = ham.getpattys(scanner.nextInt());
//
//					if (y[p1].equals(num)) {
//						break;
//					} else {
//						System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//					}
//				}
//				for (int i = 0; i < hbg.getBreadNum().length; i++) {
//					System.out.println("( ˙⤙˙ ) 빵을 선택해 주세요 ( ˙⤙˙ )");
//					String num = ham.getbreads(scanner.nextInt());
//
//					if (x[b1].equals(num)) {
//						break;
//					} else {
//						System.out.println("( ॱヘॱ ) 제대로 하십쇼 예? ( ॱヘॱ )");
//					}
//				}
//				////////////////////////////////////////////////////////////////////////////////////
//				count = loginUser.getBurgerNum();
//				countLevel = loginUser.getUserLever();
//				System.out.println("┌============= 햄버거 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┐");
//				System.out.println("	" + x[b1]);
//				System.out.println("	" + y[p1]);
//				System.out.println("	" + x[b1]);
//				System.out.println("└============= 햄버거가 ＼＼\\\\୧( ⁼̴̶̤̀ω⁼̴̶̤́ )૭ //／／ 완성 =============┘");
//				loginUser.setBurgerNum(count += 1);
//				if (loginUser.getBurgerNum() % 30 == 0) {
//					loginUser.setUserLever(countLevel += 1);
//				}
//				loginUser.getUserLever();
//				userservice.userInfoUpdate(loginUser);
//				loginUser.toString();
//
//			case 2:
//				System.out.println("게임을 종료합니다.");
//				break;
//			}
//		} while (!b);
//	}

}
