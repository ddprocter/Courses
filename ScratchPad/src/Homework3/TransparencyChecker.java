package Homework3;

import java.awt.*;
import java.awt.image.BufferedImage;
import programwithjava.basic.DrawingKit;


public class TransparencyChecker {
	
	private static void alterImageTransparency(String imageLoc, String windowName){
		
	
		Font f = new Font(Font.SERIF, 1, 20);
		DrawingKit dk = new DrawingKit(windowName, 1000,1000);
		BufferedImage p = dk.loadPicture(imageLoc);
		
		// Source: 
		// http://stackoverflow.com/questions/221830/set-bufferedimage-alpha-mask-in-java
		// along with some other forum solutions 
		// we will iterate over each RGB value and use the bitand to alter the alpha for each
		int width = p.getWidth();
		int[] imgData = new int[width];
		int[] maskData = new int[width];
		
		  

		for (int y = 0; y < p.getHeight(); y++) {
		    // fetch a line of data from each image
		    p.getRGB(0, y, width, 1, imgData, 0, 1); // populates imgData[] with rgb vals for the row
		    for (int x = 0; x < width; x++) {
		    		
		    		imgData[x] = 0x7FFFFFFF  & imgData[x]; // set it to 50% transparency
		    		// FF / 2 = 7F
		    		// So we want to AND:
		    		// 0x7F and any bit set in the rest of the 0xAARRGGBB string
		    		
		    }
		        
		    // replace the data
		    p.setRGB(0, y, width, 1, imgData, 0, 1);
		}
		
		dk.drawPicture(p, 0, 100);
		dk.setFont(f);
		
		String transparency = "";
		
		switch (p.getTransparency()) {
			case 1: transparency = "OPAQUE";
			break;
			case 2: transparency = "BITMASK";
			break;
			case 3: transparency = "TRANSLUCENT";
			break;
			default: transparency = "UNKNOWN";
			break;
		}
		
		
		String transparencyString = "Picture Transparency: " + p.getTransparency() + 
				" (" + transparency + ")";
		dk.drawString(transparencyString, 50, 50);
		
		
		
	}

	private static void renderImageAndTransparency(String imageLoc, String windowName){
		
		Font f = new Font(Font.SERIF, 1, 20);
		DrawingKit dk = new DrawingKit(windowName, 1000,1000);
		BufferedImage p = dk.loadPicture(imageLoc);
		dk.drawPicture(p, 0, 100);
		dk.setFont(f);
		
		String transparency = "";
		
		switch (p.getTransparency()) {
			case 1: transparency = "OPAQUE";
			break;
			case 2: transparency = "BITMASK";
			break;
			case 3: transparency = "TRANSLUCENT";
			break;
			default: transparency = "UNKNOWN";
			break;
		}
		
		
		String transparencyString = "Picture Transparency: " + p.getTransparency() + 
				" (" + transparency + ")";
		dk.drawString(transparencyString, 50, 50);

	}

	public static void main(String[] args) {
		
		renderImageAndTransparency("image/pattern1.jpg", "TC1");
		alterImageTransparency("image/pattern1.jpg", "TC1_Transparent");
		
		
		renderImageAndTransparency("image/butterflies.png", "TC2");
		alterImageTransparency("image/butterflies.png", "TC2_Transparent");
		
		renderImageAndTransparency("image/pauseIcon.GIF", "TC3");
		alterImageTransparency("image/pauseIcon.GIF", "TC3_Transparent");
		
				
		
	}

	
	

}
