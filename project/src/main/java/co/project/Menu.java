package co.project;

import java.util.Scanner;

import co.project.lobby.Lobby;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private Lobby lobby = new Lobby();
	
	public void mainJoin() {
		System.out.println("===============");
		System.out.println("== 1. 로그인  ");
		System.out.println("== 2. 회원가입  ");
		System.out.println("== 3. 종료	");
		System.out.println("===============");
	}
	
	// 로그인
//	private void mainlogin() {
//		System.out.println("로그인을 해야합니다.");
//		System.out.println("로그인을 하려면 1번을 눌러주세요");
//		System.out.println("== 2. 종료	");
//	}

	public void mainMenu() {
		System.out.println("===============");
		System.out.println("== 1. 정보 조회  ");
		System.out.println("== 2. 전체 정보  ");
		System.out.println("== 3. 일반 모드  ");
		System.out.println("== 4. 사용자 모드 ");
		System.out.println("== 5. 주방 확장  ");
		System.out.println("== 6. 게임 설명  ");
		System.out.println("== 7. 종료	");
		System.out.println("===============");
	}
	
	// 로그인 or 회원가입 메뉴

//	private void sysModes() {
//		System.out.println(" 1. 타이머 시간 정하기 (10 ~ 90)");
//		System.out.println(" 2. 손님 수 설정하기 (최대 5명)");
//	}
//	
//	private void shopping() {
//		System.out.println("=== 주방 확장 상점 ===");
//		System.out.println("== 1. 하급 주방 구매 ==");
//		System.out.println("== 2. 중급 주방 구매 ==");
//		System.out.println("== 3. 상급 주방 구매 ==");
//		System.out.println(" *주방은 순서대로 구매할 수 있습니다.* ");
//	}

//	private void mainlo() {
//		boolean b = false;
//		do {
//			mainlogin();
//			System.out.println("원하는 번호를 입력하세요");
//			int lo = scanner.nextInt();
//			switch (lo) {
//			case 1:
//				lobby.logins();
//				break;
//			case 2:
//				b = true;
//				System.out.println(" ##안녕히 가세요##");
//				break;
//			}
//		} while (!b);
//	}
//	public void mainJoins() {
//		mainJoin();
//		System.out.println("원하는 작업을 선택하세요");
//		int num = scanner.nextInt();
//		scanner.nextLine();
//		while(true) {
//			if(num == 1) {
//				System.out.println("로그인 할 아이디를 입력하세요");
//				String USERID = scanner.nextLine();
//				UserService userservice = new UserServiceImpl();
//				userservice.userlogin(USERID);
//			}
//			if(num == 2) {
//				System.out.println("회원가입할 아이디를 입력하세요");
//				String USERID = scanner.nextLine();
//				System.out.println("가입하는 사람의 이름을 입력하세요");
//				String USERNAME = scanner.nextLine();
//				UserService userservice = new UserServiceImpl();
//				userservice.userJoin(USERID, USERNAME);
//			}
//			
//		}
//	}
	
	public void mainhome() {
		boolean b = false;
		mainJoin();
		System.out.println("원하는 작업을 선택 :");
		int num = scanner.nextInt();
		switch(num) {
		case 1:
			 lobby.mainlogin();
			 break;
		case 2:
			lobby.mainjoins();
			break;
		case 3:
			b = true;
			System.out.println(" ##안녕히 가세요##");
			break;
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
				lobby.normalMode();
				break;
			case 4:
				lobby.sysMode();
				break;
			case 5:
				lobby.shopUp();
				break;
			case 6:
				lobby.gameEx();
				break;
			case 7:
				b = true;
				System.out.println(" ##안녕히 가세요##");
				break;
			}
		} while (!b);
	}

	public void run() {
		mainhome();
		//		mainList();
	}

}
