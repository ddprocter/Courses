package GuiProgramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JCheckBoxDemo {
	
	private JTextArea textArea;
	private JCheckBox checkbox1;
	private JCheckBox checkbox2;
	
	public JCheckBoxDemo(){
		JFrame window = new JFrame();
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel checkboxPanel = new JPanel();
		
		textArea = new JTextArea(10,25);
		
		checkbox1 = new JCheckBox("Check box 1", false);
		checkbox2 = new JCheckBox("Check box 2", false);
		
		checkbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(checkbox1.isSelected()) 
					textArea.append("Checkbox 1 is selected\n");
				else
					textArea.append("Checkbox 1 is deselected\n");
			}
	
			
		});
		
		checkbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(checkbox2.isSelected()) 
					textArea.append("Checkbox 2 is selected\n");
				else
					textArea.append("Checkbox 2 is deselected\n");
			}
			
		});
		
		checkboxPanel.add(checkbox1);
		checkboxPanel.add(checkbox2);
		
		topPanel.add(checkboxPanel, BorderLayout.NORTH);
		topPanel.add(textArea, BorderLayout.CENTER);
		
		

		window.setContentPane(topPanel);
		window.pack();
		window.setName("Ch9p12");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		new JCheckBoxDemo();
	}

}
