package Homework2;

import java.awt.Color;

import java.awt.image.BufferedImage;

import programwithjava.basic.DrawingKit;

public class Convolutor {
	
	private float[][] sharpKernel = {
			{-1.0f,-1.0f,-1.0f},
			{-1.0f,9.0f,-1.0f},
			{-1.0f,-1.0f,-1.0f}
			
	};
	
	
	private float[][] blurKernel = {
			{.111f,.111f,.111f},
			{.111f,.111f,.111f},
			{.111f,.111f,.111f}
			
	};
	
	private float[][] edgeKernel = {
			{-1.0f,-1.0f,-1.0f},
			{-1.0f,8.0f,-1.0f},
			{-1.0f,-1.0f,-1.0f}
			
	};
	
	private float[][] embossKernel = {
			{-2.0f,-2.0f,-2.0f},
			{-1.0f,1.0f,1.0f},
			{2.0f,2.0f,2.0f}
			
	};
	
	static final int MAX_VALUE = 255;
	static final int MIN_VALUE = 0;
	
	
	public BufferedImage convolve(float[][] kernel, BufferedImage inputImage){
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		PointWeight neighbor;
		 
		int initialColorValue;
		Color initialPixelColor;
		int initialRed;
		int initialGreen;
		int initialBlue;
		
		int neighborColorValue;
		Color neighborPixelColor;
		
		int newColorValue;
		Color newPixelColor;
		int newRed;
		int newGreen;
		int newBlue;
		
		BufferedImage outputImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		for(int x=0; x<width; x++) {
			for (int y=0; y<height; y++){
			
				initialColorValue = inputImage.getRGB(x, y);
				initialPixelColor = new Color(initialColorValue);
				initialRed = initialPixelColor.getRed();
				initialGreen = initialPixelColor.getGreen();
				initialBlue = initialPixelColor.getBlue();
				newRed = initialRed;
				newGreen=initialGreen;
				newBlue = initialBlue;
				
				for (Neighbors neighbors : Neighbors.values()) {
					if (  (neighbor = neighbors.index(x, y, width,height, kernel) ) != null ) {
						//System.out.println("x:" + x + " y:" + y + "neighborVal:" + neighbors + " neighborX:" + (int) neighbor.getX() + " neighborY:" + (int) neighbor.getY());
						neighborColorValue = inputImage.getRGB((int) neighbor.getX(), (int) neighbor.getY());
						
						neighborPixelColor = new Color(neighborColorValue);
						
						newRed += neighborPixelColor.getRed() * neighbor.weight;
						newGreen += neighborPixelColor.getGreen() * neighbor.weight;
						newBlue += neighborPixelColor.getBlue() * neighbor.weight;
						
					}
				}
				
				newRed = Math.min(newRed,  MAX_VALUE);
				newGreen = Math.min(newGreen,  MAX_VALUE);
				newBlue = Math.min(newBlue,  MAX_VALUE);
				newRed = Math.max(newRed,  MIN_VALUE);
				newGreen = Math.max(newGreen,  MIN_VALUE);
				newBlue = Math.max(newBlue,  MIN_VALUE);
				
				
				newPixelColor = new Color(newRed, newGreen, newBlue);
				newColorValue = newPixelColor.getRGB();
				outputImage.setRGB(x, y, newColorValue);
				
			}
		}
		return outputImage;
		
		
		
	}


	public static void main(String[] args) {
		
		DrawingKit dk = new DrawingKit("Convolutor", 1000,1000);
		BufferedImage picture = dk.loadPicture("image/squirrelMonkey.jpg");
		
		
		Convolutor c = new Convolutor();
		BufferedImage newPicture = c.convolve(c.sharpKernel, picture);
		
		dk.drawPicture(newPicture, 0, 100);
		
		
		
		
	}
}
