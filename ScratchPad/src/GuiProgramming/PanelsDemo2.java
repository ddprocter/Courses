package GuiProgramming;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.geom.*;

public class PanelsDemo2 {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		JPanel topPanel = new JPanel();
		JPanel panel1 = new JPanel();
		
		JPanel drawingPanel = new JPanel() {
			// anonymous class extends JPanel overrides the paintComponent method
			// this is called by _____ when we _____
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				Graphics2D myGraphics = (Graphics2D) g;
				Ellipse2D circle = new Ellipse2D.Float(100, 100, 200, 200);
				myGraphics.draw(circle);
			}
			
		}; // semi-colon terminates anonymous class
		
		topPanel.add(panel1);
		topPanel.add(drawingPanel);
		window.setContentPane(topPanel);
		JButton button1 = new JButton("Rectangle");
		panel1.add(button1);
		JButton button2 = new JButton("Circle");
		panel1.add(button2);
		
		drawingPanel.setPreferredSize(new Dimension(400,400));
		
		window.setSize(500, 500);
		window.setTitle("Panels Demo 2");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		 
		
		
	}

}
