package co.project.Hamburger;


public class Hamburger {
	private int bread1; // 참깨빵
	private int bread2; // 호밀빵
	private int bread3; // 보리빵
	private int bulgogi; // 불고기
	private int shrimp; // 새우
	private int lettuce; // 상추
	private int cheese; // 치즈
	private int onion; // 양파
	private int chicken; //치킨
	private int bacon; // 베이컨
	private int steak; // 스테이크
	private int egg; // 계란
	private int salad; // 샐러드
	
	
	@Override
	public String toString() {
		System.out.println("빵 종류 : " + bread1 + " , " + bread2 + " , " + bread3);
		System.out.println("토핑 종류 : " + bulgogi + " , " + shrimp + " , \n"
				+ lettuce + " , " + cheese + " , " + onion + " , " + chicken + " , \n"
						+ bacon + " , " + steak + " , " + egg + " , " + salad);
		return null;
	}
	
	
}