package co.project;

import java.util.Scanner;

import co.project.lobby.Lobby;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private Lobby lobby = new Lobby();

	public void mainJoin() {
		System.out.println("      __  __                             __                                                 \r\n"
				+ "     /\\ \\/\\ \\                           /\\ \\                                                \r\n"
				+ "     \\ \\ \\_\\ \\      __       ___ ___    \\ \\ \\____   __  __   _ __     __        __    _ __  \r\n"
				+ "      \\ \\  _  \\   /'__`\\   /' __` __`\\   \\ \\ '__`\\ /\\ \\/\\ \\ /\\`'__\\ /'_ `\\    /'__`\\ /\\`'__\\\r\n"
				+ "       \\ \\ \\ \\ \\ /\\ \\L\\.\\_ /\\ \\/\\ \\/\\ \\   \\ \\ \\L\\ \\\\ \\ \\_\\ \\\\ \\ \\/ /\\ \\L\\ \\  /\\  __/ \\ \\ \\/ \r\n"
				+ "        \\ \\_\\ \\_\\\\ \\__/.\\_\\\\ \\_\\ \\_\\ \\_\\   \\ \\_,__/ \\ \\____/ \\ \\_\\ \\ \\____ \\ \\ \\____\\ \\ \\_\\ \r\n"
				+ "         \\/_/\\/_/ \\/__/\\/_/ \\/_/\\/_/\\/_/    \\/___/   \\/___/   \\/_/  \\/___L\\ \\ \\/____/  \\/_/ \r\n"
				+ "                                                                      /\\____/               \r\n"
				+ "                                                                      \\_/__/                \r\n"
				+ "     ");
		System.out.println("                                  \r\n"
				+ "                                  ⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠤⠒⠒⠒⠀⠒⠒⠂⠤⣀⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "                                  ⠀⠀⠀⠀⠀⢀⠔⠊⠁⠃⠀⠀⠐⠀⠀⠤⢜⢀⠀⠀⠈⠒⢄⠀⠀⠀⠀⠀\r\n"
				+ "                                  ⠀⠀⠀⢀⢔⢥⢎⠞⠡⠀⠦⠀⠀⠀⠠⠄⠀⠘⠁⠀⠄⠀⠑⠑⡄⠀⠀⠀\r\n"
				+ "                                  ⠀⢀⡀⡮⢹⡷⡈⡄⢄⡀⢀⠠⡂⠀⢀⣀⢠⠰⣀⠀⣀⠄⣤⡴⣺⢔⣙⡂\r\n"
				+ "                                  ⠀⠟⠢⣷⡷⣿⣾⣷⣵⣾⣓⢶⣾⣷⢞⣖⣓⡗⠺⠭⣟⠣⣵⡫⠝⡒⢢⡙\r\n"
				+ "                                  ⠀⢲⣖⡐⠁⠖⡲⢃⣷⢶⢶⢺⡭⢥⡎⠼⢖⣲⠯⠉⠦⣑⠸⠘⠒⢖⠂⠀\r\n"
				+ "                                  ⡠⢒⣒⢾⢩⣳⢄⠀⠀⠥⢀⣄⢬⠥⠶⠶⠘⠛⣯⠐⠐⠚⠹⠏⠕⡖⠃⠞\r\n"
				+ "                                  ⠀⢹⠠⢎⠖⣣⡠⢓⢔⠮⢅⣀⣄⡀⡠⢄⣩⣭⣁⠆⢢⠤⢶⡮⠝⠒⠉⠀\r\n"
				+ "                                  ⠀⠀⠀⠉⢿⣟⢅⢻⢇⡖⣻⢎⣏⣻⣶⠾⠣⢂⢝⡥⡚⢅⠩⡹⠀⠀⠀⠀\r\n"
				+ "                                  ⠤⠤⠄⠀⠈⠑⠥⠍⣉⣋⣁⣂⣊⣚⣁⣈⣈⣀⡁⠠⠤⠔⠊⠀⠀⠀⠀⠀\r\n"
				+ "                                  ");
		System.out.printf("           ____  _________  ____  ____  ____  ____  ____  ____  ____  _________  ____ \r\n"
				+ 	"          ||~ ||||       ||||F ||||a ||||c ||||t ||||o ||||r ||||y ||||       ||||~ ||\r\n"
				+ 	"          ||__||||_______||||__||||__||||__||||__||||__||||__||||__||||_______||||__||\r\n"
				+ 	"          |/__\\||/_______\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/_______\\||/__\\|\r\n"
				+ 	"          ");
		System.out.println(" ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  \r\n"
				+ "          |___||___||___||___||___||___||___||___||___||___||___||___||___||___||___|\r\n"
				);
		
		System.out.println("                               ┌============= ๑'ٮ'๑ =============┐");
		System.out.println("                                         == 1. 게임 시작	");
		System.out.println("                                         == 2. 로그인  ");
		System.out.println("                                         == 3. 회원가입  ");
		System.out.println("                                         == 4. 종료	");
		System.out.println("                               └============= ๑'ٮ'๑ =============┘");
	}

	// 로그인
//	private void mainlogin() {
//		System.out.println("로그인을 해야합니다.");
//		System.out.println("로그인을 하려면 1번을 눌러주세요");
//		System.out.println("== 2. 종료	");
//	}

	public void mainMenu() {
		System.out.println("                               ┌============= ๑'ٮ'๑ =============┐");
		System.out.println("                                         == 1. 정보 조회  ");
		System.out.println("                                         == 2. 전체 정보  ");
		System.out.println("                                         == 3. 일반 모드  ");
		System.out.println("                                         == 4. 사용자 모드 ");
		System.out.println("                                         == 5. 주방 확장  ");
		System.out.println("                                         == 6. 게임 설명  ");
		System.out.println("                                         == 7. 종료	");
		System.out.println("                               └============= ๑'ٮ'๑ =============┘");
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
		// mainList();
	}

}
