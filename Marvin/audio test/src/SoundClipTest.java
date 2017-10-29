import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame {

	public static void playSound(String soundFile) {
	    File f = new File("./" + soundFile);
	    AudioInputStream audioIn = null;
		try {
			audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    Clip clip1 = null;
		try {
			clip1 = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			clip1.open(audioIn);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    clip1.start();
	}
   public static void main(String[] args) {
	   playSound("Laptop.wav");
	   while(true) {
		   
	   }
   }
}