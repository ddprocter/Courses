package GuiProgramming;

import javax.swing.*;
import java.awt.event.*;


public class JTextFieldDemo  {
	
	private JTextField inputField;
	private JTextField displayField;
	
	public JTextFieldDemo() {
		inputField = new JTextField("Type Here", 10);
		displayField = new JTextField(10);
		
		displayField.setEditable(false);
		
		inputField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				displayField.setText(inputField.getText());
			}
			
		});
		// anonymous subclass to create action performed method
		// note that actionPerformed must be implemented
		// inherited from interface ActionListener
		// You could do this in a separate class if you wanted 
		// but cleaner here
		
		JFrame window = new JFrame();
		JPanel topPanel = new JPanel();
		
		topPanel.add(inputField);
		topPanel.add(displayField);
		
		window.setContentPane(topPanel);
		window.pack();
		window.setName("JTextField Demo");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
		
		
	}

	public static void main(String[] args) {
		new JTextFieldDemo();

	}

}
