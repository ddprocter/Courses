package Homework1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import programwithjava.basic.DrawingKit;

public class Compositor {

	static final int MAX_VALUE = 255;
	static final int MIN_VALUE = 0;
	private double image1Weight = 1.0;
	private double image2Weight = 1.0;
	
	public BufferedImage add(BufferedImage image1, BufferedImage image2){
		int width = Math.min(image1.getWidth(), image2.getWidth());
		int height =  Math.min(image1.getHeight(), image2.getHeight());
		
		BufferedImage image3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				int colorValue1 = image1.getRGB(x, y);
				Color pixelColor1 = new Color(colorValue1);
				
				int red1 = pixelColor1.getRed();
				int green1 = pixelColor1.getGreen();
				int blue1 = pixelColor1.getBlue();
				
				
				int colorValue2 = image2.getRGB(x, y);
				Color pixelColor2 = new Color(colorValue2);
				
				int red2 = pixelColor2.getRed();
				int green2 = pixelColor2.getGreen();
				int blue2 = pixelColor2.getBlue();
						
				int red3 = Math.min(red1 + red2,  MAX_VALUE);
				int green3 = Math.min(green1 + green2,  MAX_VALUE);
				int blue3 = Math.min(blue1 + blue2,  MAX_VALUE);
				
				Color newPixelColor = new Color(red3, green3, blue3);
				int newRGBValue = newPixelColor.getRGB();
				image3.setRGB(x, y, newRGBValue);
				
			}
		}
		
		return image3;
		
		
	}
	
	
	public BufferedImage subtract(BufferedImage image1, BufferedImage image2){
		int width = Math.min(image1.getWidth(), image2.getWidth());
		int height =  Math.min(image1.getHeight(), image2.getHeight());
		
		BufferedImage image3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				int colorValue1 = image1.getRGB(x, y);
				Color pixelColor1 = new Color(colorValue1);
				
				int red1 = pixelColor1.getRed();
				int green1 = pixelColor1.getGreen();
				int blue1 = pixelColor1.getBlue();
				
				
				int colorValue2 = image2.getRGB(x, y);
				Color pixelColor2 = new Color(colorValue2);
				
				int red2 = pixelColor2.getRed();
				int green2 = pixelColor2.getGreen();
				int blue2 = pixelColor2.getBlue();
						
				int red3 = Math.max(red1 - red2,  MIN_VALUE);
				int green3 = Math.max(green1 - green2,  MIN_VALUE);
				int blue3 = Math.max(blue1 - blue2,  MIN_VALUE);
				
				Color newPixelColor = new Color(red3, green3, blue3);
				int newRGBValue = newPixelColor.getRGB();
				image3.setRGB(x, y, newRGBValue);
				
			}
		}
		
		return image3;
		
		
	}
	
	
	public BufferedImage weightedAdd(BufferedImage image1, BufferedImage image2, double image1Weight, double image2Weight){
		if (image1Weight > 1.0 || image2Weight >1.0) {
			System.out.println("Error - Weights must be <= 1.0");
		}
			
			
		
		int width = Math.min(image1.getWidth(), image2.getWidth());
		int height =  Math.min(image1.getHeight(), image2.getHeight());
		
		BufferedImage image3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				
				int colorValue1 = image1.getRGB(x, y);
				Color pixelColor1 = new Color(colorValue1);
				
				int red1 = pixelColor1.getRed();
				int green1 = pixelColor1.getGreen();
				int blue1 = pixelColor1.getBlue();
				
				
				int colorValue2 = image2.getRGB(x, y);
				Color pixelColor2 = new Color(colorValue2);
				
				int red2 = pixelColor2.getRed();
				int green2 = pixelColor2.getGreen();
				int blue2 = pixelColor2.getBlue();
						
				double red3 = Math.min(image1Weight* (double)red1 + image2Weight*(double)red2,  MAX_VALUE);
				double green3 = Math.min(image1Weight*(double)green1 + image2Weight*(double)green2,  MAX_VALUE);
				double blue3 = Math.min(image1Weight*(double)blue1 + image2Weight*(double)blue2,  MAX_VALUE);
				
				
				Color newPixelColor = new Color((int)red3, (int)green3, (int)blue3);
				int newRGBValue = newPixelColor.getRGB();
				image3.setRGB(x, y, newRGBValue);
				
			}
		}
		
		return image3;
		
		
	}
	
	
		
	public static void drawThenPause(BufferedImage image, DrawingKit dk){
		
		dk.drawPicture(image, 0, 100);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// do nothing
		}
		
		
	}


	public static void main(String[] args) {
		
		DrawingKit dk = new DrawingKit("Compositor", 1000,1000);
		BufferedImage p1 = dk.loadPicture("image/pattern1.jpg");
		BufferedImage p2 = dk.loadPicture("image/pattern2.jpg");
		
		Compositor c = new Compositor();
		BufferedImage p3 = c.weightedAdd(p1,  p2, .2, 1.0);
		BufferedImage p4 = c.weightedAdd(p1, p2, 1.0, .2);
		
		drawThenPause(p1,dk);
		drawThenPause(p2,dk);
		drawThenPause(p3,dk);
		drawThenPause(p4,dk);
		
		
		
	}
		
}
