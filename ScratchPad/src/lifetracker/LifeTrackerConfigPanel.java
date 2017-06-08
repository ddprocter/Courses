package lifetracker;

import java.awt.event.*;
import javax.swing.*;

public class LifeTrackerConfigPanel extends JPanel {

	public LifeTrackerConfigPanel(User loggedInUser) {
		JLabel configLabel = new JLabel("Config Panel");
		this.add(configLabel);
		JButton addClickerTracker = new JButton("Add Clicker Tracker");
		this.add(addClickerTracker);
		// to do add clicker tracker text box
		addClickerTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// add a new clicker tracker 
				// must contain text name
				
			}
			
			
		});
	}
	
	

}
