package GuiProgramming;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.*;

public class SimplePanel extends JPanel {
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D myGraphics = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Float(100, 100, 200, 500);
		myGraphics.draw(circle);
		
	}

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 600);
		window.setTitle("Simple Panel");
		
		
	
		Container contentPane = window.getContentPane();
		
		SimplePanel pane = new SimplePanel();
		contentPane.add(pane);
		pane.setVisible(true);
		window.setVisible(true);
		
	}

}
