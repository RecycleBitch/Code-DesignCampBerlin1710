package cc.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

public class Keyinput extends KeyAdapter {
	
	private static final boolean[] keys = new boolean[256];
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()]  = true ;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()]  =  false;
	}
	public static boolean isKeyDowm (int keyCode){
		return keys[keyCode];
		
		
		
	}
}
