package GuiProgramming;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;

public class PanelsDemo {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		JPanel topPanel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel drawingPanel = new JPanel();
		
		topPanel.add(panel1);
		topPanel.add(panel2);
		topPanel.add(drawingPanel);
		
		window.setContentPane(topPanel);
		window.setSize(500, 500);
		window.setTitle("Panel's Demo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border red = BorderFactory.createLineBorder(Color.red, 5);
		Border blue = BorderFactory.createLineBorder(Color.blue, 3);
		Border black = BorderFactory.createLineBorder(Color.black);
		
		panel1.setBorder(red);
		panel2.setBorder(blue);
		drawingPanel.setBorder(black);
		
		window.setVisible(true);
		
		
		
	
	}

}
