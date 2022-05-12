package co.project.Hamburger;

import lombok.Data;

@Data
public class Hamburger {
	String[] bread = { "  ▤▤▤▤▤▤▤", "  ■■■■■■■", "  □□□□□□□" };
	String[] patty = { "◎◎◎◎◎◎◎◎◎", "§§§§§§§§§§§", "♧♧♧♧♧♧♧♧♧♧♧♧", "◇◇◇◇◇◇◇◇◇◇", "＠＠＠＠＠＠＠＠", "※※※※※※※※", "＆＆＆＆＆＆＆＆", "＃＃#＃＃＃＃", "◐◐◐◐◐◐◐" };
	
	int[] breadNum = {1,2,3};
	int[] pattyNum = {1,2,3,4};

	
	public String getbreads(int num) {

		return bread[num];
	}
	public String getpattys(int num) {

		return patty[num];
	}

//	private String bread1 = "▤ ▤  ▤ ▤"; // 참깨빵
//	private String bread2 = "■ ■  ■ ■"; // 호밀빵
//	private String bread3 = "□ □  □ □"; // 보리빵	
	
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
