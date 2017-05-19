package Homework3;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Ch9P11 {
	


	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel(new BorderLayout());
		JPanel panel3 = new JPanel(new BorderLayout());
		JPanel panel4 = new JPanel(new BorderLayout());
		
		topPanel.add(panel1, BorderLayout.CENTER);
		topPanel.add(panel2, BorderLayout.NORTH);
		topPanel.add(panel3, BorderLayout.EAST);
		topPanel.add(panel4, BorderLayout.SOUTH);
		
		window.setContentPane(topPanel);
		window.setSize(1000, 1000);
		window.setTitle("Ch9p11");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		Border black = BorderFactory.createLineBorder(Color.black);
		
		panel1.setBorder(black);
		panel2.setBorder(black);
		panel3.setBorder(black);
		panel4.setBorder(black);
		
		JButton button1a = new JButton("Panel 1 Button 1");
		panel1.add(button1a, BorderLayout.CENTER);
		JButton button1b = new JButton("Panel 1 Button 2");
		panel1.add(button1b, BorderLayout.NORTH);
		JButton button2a = new JButton("Panel 2 Button 1");
		panel2.add(button2a,BorderLayout.CENTER);
		JButton button2b = new JButton("Panel 2 Button 2");
		panel2.add(button2b,BorderLayout.EAST);
		JButton button3a = new JButton("Panel 3 Button 1");
		panel3.add(button3a,BorderLayout.CENTER);
		JButton button3b = new JButton("Panel 3 Button 2");
		panel3.add(button3b,BorderLayout.SOUTH);
		JButton button4a = new JButton("Panel 4 Button 1");
		panel4.add(button4a,BorderLayout.CENTER);
		JButton button4b = new JButton("Panel 4 Button 2");
		panel4.add(button4b,BorderLayout.WEST);
		
		
		window.setVisible(true);
		
		
		
	
	}

	}

