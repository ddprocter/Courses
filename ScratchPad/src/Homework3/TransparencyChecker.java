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
		// we will iterate over each RGB value and use the bitand to alter the alpha for each
		int width = p.getWidth();
		int[] imgData = new int[width];
		int[] maskData = new int[width];

		for (int y = 0; y < p.getHeight(); y++) {
		    // fetch a line of data from each image
		    p.getRGB(0, y, width, 1, imgData, 0, 1); // populates imgData[] with rgb vals for the row
		    p.getRGB(0, y, width, 1, maskData, 0, 1); // same
		    // apply the mask
		    for (int x = 0; x < width; x++) {
		        int color = imgData[x] & 0x00FFFFFF; // mask away any alpha present
		        int maskColor = (maskData[x] & 0x00FF0000) << 8; // shift red into alpha bits
		        color |= maskColor;
		        imgData[x] = color;
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
