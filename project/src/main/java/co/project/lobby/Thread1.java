package co.project.lobby;

import java.util.Timer;
import java.util.TimerTask;

public class Thread1 {

	public static void main(String[] args) {
//		Timer timer = new Timer();
//		Thread t = new Lobby();
//		t.start();
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

		Thread t = new Lobby();
		t.start();
		
		
		
		
//		Thread abc = new Lobby();
//		abc.start();
//
//		int times = 5;
//		if (times >= 0) {
//			System.out.println(times + "초 ");
//			times--;
//		}

	}
}
