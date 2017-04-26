package Homework1;
import java.awt.*;
import java.awt.image.BufferedImage;
import programwithjava.basic.*;



public class Ch4P21 {
	
	

	

	public static void main(String[] args) {
		
		DrawingKit dk = new DrawingKit("Change Colors",1680, 700);
		BufferedImage picture = dk.loadPicture("image/daffodils.jpg");
		dk.drawPicture(picture,0,50);
		
		
		for (int x = 0; x < picture.getWidth(); x++) {
			for (int y = 0; y < picture.getHeight(); y++) {
				//System.out.println(x + "," + y);
				int colorValue = picture.getRGB(x, y);
				Color pixelColor = new Color(colorValue);
				
				int red = pixelColor.getRed();
				int green = pixelColor.getGreen();
				int blue = pixelColor.getBlue();
				
				red = 255 - red;
				green = 255 - green;
				blue = 255 - blue;
				
				Color newPixelColor = new Color(red,green,blue);
				int newRgbValue = newPixelColor.getRGB();
				picture.setRGB(x, y, newRgbValue);
				
				
			}
		}
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// do nothing
		}
		dk.drawPicture(picture,0,50);
		
	}

}
