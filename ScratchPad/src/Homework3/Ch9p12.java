package Homework3;

import javax.swing.*;
import java.awt.event.*;


public class Ch9p12 {

	private JTextField inputField;
	private JTextField displayField;
	
	public Ch9p12() {
		inputField = new JTextField("Type Here", 10);
		displayField = new JTextField(10);
		
		displayField.setEditable(false);
		
		inputField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Integer numChars = inputField.getText().length(); 
				displayField.setText( numChars.toString());
			}
			
		});
		// anonymous subclass to create action performed method
		// note that actionPerformed must be implemented
		// due to inherited from interface ActionListener
		// You could do this in a separate class if you wanted 
		// but cleaner here
		// see pg 424-428 for two impls
		
		JFrame window = new JFrame();
		JPanel topPanel = new JPanel();
		
		topPanel.add(inputField);
		topPanel.add(displayField);
		
		window.setContentPane(topPanel);
		window.pack();
		window.setName("Ch9p12");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
		
		
	}

	public static void main(String[] args) {
		new Ch9p12();

	}


}
