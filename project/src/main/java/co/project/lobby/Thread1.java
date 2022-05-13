package co.project.lobby;

import java.util.Timer;
import java.util.TimerTask;

public class Thread1 {
	static int times = 20;
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			int times = 10;
			@Override
			public void run() {
				if(times >= 0) {
					System.out.print(times+"초 ");
					times--;
				}else {
					timer.cancel();
					System.out.println("게임 종료");
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}
	
}
