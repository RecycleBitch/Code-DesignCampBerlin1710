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

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class gui extends JPanel implements ActionListener {
	
		
	
		Timer time;
		
		Image img_1;
		Image img_2;
		Image img_3;
		Image img_4;
		Image img_5;
		Image img_6;
		Image img_7;
		Image img_8;
		Image img2;
		
		int key;
		int figur_y = 235;
		int lauf;
		int left = 0;
		int lauf_y;
		int r = 2;
		
		boolean blocked = false;

	public gui(){
		
		lauf = 0;
		
		setFocusable(true);
		
		
		ImageIcon u_1 = new ImageIcon((getClass().getResource("1.gif")));
		img_1 = u_1.getImage();
		
		ImageIcon u_2 = new ImageIcon((getClass().getResource("2.gif")));
		img_2 = u_2.getImage();
		
		ImageIcon u_3 = new ImageIcon((getClass().getResource("3.gif")));
		img_3 = u_3.getImage();
		
		ImageIcon u_4 = new ImageIcon((getClass().getResource("4.gif")));
		img_4 = u_4.getImage();
		
		ImageIcon u_5 = new ImageIcon((getClass().getResource("1.png")));
		img_5 = u_5.getImage();
		
		ImageIcon u_6 = new ImageIcon((getClass().getResource("2.png")));
		img_6 = u_6.getImage();
		
		ImageIcon u_7 = new ImageIcon((getClass().getResource("3.png")));
		img_7 = u_7.getImage();
		
		ImageIcon u_8 = new ImageIcon((getClass().getResource("4.png")));
		img_8 = u_8.getImage();
		
		ImageIcon s = new ImageIcon((getClass().getResource("images.png")));
		
		img2 = s.getImage();
		
		
		
		
		
	
		addKeyListener(new AL());
	
		
		time = new Timer(5,this);
		time.start();
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		bewegen();
		repaint();
		
		
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D f2 =(Graphics2D)g;

		
		f2.drawImage(img2,0,0,null);
		
		
		if(r == 1){
      
			f2.drawImage(img_1,left,figur_y,null);
		
		}
		if(r == 2){
		      
			f2.drawImage(img_5,left,figur_y,null);
		
		}
		if(r == 3){
			
			f2.drawImage(img_2,left,figur_y,null);
			
		}
		if(r == 4){
		      
			f2.drawImage(img_6,left,figur_y,null);
		
		}
		if(r == 5){
			
			f2.drawImage(img_3,left,figur_y,null);
			
		}
		if(r == 6){
		      
			f2.drawImage(img_7,left,figur_y,null);
		
		}
		if(r == 7){
			
			f2.drawImage(img_4,left,figur_y,null);
	
		}	
		if(r == 8){
		      
			f2.drawImage(img_8,left,figur_y,null);
		
		}
		
	}
	
	public void block(){
		
		if((left + lauf) >= 298 ){
			blocked = true;
		}if(left + lauf <= 290){
			blocked = false;
		}
	}
	
	

	
	
	public void bewegen(){
		
		
		if(blocked == false){
			if (lauf != -2) {
				
				if (left + lauf < 950) {
					
					
					left += lauf;
					
					
				} 
			} else {
	
				if (left + lauf > 0) {
	
					left += lauf;
				
					
				}
			}
		
		
		
		
			if(lauf_y != -2){
				
				if(figur_y + lauf_y < 550){
					
					figur_y += lauf_y;
					
				}
				
				
			} else{
				
				if(figur_y + lauf_y > 80 ){
					
					figur_y += lauf_y;
					
				}
			}
			
		}
		
		
			
		
	
		
	
	}
	
	
	
	
	private class AL extends KeyAdapter{
		
		
		public AL(){
			
		}
		
		public void keyPressed(KeyEvent e){
			
			
			key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT){
				lauf = -2;
				r = 7;
				block();
			}
			
			if(key == KeyEvent.VK_RIGHT){
				lauf = 2;
				r = 3;
				block();
			}
			
			if(key == KeyEvent.VK_UP){
				lauf_y = -2;
				r = 1;
				block();
			}
			
			if(key == KeyEvent.VK_DOWN){
				lauf_y = 2;
				r = 5;
				block();
			}
			
		
			if(key == KeyEvent.VK_ESCAPE){
				System.exit(0);
			}
			
			
			
				
			
		}
		
		
		public void keyReleased(KeyEvent e){
			
			key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
				lauf = 0;
				r +=1;
			}
			
			if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
				lauf_y = 0;
				r +=1;
			}
						
		}
	
		

		
	} }
	

	


