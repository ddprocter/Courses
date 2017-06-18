package lifetracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;

public class LifeTrackerEventPanel extends JPanel {
	
	private JPanel trackersPanel;
	private UserTrackerMapController userTrackers;
	private LifeTracker parent;
	User user;

	public LifeTrackerEventPanel(LifeTracker parent) {
		this.parent = parent;
		this.userTrackers = parent.getUserTrackerMapContoller();
		this.user = parent.getLoggedInUser();
		this.trackersPanel = new JPanel();
		trackersPanel.setLayout(new BoxLayout(trackersPanel, BoxLayout.Y_AXIS));
		JLabel eventPanelTitle = new JLabel("Your Trackers - Track Events");
		this.add(eventPanelTitle);
		this.add(trackersPanel);
		refreshTrackers();
		
		
	}
	
	public void refreshTrackers() {
		
		trackersPanel.removeAll();
	
		LinkedHashMap<String, Tracker> userTrackerMap = userTrackers.getUserTrackerMap();
		
		for ( Map.Entry<String,Tracker> entry : userTrackerMap.entrySet()) {
		  
			displayTrackerButton(entry.getValue());
			
		    
		}	
			
		
	}
	
	private void displayTrackerButton(Tracker tracker) {
					
		
		switch (tracker.getType()) {
			
			case COUNTTRACKER:
				JTextField countField = new JTextField(10);
				countField.setText("Enter number");
				// to do validate number
				JButton countButton = new JButton(tracker.getName());
				countButton.setName(tracker.getName());
			    countButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		tracker.track(countField.getText());		    	}


			    });
				trackersPanel.add(countField);
				trackersPanel.add(countButton);
				break;
				
				
			case ACTIONTRACKER:			
				JTextField actionField = new JTextField(10);
				actionField.setText("Enter number");
				// to do validate text, scrub tabs, scrub symbols
				JButton actionButton = new JButton(tracker.getName());
				actionButton.setName(tracker.getName());
			    actionButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		tracker.track("{" + actionField.getText() + "}");
			    	}


			    });
				trackersPanel.add(actionField);
				trackersPanel.add(actionButton);
				break;
				
			case CLICKER:
				JButton clickerButton = new JButton(tracker.getName());
				clickerButton.setName(tracker.getName());
			    clickerButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		tracker.track("1");
			    	}


			    });
			    trackersPanel.add(clickerButton);
			    break;
			

		}

	    
		
		
	}
	
	
	
	
}
