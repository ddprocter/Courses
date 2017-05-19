package GuiProgramming;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.filechooser.*;

public class PhotoOpDrawingPanel extends JPanel {
	
	private Image bimage;
	private double angle;
	private float hShear = 0.0f;
	private float vShear = 0.0f;
	private int XLoc = 0;
	private int YLoc = 0;
	

	
	public PhotoOpDrawingPanel(){
		bimage = new ImageIcon().getImage();
	}
	
	public void loadImage(Image i) {
		bimage = i;
		angle = 0.0;
		XLoc = 0;
		YLoc = 0;
		repaint();
	}
	
	public void shearImage(float hshear, float vshear){
		hShear = hshear;
		vShear = vshear;
		repaint();
	}

	public void shiftImage(Direction dir){
		switch (dir){
		case NORTH: 
			YLoc -=10;
			break;
		case SOUTH:
			YLoc += 10;
			break;
		case EAST:
			XLoc += 10;
			break;
		case WEST:
			XLoc -= 10;
			break;
		}
		repaint();

		
	}
	
	public void rotateImage(double a){
		angle = a;
		repaint();
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(angle, 250, 250);
		g2.shear(hShear, vShear);
		g2.drawImage(bimage, XLoc, YLoc, null);
	}
}
