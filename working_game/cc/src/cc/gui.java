package cc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class gui extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
		
		// Items tisch = new Items(250);
		// END
	String pathPrefix = "../";
		
		Graphics2D f2;
		String info = "";
		Timer time;
		
		Image[] img_player_move = new Image[4]; // to short
		Image[] img_player = new Image[4];
		
		Image img2;
		Image imgl;
		Image bad1;
		Image bad2;
		Image bad3;
		Image god1;
		Image god2;
		Image god3;
		Image imgs;
		Image lam;
		Image Doc;
		Image comp;
		Image comp2;
		Image e;
		Image space;
		Image i;
		
		int key;
		int figur_y = 340;
		int lauf = 0;
		int left = 475;
		int lauf_y;
		int r = 3;
		int v = 0;
		static int z = 0;
		int Lampe = 0;
		int Tel = 0;
		int Comp = 0;
		int doc = 0;
		int traum = 0;
		int plant = 0;
		int lon=0;
		int loff=0;
		int loof=0;
		int hno = 0;
		int hq = 0;
		int hy = 0;
		int ld = 0;
		int steve = 0;
		
		char com;
		
		String tele;
	
		Uhr uhr = new Uhr();
		boolean introduction = true;
		boolean Lamp = false;
		boolean d = true;
		boolean c = true;
		boolean t = true;
		boolean docu;
		boolean turn;
		boolean spiel = true;
		boolean p = true;
		boolean pf = false;
		
		Font font = new Font("Courier New", 1, 50);
		Font lampe = new Font("Courier New",1,14);
		Font general = new Font("Courier New",1,17);

	public gui(){
		
		lauf = 0;
		uhr.setPic();
		
		setFocusable(true);
		
		
		
		for(int i = 1; i <= 4; i++) {
			
			img_player_move[i - 1] = new ImageIcon(getClass().getResource(pathPrefix + i + ".gif")).getImage();
			img_player[i - 1] = new ImageIcon(getClass().getResource(pathPrefix + i + ".png")).getImage();
		}
		ImageIcon s = new ImageIcon((getClass().getResource(pathPrefix + "images.png")));
		ImageIcon l = new ImageIcon((getClass().getResource(pathPrefix + "log.png")));
		ImageIcon b1 = new ImageIcon((getClass().getResource(pathPrefix + "bad1.png")));
		ImageIcon b2 = new ImageIcon((getClass().getResource(pathPrefix + "bad2.png")));
		ImageIcon b3 = new ImageIcon((getClass().getResource(pathPrefix + "bad3.png")));
		ImageIcon g1 = new ImageIcon((getClass().getResource(pathPrefix + "god1.png")));
		ImageIcon g2 = new ImageIcon((getClass().getResource(pathPrefix + "god2.png")));
		ImageIcon g3 = new ImageIcon((getClass().getResource(pathPrefix + "god3.png")));
		ImageIcon sp = new ImageIcon((getClass().getResource(pathPrefix + "speech.png")));
		ImageIcon lm = new ImageIcon((getClass().getResource(pathPrefix + "lamp.png")));
		ImageIcon d = new ImageIcon((getClass().getResource(pathPrefix + "doc.png")));
		ImageIcon c = new ImageIcon((getClass().getResource(pathPrefix + "web1.png")));
		ImageIcon w = new ImageIcon((getClass().getResource(pathPrefix + "web2.png")));
		ImageIcon eb = new ImageIcon((getClass().getResource(pathPrefix + "e.gif")));
		ImageIcon spa = new ImageIcon((getClass().getResource(pathPrefix + "space.gif")));
		ImageIcon ib = new ImageIcon((getClass().getResource(pathPrefix + "i.gif")));
		img2 = s.getImage();
		imgl = l.getImage();
		bad1 = b1.getImage();
		bad2 = b2.getImage();
		bad3 = b3.getImage();
		god1 = g1.getImage();
		god2 = g2.getImage();
		god3 = g3.getImage();
		imgs = sp.getImage();
		lam = lm.getImage();
		Doc = d.getImage();
		comp = c.getImage();
		comp2 = w.getImage();
		e = eb.getImage();
		space =spa.getImage();
		i = ib.getImage();
		
		
		
		
		
	
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
		f2.setFont(font);
		
		
			if(z == 0){
				this.setBackground(Color.BLACK);
				f2.drawImage(bad1, 0, 0, null);
				f2.drawString("2030", 50, 70);
				f2.drawImage(space, 10, 680, null);
			}
			if(z == 1){
				f2.drawImage(bad2, 0, 0, null);
				f2.drawString("2030", 50, 70);
				f2.drawImage(space, 10, 680, null);
			}
			if(z == 2){
				f2.drawImage(imgs, left+70, figur_y - 150, null);
				f2.drawString("Now", 50, 70);
				f2.drawImage(space, 10, 680, null);
			}
			if(z > 2 && z < 4){
				if(z == 2){
					f2.drawImage(imgs, left+70, figur_y - 150, null);
					
				}
				spiel = false;
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
					if(Lampe == 0){
					f2.setFont(lampe);
					f2.drawImage(imgl, left-20, figur_y-200, null);
					// sound bug format not supported
					if(loof == 0){
						// System.out.println(getClass().getResource(pathPrefix + "Lampe_onOrOff.wav").toString());
					Sound.playSound(pathPrefix + "Lampe_onOrOff.wav");
					loof ++;
					}
					f2.drawImage(e, 10, 680, null);
					f2.setColor(Color.black);
					f2.drawString("Turn me on or turn me off.", left-10, figur_y-150);
					}
					if(Lampe == 1){
						Lamp = true;
						Wertung.setLamp(Lamp);
						if(loff == 0){
							Sound.playSound(pathPrefix + "lampe_off.wav");
							loff ++;
							}
					}else{
						Lamp = false;
						Wertung.setLamp(Lamp);
						
						
					}
					
					
				}
				if((left <= 700) && (left >= 660 ) && (figur_y <= 310) && (figur_y >=300)  ) {
					//Plant
					
					if(plant == 0 && p){
					f2.setFont(general);
					f2.drawImage(imgl, left-20, figur_y-150, null);
					f2.setColor(Color.black);
					f2.drawString("Forever alone.", left-10, figur_y-100);
					f2.drawImage(e, 10, 680, null);
					if(hq == 0){
						Sound.playSound(pathPrefix + "Houseplant_question.wav");
						hq ++;
						}
					}
					if(plant == 1 && p){
						f2.setFont(general);
						f2.drawImage(imgl, left-20, figur_y-150, null);
						f2.drawString("A  Water me!", left-10, figur_y-100);
						f2.drawString("B  K Bye!", left-10, figur_y-85);
					}
					if(plant == 2 && p){
						p = false;
						pf = true;
						Wertung.setPlant(pf);
						if(hy == 0){
							Sound.playSound(pathPrefix + "Houseplant_yes.wav");
							hy ++;
							}
					}
					if(plant == 3 && p){
						p = false;
						pf = false;
						Wertung.setPlant(pf);
						if(hno == 0){
							Sound.playSound(pathPrefix + "Houseplant_no.wav");
							hno ++;
							}
					}
					
					
					
				}
				if((left <= 340) && (left >= 300 ) && (figur_y == 340)  ) {
					//Computer
					
					f2.setColor(Color.black);
					if(Comp == 0 && c){
					f2.setFont(general);	
					f2.drawImage(imgl, left-20, figur_y-100, null);
					f2.drawString("I may have everything ", left, figur_y-50);
					f2.drawString("you desire.", left+30, figur_y-40);
					f2.drawImage(e, 10, 680, null);
					if(ld == 0){
						Sound.playSound(pathPrefix + "Laptop_desire.wav");
						ld ++;
						}
					}
					if(Comp == 1 && c){
						f2.setFont(lampe);
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("A climate.nasa.gov/", left-5, figur_y-60);
						f2.drawString("B foxnews.com/climatechange/", left-5, figur_y-45);
					} 
					if(Comp == 2 && c){
						f2.drawImage(comp, 0, 0, null);
						com = 'A';
					}
					if(Comp == 3 && c){
						f2.drawImage(comp2, 0, 0,null);
						com = 'B';
					}if(Comp == 4){c = false;Wertung.setWebsite(com);Comp++;}
					
				}
				if((left <= 580) && (left >= 560 ) && (figur_y == 340)  ) {
					//Dokumente
					f2.setFont(general);
					f2.setColor(Color.black);
					if(doc == 0 && d ){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("What is this document?", left-5, figur_y-50);
						f2.drawImage(e, 10, 680, null);
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
					if(doc == 4){d = false;Wertung.setDocument(docu);doc++;}
					
				}
				if((left <= 670) && (left >= 635 ) && (figur_y == 340)  ) {
					//Telefon
					f2.setFont(lampe);
					f2.setColor(Color.black);
					if(Tel == 0 && t){
						
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawImage(e, 10, 680, null);
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
						f2.drawString("   Environmental", left+15, figur_y-35);
						f2.drawString("   Protection Agency ", left+15, figur_y-20);
						
						
					}
					
					if(Tel == 2 && t ){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("1   Hey Bruno,", left ,figur_y - 80);
						f2.drawString("      let's talk about grills?", left , figur_y - 65);
						f2.drawString("2    Hey Bruno,", left , figur_y - 50);
						f2.drawString("      have you seen the", left , figur_y - 35);
						f2.drawString("      new Marvel movie?", left , figur_y - 20);
						tele = tele += "A";
					}
					
					if(Tel == 3 && t){
						f2.drawImage(imgl, left-20, figur_y-100, null);
						f2.drawString("1 Hey G�nther, what are our", left - 12,figur_y - 80);
						f2.drawString("     measurements of carbon", left - 12  , figur_y - 65);
						f2.drawString("     content in the air?", left - 12 , figur_y - 50);
						f2.drawString("2 Hey G�nther,    ", left- 12 , figur_y - 35);
						f2.drawString("     what is your opinion on climate change?  ", left - 12 , figur_y - 20);
						tele = tele += "B";
					}
					
					
					if(Tel == 4 && t){
						if(turn){
							f2.drawImage(imgl, left-20, figur_y-100, null);
							f2.drawString("2  Hey Minister B�rcek,", left - 12,figur_y - 80);
							f2.drawString("what do you know", left - 12  , figur_y - 65);
							f2.drawString("and think about ", left - 12 , figur_y - 50);
							f2.drawString("climate change?", left- 12 , figur_y - 35);
							tele = tele += "C";
							f2.drawImage(i, 10, 680, null);
							
						}else{
							f2.drawImage(imgl, left-20, figur_y-100, null);
							f2.drawString("1  Hey Minister B�rcek,", left - 12,figur_y - 80);
							f2.drawString(" have you established the", left - 12  , figur_y - 65);
							f2.drawString("law that we discussed to", left - 12 , figur_y - 50);
							f2.drawString("force companies to reduce", left- 12 , figur_y - 35);
							f2.drawString("their carbon footprint by 15%?", left - 12 , figur_y - 20);
							tele = tele += "C";
							f2.drawImage(i, 10, 680, null);
						}
						
					
						
					}
					if(Tel == 6 && t){
						f2.drawImage(imgl, left-20,figur_y-100,null);
						f2.drawString("Minister B�rcek:", left - 12,figur_y - 80);
						f2.drawString("Climate change is a major ", left - 12,figur_y - 65);
						f2.drawString("issue at present. I believe ", left - 12,figur_y - 50);
						f2.drawString("it is very important to implement ", left - 12,figur_y - 35);
						f2.drawString("laws to force us to ", left - 12,figur_y - 20);
						f2.drawString("reduce our carbon footprint.", left - 12,figur_y - 5);
						
						//t = false;
						System.out.println("tel");
						
					}
					if(Tel == 5 && t){
						f2.drawImage(imgl, left-20,figur_y-100,null);
						f2.drawString("Minister B�rcek:", left - 12,figur_y - 80);
						f2.drawString("Yes, of course.", left - 12,figur_y - 65);
						f2.drawString("The law was implemented", left - 12,figur_y - 50);
						f2.drawString("3 days ago.", left - 12,figur_y - 35);
						f2.drawString("Thank you for your input!", left - 12,figur_y - 20);
						
						//t = false;
						
					}if(Tel == 7){t = false;Wertung.setTelephone(tele);Tel++;}
					
					
					
					
					}
				
			}
			if(uhr.getPic() == null){
				
				spiel = true;
				System.out.print("z:" + z);
				traum = Wertung.getGoodEnd();
				
				if(traum == 1){
					if(z == 3){
						f2.drawImage(god1, 0, 0, null);
						f2.drawImage(space, 10, 680, null);
					}
					if(z == 4){
						f2.drawImage(god2, 0, 0, null);
						f2.drawImage(space, 10, 680, null);
					}
					if(z == 5){
						f2.drawImage(god3, 0, 0, null);
						f2.drawImage(space, 10, 680, null);
					}
				}
				if(traum == 2){
					if(z  == 3){
						f2.drawImage(bad1, 0, 0, null);
						f2.drawImage(space, 10, 680, null);
					}
					if(z == 4){
						f2.drawImage(bad2, 0, 0, null);
						f2.drawImage(space, 10, 680, null);
					}
					if(z == 5){
						f2.drawImage(bad3, 0, 0, null);
						f2.drawImage(space, 10, 680, null);
					}
					if(z > 5){
						f2.drawString("Ende", 550, 500);
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
		
		if((left + lauf) >= 720 && (figur_y + lauf_y) >= 95 ){
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
			
			if(figur_y + lauf_y > 280 ){
				
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
				if(spiel){
				z += 1;
				}
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
				if((left <= 700) && (left >= 660 ) && (figur_y <= 310) && (figur_y >=300))
					plant = 1;
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
				if((left <= 700) && (left >= 660 ) && (figur_y <= 310) && (figur_y >=300)){
					plant = 2;
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
				if((left <= 700) && (left >= 660 ) && (figur_y <= 310) && (figur_y >=300)){
					plant = 3;
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
	
		


	

	


