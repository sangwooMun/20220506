package co.project;

import java.util.Scanner;
import java.util.TimerTask;

import co.project.lobby.Lobby;
import co.project.lobby.ThreadTest;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private Lobby lobby = new Lobby();
	ThreadTest t1 = new ThreadTest();

	public void mainJoin() {
		t1.mainScreen();
		
		System.out.println("                               ┌============= ๑'ٮ'๑ =============┐");
		System.out.println("                                         == 1. 게임 시작	");
		System.out.println("                                         == 2. 로그인  ");
		System.out.println("                                         == 3. 회원가입  ");
		System.out.println("                                         == 4. 종료	");
		System.out.println("                               └============= ๑'ٮ'๑ =============┘");
	}

	public void mainMenu() {
		System.out.println("                               ┌============= ๑'ٮ'๑ =============┐");
		System.out.println("                                         == 1. 정보 조회  ");
		System.out.println("                                         == 2. 전체 정보  ");
		System.out.println("                                         == 3. 일반 모드  ");
		System.out.println("                                         == 4. 사용자 모드 ");
		System.out.println("                                         == 5. 게임 설명  ");
		System.out.println("                                         == 6. 종료	");
		System.out.println("                               └============= ๑'ٮ'๑ =============┘");
	}

	// 로그인 or 회원가입 메뉴

//	private void sysModes() {
//		System.out.println(" 1. 타이머 시간 정하기 (10 ~ 90)");
//		System.out.println(" 2. 손님 수 설정하기 (최대 5명)");
//	}
//	

	public void mainhome() {
		boolean b = false;
		do {
			mainJoin();
			System.out.println("원하는 작업을 선택 :");
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				mainList();
				break;
			case 2:
				lobby.mainlogin();
				break;
			case 3:
				lobby.mainjoins();
				break;
			case 4:
				b = true;
				System.out.println(" ##안녕히 가세요##");
				break;
			}
		} while (!b);
	}

	public void mainList() {
		boolean b = false;
		do {
			mainMenu();
			System.out.println("원하는 작업 선택 : ");
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				lobby.userInfo();
				break;
			case 2:
				lobby.allRank();
				break;
			case 3:
				lobby.test1();
				break;
			case 4:
				lobby.sysMode();
				break;
			case 5:
				lobby.gameEx();
				break;
			case 6:
				b = true;
				System.out.println(" ##안녕히 가세요##");
				break;
			}
		} while (!b);
	}

	public void run() {
		mainhome();
		// mainList();
	}

}
