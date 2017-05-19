package Homework3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
	
public class Ch9p15 {
	
	private JTextArea textArea;
	private JCheckBox name;
	private JCheckBox address;
	private JCheckBox phone;
	private String textString;
	
	public String setText(){
		textString = "";
		textString = textString.concat( name.isSelected() ? "John Smith\n" : "");
		textString = textString.concat( address.isSelected()? "123 Street Street\n" : "" ); 
		textString = textString.concat( phone.isSelected() ? "415-555-1212\n" : "") ;
		return textString;		
		
		
	}
	
	public Ch9p15(){
		JFrame window = new JFrame();
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel checkboxPanel = new JPanel();
		
		textArea = new JTextArea(10,25);
		
		address = new JCheckBox("Address", false);
		name = new JCheckBox("Name", false);
		phone = new JCheckBox("Phone Number", false);
		
		
		name.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textString = setText();		
				textArea.setText(textString);
			}
	
			
		});
		
		address.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textString = setText();		
				textArea.setText(textString);
			}
	
			
		});
		
		phone.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textString = setText();		
				textArea.setText(textString);
			}
	
			
		});
		
		
		checkboxPanel.add(name);
		checkboxPanel.add(address);
		checkboxPanel.add(phone);
		
		topPanel.add(checkboxPanel, BorderLayout.NORTH);
		topPanel.add(textArea, BorderLayout.CENTER);
		
		

		window.setContentPane(topPanel);
		window.pack();
		window.setName("Ch9p12");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		new Ch9p15();
	}

}

