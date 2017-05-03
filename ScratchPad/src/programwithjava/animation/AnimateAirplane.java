package programwithjava.animation;

import java.awt.Graphics2D;
import programwithjava.basic.*;


public class AnimateAirplane {

	public static void main (String[] args) { 
		
		//View v = new View(topGun);
		//Controller ct = new Controller(topGun,v);
		//v.setVisible(true);
		Airplane topGun = new Airplane();
		View v = new View(topGun);
		Controller ct = new Controller(topGun,v);
		v.setVisible(true);
		
		
		
		
		
		
		
	}


}
