package cc;

import java.time.Clock;
import java.time.LocalTime;

public class Zeit {

	
	
	
	static void delay(int delay) {
	
		
		long lastTime;
		long pastTime = 0;
		
		lastTime = System.currentTimeMillis();
		
		while(pastTime < delay * 1000) {
			
			pastTime = System.currentTimeMillis() - lastTime;
		}
	}
}

