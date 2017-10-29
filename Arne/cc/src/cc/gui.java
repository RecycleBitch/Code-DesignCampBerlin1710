package cc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class gui extends JPanel implements ActionListener {
	
		// is not required
		private String url = "E:\\#codecamp\\cc\\bin\\cc\\";
		private HashMap<String, Image> component;
		PathDirector pd = new PathDirector(url);
		
		void setComponents(){
			
			pd.loadMap(1);
			component = pd.getImageList();
		}
	
		
		// Items tisch = new Items(250);
		// END
		
		Graphics2D f2;
		String info = "";
		Timer time;
		
		Image[] img_player_move = new Image[4]; // to short
		Image[] img_player = new Image[4];
		
		Image img2;
		Image imgl;
		Image bad1;
		Image bad2;
		Image imgs;
		Image lam;
		Image Doc;
		Image comp;
		Image comp2;
		
		int key;
		int figur_y = 340;
		int lauf = 0;
		int left = 475;
		int lauf_y;
		int r = 3;
		int v = 0;
		int z = 0;
		int Lampe = 0;
		int Tel = 0;
		int Comp = 0;
		int doc = 0;
		
		char com;
		
		String tele;
		
		Zeit zeit = new Zeit();
		Uhr uhr = new Uhr();
		boolean introduction = true;
		boolean Lamp = false;
		boolean d = true;
		boolean c = true;
		boolean t = true;
		boolean docu;
		boolean turn;

	public gui(){
		
		lauf = 0;
		uhr.setPic();
		
		setFocusable(true);
		
		ImageIcon img;
		
		for(int i = 1; i <= 4; i++) {
			
			img_player_move[i - 1] = new ImageIcon(getClass().getResource(i + ".gif")).getImage();
			img_player[i - 1] = new ImageIcon(getClass().getResource(i + ".png")).getImage();
		}
		ImageIcon s = new ImageIcon((getClass().getResource("images.png")));
		ImageIcon l = new ImageIcon((getClass().getResource("log.png")));
		ImageIcon b1 = new ImageIcon((getClass().getResource("bad1.png")));
		ImageIcon b2 = new ImageIcon((getClass().getResource("bad2.png")));
		ImageIcon sp = new ImageIcon((getClass().getResource("speech.png")));
		ImageIcon lm = new ImageIcon((getClass().getResource("lamp.png")));
		ImageIcon d = new ImageIcon((getClass().getResource("doc.png")));
		ImageIcon c = new ImageIcon((getClass().getResource("web1.png")));
		ImageIcon w = new ImageIcon((getClass().getResource("web2.png")));
		img2 = s.getImage();
		imgl = l.getImage();
		bad1 = b1.getImage();
		bad2 = b2.getImage();
		imgs = sp.getImage();
		lam = lm.getImage();
		Doc = d.getImage();
		comp = c.getImage();
		comp2 = w.getImage();
		
		
		
		
		
	
		addKeyListener(new AL());
	
		
		time = new Timer(1,this);
		time.start();
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		repaint();
		
		
		
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		f2 =(Graphics2D)g;
		
			if(z == 0){
				this.setBackground(Color.BLACK);
				f2.drawImage(bad1, 0, 0, null);
			}
			if(z == 1){
				f2.drawImage(bad2, 0, 0, null);
			}
			if(z == 2){
				f2.drawImage(imgs, left+70, figur_y - 150, null);
			}
			if(z > 2){
				if(z == 2){
					f2.drawImage(imgs, left+70, figur_y - 150, null);
				}
				f2.drawImage(img2, 0, 0, null);
				f2.drawImage(uhr.getPic(), 0, 0, null);
				if(v == 1){
					f2.drawImage(img_player_move[r - 1],left,figur_y,null);
				}else{
					f2.drawImage(img_player[r - 1], left, figur_y, null);
				}if(Lamp){
					f2.drawImage(lam, 237, 260, null);
				}
				
				if((left <= 200) && (left >= 100 ) && (figur_y <= 400) && (figur_y >=300)  ) {
					//Lampe
					f2.drawImage(imgl, left-20, figur_y-200, null);
					f2.setColor(Color.black);
					f2.drawString("Turn me on or turn me off.", left-10, figur_y-150);
					if(Lampe == 1){
						Lamp = true;
						Wertung.setLamp(Lamp);
					}else{
						Lamp = false;
						Wertung.setLamp(Lamp);
					}
					
				}
				if((left <= 340) && (left >= 300 ) && (figur_y == 340)  ) {
					//Computer
					f2.setColor(Color.black);
					if(Comp == 0 && c){
						
					f2.drawImage(imgl, left-20, figur_y-100, null);
					f2.drawString("I may have everything ", left, figur_y-50);
					f2.drawString("you desire.", left+30, figur_y-40);
					}
					if(Comp == 1 && c){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("A    https://climate.nasa.gov/", left-5, figur_y-60);
						f2.drawString("B    https://foxnews.com/climatechange/", left-5, figur_y-45);
					} 
					if(Comp == 2 && c){
						f2.drawImage(comp, 0, 0, null);
						com = 'A';
					}
					if(Comp == 3 && c){
						f2.drawImage(comp2, 0, 0,null);
						com = 'B';
					}if(Comp == 4){c = false;}
					
					//Wertung.setDocument(com);
				}
				if((left <= 580) && (left >= 560 ) && (figur_y == 340)  ) {
					//Dokumente
					f2.setColor(Color.black);
					if(doc == 0 && d ){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("What is this document?", left-5, figur_y-50);
					}
					if(doc == 1 && d){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("A   Read Document", left-5, figur_y-60);
						f2.drawString("B   Ignore Document", left-5, figur_y-45);
					}
					if(doc == 2 && d){
						f2.drawImage(Doc, 0, 0, null);
						docu = true;
					}
					if(doc == 3){docu = false;}
					if(doc == 4){d = false;}
					//Wertung.setDocument(docu);
				}
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)  ) {
					//Telefon
					f2.setColor(Color.black);
					if(Tel == 0 && t){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("You used to call", left+15, figur_y-65);
						f2.drawString("me on my cell phone.", left+2, figur_y-55);
						f2.drawString("Late night", left+30, figur_y-45);
						f2.drawString("when you need my love.", left-2, figur_y-35);
					}
					
					if(Tel == 1 && t == true){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("A  Friend", left+15, figur_y-80);
						f2.drawString("B  Colleague", left+15, figur_y-65);
						f2.drawString("C  Minister of ", left+15, figur_y-50);
						f2.drawString("     Environmental", left+15, figur_y-35);
						f2.drawString("     Protection Agency ", left+15, figur_y-20);
						
						
					}
					
					if(Tel == 2 ){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("1   Hey Bruno,", left ,figur_y - 80);
						f2.drawString("      let's talk about grills?", left , figur_y - 65);
						f2.drawString("2    Hey Bruno,", left , figur_y - 50);
						f2.drawString("      have you seen the", left , figur_y - 35);
						f2.drawString("      new Marvel movie?", left , figur_y - 20);
						tele = tele += "A";
					}
					
					if(Tel == 3){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("1 Hey Günther, what are our", left - 12,figur_y - 80);
						f2.drawString("     measurements of carbon", left - 12  , figur_y - 65);
						f2.drawString("     content in the air?", left - 12 , figur_y - 50);
						f2.drawString("2 Hey Günther,    ", left- 12 , figur_y - 35);
						f2.drawString("     what is your opinion on climate change?  ", left - 12 , figur_y - 20);
						tele = tele += "B";
					}
					
					
					if(Tel == 4){
						if(turn){
							f2.drawImage(imgl, left-20, figur_y-100, null);
							f2.drawString("2  Hey Minister Börcek,", left - 12,figur_y - 80);
							f2.drawString("what do you know", left - 12  , figur_y - 65);
							f2.drawString("and think about ", left - 12 , figur_y - 50);
							f2.drawString("climate change?", left- 12 , figur_y - 35);
						}else{
							f2.drawImage(imgl, left-20, figur_y-100, null);
							f2.drawString("1  Hey Minister Woodpicker,", left - 12,figur_y - 80);
							f2.drawString(" have you established the", left - 12  , figur_y - 65);
							f2.drawString("law that we discussed that", left - 12 , figur_y - 50);
							f2.drawString("forces companies to reduce", left- 12 , figur_y - 35);
							f2.drawString("their carbon footprint by 15%?", left - 12 , figur_y - 20);
							tele = tele += "C";
						}
						
					if(Tel == 5){
						
						tele = tele += "A";
						t = false;
						
					}
					if(Tel == 6){
						
						tele = tele += "B";
						t = false;
						
					}
						
					}if(Tel == 7){t = false;//Wertung.setTelephone(docu);
					}
					}
	
					
					
					
						
						
				}
				
				System.out.println(left + " | " + figur_y);
				
			}		

	



	boolean blocked_t = true;
	boolean blocked_s = true;
	

	public void block(){
		
		if((left + lauf) >= 205 && (figur_y + lauf_y) >= 345 ){
			blocked_t = true;
			if((left + lauf) >= 740 || (figur_y + lauf_y) >=540 ) {
				blocked_t = false;
			}
		}else{
			blocked_t = false;
		}
		
		if((left + lauf) >= 685 && (figur_y + lauf_y) >= 95 ){
			blocked_s = true;
			if((left + lauf) >= 945 || (figur_y + lauf_y) >=340 ){
				blocked_s = false;
			}
		}else{
			blocked_s = false;
		}

		
		if(blocked_s == false && blocked_t == false){
			bewegen();
		}
		
	}
		
	
		
	
	
	public void bewegen(){
		
		
		if (lauf != -5) {
			
			if (left + lauf < 950) {

				left += lauf;
			} 
		} else {

			if (left + lauf > 0) {

				left += lauf;
			
				
			}
		}
		
		if(lauf_y != -5){
			
			if(figur_y + lauf_y < 600){
				
				figur_y += lauf_y;
				
			}
			
			
		} else{
			
			if(figur_y + lauf_y > 300 ){
				
				figur_y += lauf_y;
				
			}
		}
	
		
	
	}
	
	
	private class AL extends KeyAdapter{
		
		
		public AL(){
			
		}
		
		public void keyPressed(KeyEvent e){
			
			
			key = e.getKeyCode();
			
			
			if(key == KeyEvent.VK_LEFT){
				lauf = -5;
				r = 4;
				v = 1;
			}else
			
			if(key == KeyEvent.VK_RIGHT){
				lauf = 5;
				r = 2;
				v = 1;
			}else
			
			if(key == KeyEvent.VK_SPACE){
				z += 1;
			}else
			
			if(key == KeyEvent.VK_UP){
				lauf_y = -5;
				r = 1;
				v = 1;
			}else
			
			if(key == KeyEvent.VK_DOWN){
				lauf_y = 5;
				r = 3;
				v = 1;
			}else
			
			if(key == KeyEvent.VK_E){
				
				if((left <= 200) && (left >= 100 ) && (figur_y <= 400) && (figur_y >=300))
					Lampe = 1;
				if((left <= 670) && (left >= 635 ) && (figur_y == 340))
					Tel = 1;
				if((left <= 340) && (left >= 300 ) && (figur_y == 340))
					Comp = 1;
				if((left <= 580) && (left >= 560 ) && (figur_y == 340))
					doc = 1;
			}
			
			if(key == KeyEvent.VK_R){
				
					Lampe = 0;
			}
				
			
			if(key == KeyEvent.VK_ESCAPE){
				if((left <= 200) && (left >= 100 ) && (figur_y <= 400) && (figur_y >=300)){
					//Lampe = 1;
				}
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)){
					Tel = 7;
				}
				if((left <= 340) && (left >= 300 ) && (figur_y == 340)){
					Comp = 4;
				}
				if((left <= 580) && (left >= 560 ) && (figur_y == 340)){
					doc = 4;
				
				}
			}
			
			if(key == KeyEvent.VK_A){
				if((left <= 200) && (left >= 100 ) && (figur_y <= 400) && (figur_y >=300)){
					//Lampe = 1;
				}
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)){
					Tel = 2;
				}	
				if((left <= 340) && (left >= 300 ) && (figur_y == 340)){
					Comp = 2;
				}
				if((left <= 580) && (left >= 560 ) && (figur_y == 340)){
					doc = 2;
				}
				
			}
			
			
			if(key == KeyEvent.VK_B){
				if((left <= 200) && (left >= 100 ) && (figur_y <= 400) && (figur_y >=300)){
					//Lampe = 1;
				}
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)){
					Tel = 3;
				}
				if((left <= 340) && (left >= 300 ) && (figur_y == 340)){
					Comp = 3;
				}
				if((left <= 580) && (left >= 560 ) && (figur_y == 340)){
					doc = 3;
				}
			}
			
			
			if(key == KeyEvent.VK_C){
				if((left <= 200) && (left >= 100 ) && (figur_y <= 400) && (figur_y >=300)){
					//Lampe = 1;
				}
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)){
					Tel = 4;
				}
				if((left <= 340) && (left >= 300 ) && (figur_y == 340)){
					//Comp = 1;
				}
				if((left <= 580) && (left >= 560 ) && (figur_y == 340)){
					//doc = 1;
				}
			}
			
			if(key == KeyEvent.VK_I){
				if(turn){
					turn = false;
				}else{
					turn = true;
				}
			}
			
			if(key == KeyEvent.VK_1){
				
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)){
					Tel = 5;
				}
				
			}
			if(key == KeyEvent.VK_2){
				
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)){
					Tel = 6;
				}
				
			}
			
			block();
			
			
			
			// popups
			
			// bounce predict
			
			// dialog check results conditions term
			
								
		
			
			
				
			
		}
		
		
		public void keyReleased(KeyEvent e){
			
			key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
				lauf = 0;
				v = 0;
			}
			
			if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
				lauf_y = 0;
				v = 0;
			}
			
			//if(key == KeyEvent.VK_E){
			//	p = 0;
			//}
						
		}
	}
}
	
		


	

	


