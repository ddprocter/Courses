package Homework3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
	
public class Ch9p16 {
	
	private JTextArea textArea;
	private JRadioButton green;
	private JRadioButton red;
	private JRadioButton orange;
	private JRadioButton blue;
	private JRadioButton yellow;
	private JRadioButton black;
	
	
	
	
	public Ch9p16(){
		JFrame window = new JFrame();
		JPanel topPanel = new JPanel(new BorderLayout());
		textArea = new JTextArea(10,25);
		
		green = new JRadioButton("Green");
		red = new JRadioButton("Red");
		orange = new JRadioButton("Orange");
		blue = new JRadioButton("Blue");
		yellow = new JRadioButton("Yellow");
		black = new JRadioButton("Black");
		
		ButtonGroup group = new ButtonGroup();
		group.add(green);
		group.add(red);
		group.add(orange);
		group.add(blue);
		group.add(yellow);
		group.add(black);
	
		green.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				textArea.setText("Green Selected");
			}
	
			
		});
		
		red.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				textArea.setText("Red Selected");
			}
	
			
		});
		
		orange.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				textArea.setText("Orange Selected");
			}
	
			
		});
		
		blue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				textArea.setText("Blue Selected");
			}
	
			
		});
		
		yellow.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				textArea.setText("Yellow Selected");
			}
	
			
		});
		
		black.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				textArea.setText("Black Selected");
			}
	
			
		});
		
		
		JPanel radioPanel = new JPanel(new GridLayout(3,1));
		radioPanel.add(green);
		radioPanel.add(red);
		radioPanel.add(orange);
		radioPanel.add(blue);
		radioPanel.add(yellow);
		radioPanel.add(black);
		
		
		topPanel.add(radioPanel, BorderLayout.NORTH);
		topPanel.add(textArea, BorderLayout.CENTER);
		
		

		window.setContentPane(topPanel);
		window.pack();
		window.setName("Ch9p16");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		new Ch9p16();
	}

}

