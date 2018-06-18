package cc;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Uhr {

	private final long countdown = 100000;
	private long startTime;
	private long pastTime = 0;
	
	Image[] clock = new Image[12];
	
	boolean setPic() {
	
		for(int i = 0; i < 12; i++) {
		
			clock[i] = new ImageIcon(getClass().getResource("../Uhr/"+ i + ".png")).getImage();
		}
		
		startTime = System.currentTimeMillis();
		
		return true;
	}
	
	Image getPic() {

		pastTime = System.currentTimeMillis() - startTime; 
		
		int currentIndex = (int)(pastTime / (countdown / 12));
		if(currentIndex >= 12) {
			System.out.println("Ende");
			// tells main to end the game
			
			Wertung.getGoodEnd();
			return null;
		}
		
		return clock[currentIndex];
		
		
	}
	
}
