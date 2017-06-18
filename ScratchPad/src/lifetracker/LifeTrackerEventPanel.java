package lifetracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 
		trackersPanel.setLayout(new BoxLayout(trackersPanel, BoxLayout.Y_AXIS));
		this.add(new LeftJustifiedPanelContainer("Your Trackers - Track Stuff!"));
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
			
		JPanel row = new JPanel(new FlowLayout(FlowLayout.LEADING));
		row.setMaximumSize(new Dimension(1000,50));
		row.setMinimumSize(new Dimension(1000,50));
		row.add(new JLabel("     "));
		JLabel rowMessage = new JLabel("");
		
		switch (tracker.getType()) {
			
			case COUNTTRACKER:
				JTextField countField = new JTextField(10);
				countField.setText("Enter number");
				// to do validate number
				JButton countButton = new JButton(tracker.getName());
				countButton.setName(tracker.getName());
			    countButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		tracker.track(countField.getText());
			    		rowMessage.setText(countField.getText() + " Events Counted for " + tracker.getName());
			    		countField.setText("Enter number");
			    		parent.setStatusText("");
			    	}

			    });
				row.add(countField);
				row.add(countButton);
				break;
				
				
			case ACTIONTRACKER:			
				JTextField actionField = new JTextField(10);
				actionField.setText("Enter Words to Track");
				// to do validate text, scrub tabs, scrub symbols
				JButton actionButton = new JButton(tracker.getName());
				actionButton.setName(tracker.getName());
			    actionButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		tracker.track("{" + actionField.getText() + "}");
			    		rowMessage.setText(actionField.getText() + " Events Counted for " + tracker.getName());
			    		actionField.setText("Enter Words to Track");
			    		parent.setStatusText("");
			    		
			  
			    	}


			    });
				row.add(actionField);
				row.add(actionButton);
				break;
				
			case CLICKER:
				JButton clickerButton = new JButton(tracker.getName());
				clickerButton.setName(tracker.getName());
			    clickerButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		tracker.track("1");
			    		rowMessage.setText("1 Events Counted for " + tracker.getName());
			    		parent.setStatusText("");
			    	}


			    });
			    row.add(new JLabel("                                "));
			    row.add(clickerButton);
			    break;
			

		}
		row.add(rowMessage);
		trackersPanel.add(Box.createVerticalStrut(20));
		trackersPanel.add(row);
		

	    
		
		
	}
	
	
	
	
}
