package com.programwithjava.collections; 

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.util.*;

public class ImageSearcherDrawingPanel extends JPanel {
  private Image bimage;
  int x, y, width, height;
  private TreeSet<File> filenames;
  private boolean generateThumbnails;
	
  public ImageSearcherDrawingPanel() {
 }
  // load a new image i
  public void loadImage(Image i) {
    generateThumbnails = false;
	bimage = i;
	x = y = 0;
	repaint();
  }
  
  // draw thumbnails to display photos matching user query
  public void drawThumbnails(TreeSet<File> filenames) {
	generateThumbnails = true;
	this.filenames =  filenames;
	repaint();
  }
  
 // draw an image or all filenames as thumbnails	
 public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D 	g2 = (Graphics2D) g;
	// draw image
	if (generateThumbnails == false)
	  g2.drawImage(bimage, 0, 0, null);
	else {
	  // draw thumbnails
	  if (!filenames.isEmpty()) {
	    Iterator<File> i = filenames.iterator();
		int x = y = 20;
		while (i.hasNext()) {
		  File filename = i.next();
		  bimage = new javax.swing.ImageIcon(String.valueOf(filename)).getImage();
		  g2.drawString(filename.getName(), x, y-5);
		  g2.drawImage(bimage, x, y, 100, 100, null);
		  x = x + 150;
		  if (x == 1000) {
		    x = 20;
			y = 150;
		  }
		}
	   }
	    else 
		  g2.drawString("No matching photos found", x+200, y+200);
	  }
   }
}
