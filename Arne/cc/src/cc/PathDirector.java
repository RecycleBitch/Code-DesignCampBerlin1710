package cc;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class PathDirector {

	
	private String MAINPATH;
	private HashMap<String, Image> components;
	
	
	public PathDirector(String MAINPATH) {
		
		this.MAINPATH = MAINPATH;
		
		System.out.println("DONE " + MAINPATH);
	}
	
	// active after 1frame
	void loadMap(int level) {
		
		components = new HashMap<String, Image>();
		setPic("images"); // always load first
		setPic("char");
		
		// loadUnits(); // load lower y-value first
		// check event? // text afterloading // disappear after decision
		// clockloading
	}
	
	private void loadUnits() {
		
		File folder = new File(MAINPATH + "units");
		File[] fileList = folder.listFiles();
		
		for(File item : fileList) {
			
			setPic(item.getName());
		}
			
			
		
		// mapInfo?
	}
	
	private void setPic(String name) {
		
		String url = MAINPATH + name + ".jpg";
		// path include
		// saving the level data into the render file // exclude render
		try {
		
			// save problem // fixed
			System.out.println("Geladen");
			components.put(name, Toolkit.getDefaultToolkit().getImage(url));
			
		}catch(Exception e) {
			
			System.out.print(url + " was not founded.");
		}
		//arraylist of componentselements
		// files seperat in level
		
	}
	
	public HashMap<String, Image> getImageList() {
		
		return components;
	}
}