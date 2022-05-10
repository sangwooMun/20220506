package co.project.Hamburger;

import lombok.Data;

@Data
public class Hamburger {
	String[] bread = { " ▤ ▤  ▤ ▤", " ■ ■  ■ ■", " □ □  □ □" };
//	private String bread1 = "▤ ▤  ▤ ▤"; // 참깨빵
//	private String bread2 = "■ ■  ■ ■"; // 호밀빵
//	private String bread3 = "□ □  □ □"; // 보리빵

	public String getbreads(int num) {

		return bread[num - 1];
	}

	String[] patty = { "◎ ◎ ◎ ◎ ◎", "§  § § §  §", "♧  ♧ ♧ ♧  ♧", "◇ ◇ ◇ ◇ ◇", "＠ ＠ ＠ ＠ ＠\n" + "※ ※ ※ ※ ※", "＆ ＆ ＆ ＆ ＆",
			"＃ ＃ ＃ ＃ #", "◐ ◐  ◐ ◐ ◐" };

	public String getpattys(int num) {

		return patty[num - 1];
	}

	public String bur() {
		
		Hamburger hbg = new Hamburger();
		String[] x = hbg.getBread();
		String[] y = hbg.getBread();
		for (int i = 0; i < 1; i++) {
			System.out.println(x[(int) (3 * (Math.random()))]);
			for (int j = 0; j < (3 * (Math.random())); j++) {
				System.out.println(y[(int) (4 * (Math.random()))]);
			}
			System.out.println(x[(int) (3 * (Math.random()))]);

		}
		return null;
	}

//	private String bulgogi = "◎ ◎ ◎ ◎ ◎"; // 불고기
//	private String shrimp = "§ § § § §"; // 새우
//	private String lettuce = "♧ ♧ ♧ ♧ ♧"; // 상추
//	private String cheese = "◇ ◇ ◇ ◇ ◇"; // 치즈
//	private String onion = "＠ ＠ ＠ ＠ ＠"; // 양파
//	private String chicken = "※ ※ ※ ※ ※"; // 치킨
//	private String bacon = "＆ ＆ ＆ ＆ ＆"; // 베이컨
//	private String steak = "＃ ＃ ＃ ＃ #"; // 스테이크
//	private String egg = "◐ ◐ ◐ ◐ ◐"; // 계란
//	private String salad = "♣ ♣ ♣ ♣ ♣"; // 샐러드

}
