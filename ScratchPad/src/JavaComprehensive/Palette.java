package JavaComprehensive;

import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Palette extends JPanel {
	
	private ColorMixable mixingArea;
	
	private ColorButton red;
	private ColorButton blue;
	private ColorButton yellow;
	private ColorButton green;
	
	public Palette(ColorMixable cm){
		red = new ColorButton(Color.red, 170, 145, 20, 20);
		blue = new ColorButton(Color.blue, 210, 135, 23, 23);
		yellow = new ColorButton(Color.yellow, 250, 135, 26, 26);
		green = new ColorButton(Color.green, 290, 140, 28, 28);
		mixingArea = cm;
		
		addMouseListener(red);
		addMouseListener(blue);
		addMouseListener(yellow);
		addMouseListener(green);
		
		
	}
	
	
	private class ColorButton extends Ellipse2D.Float implements MouseListener {
		private Color color;
		
		private ColorButton(Color c1, float x, float y, float w, float h){
			super(x,y,w,h);
			color = c1;
		}
		
		private Color getColor(){
			return color;
		}
		
		public void mouseClicked(MouseEvent e){
			int x = e.getX();
			int y = e.getY();
			
			if (this.contains(x,y))
				changeColor(color);
				repaintWindow();
		}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		
		
	} // end of inner class ColorButton
	
	
	private void repaintWindow(){
		repaint();
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawPaletteShape(g2);
		
		g2.setPaint(mixingArea.getColor());
		
		if(mixingArea instanceof Shape){
			g2.fill((Shape) mixingArea);
		}
	}
		
	protected void drawPaletteShape(Graphics2D g2){
		Ellipse2D outline = new Ellipse2D.Float(125,125,250,150);
		g2.draw(outline);
		Ellipse2D hole = new Ellipse2D.Float(145,190,20,20);
		g2.draw(hole);
		g2.setPaint(Color.white);
		Ellipse2D hide = new Ellipse2D.Float(150,225,80,60);
		g2.draw(hide);
		g2.setPaint(Color.black);
		QuadCurve2D notch = new QuadCurve2D.Float();
		notch.setCurve(170,240,205,200,210,260);
		g2.draw(notch);
		notch.setCurve(170, 240, 160, 255, 153, 246);
		g2.draw(notch);
		notch.setCurve(210, 260, 205, 270, 223, 272);
		g2.draw(notch);
		
		g2.setPaint(red.getColor());
		g2.fill(red);
		g2.setPaint(blue.getColor());
		g2.fill(blue);
		g2.setPaint(yellow.getColor());
		g2.fill(yellow);
		g2.setPaint(green.getColor());
		g2.fill(green);
		
		
		
		
	}
	
	private void changeColor(Color newColor){
		mixingArea.mixColor(newColor);
	}

	public static void main(String[] args) {
		int x=220;
		int y=180;
		int w=100;
		int h=70;
		
		JFrame f = new JFrame("Palette");
		ColorMixable mixingArea = new ColoredRectangle(x,y,w,h);
		Palette p = new Palette(mixingArea);
		p.setBackground(Color.WHITE);
		p.setOpaque(true);
		f.setContentPane(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);
		
		
	}

}
