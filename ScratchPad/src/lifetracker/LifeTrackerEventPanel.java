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
		parent.setStatusText("");
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
				JTextField countField = new JTextField(20);
				countField.setText("Enter number");
				// to do validate number
				JButton countButton = new JButton(tracker.getName());
				countButton.setName(tracker.getName());
			    countButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		
			    		if ( countFieldIsValid(countField) ) {
			    			tracker.track(countField.getText().trim());
				    		rowMessage.setText(countField.getText().trim() + " " + tracker.getName() + " counted.");
				    		countField.setText("Enter number");
				    		parent.setStatusText("");
			    			
			    		} else { 
			    			rowMessage.setText("Error - must be a valid whole number larger than zero");
			    			countField.setText("Enter number");
			    			parent.setStatusText("");
			    		}
			    		
			    		
			    	}

					

			    });
				row.add(countField);
				row.add(countButton);
				break;
				
				
			case ACTIONTRACKER:			
				JTextField actionField = new JTextField(20);
				actionField.setText("Actions separted by commas");
				
				JButton actionButton = new JButton(tracker.getName());
				actionButton.setName(tracker.getName());
			    actionButton.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e){
			    		
			    		// to do validate text, scrub tabs, scrub symbols
			    		if ( actionFieldIsValid(actionField) ){
			    			String scrubbedActionField = removeIntermediateSpaces(actionField);
			    			tracker.track("{" + scrubbedActionField + "}");
				    		rowMessage.setText("The following actions were recorded: " + scrubbedActionField);
				    		actionField.setText("Actions separted by commas");
				    		parent.setStatusText("");
			    		} else {
			    			rowMessage.setText("Error - please enter actions as words and phrases separted by commas, no symbols.");
			    			actionField.setText("Actions separted by commas");
			    			parent.setStatusText("");
			    		}
 			    		
			    		
			    		
			  
			    	}

					private String removeIntermediateSpaces(JTextField actionField) {
						String str = actionField.getText().trim();
						String newStr = str.replaceAll(" +", " ");
			    		String newStr2 = newStr.replaceAll(" , +| ,+|, +",",");
						return newStr2;
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
			    		rowMessage.setText("1 " + tracker.getName() + " counted.");
			    		parent.setStatusText("");
			    	}


			    });
			    // space out for button alignment
			    row.add(new JLabel("Click here to log events for Clicker:       "));
			    row.add(clickerButton);
			    break;
			

		}
		row.add(rowMessage);
		trackersPanel.add(Box.createVerticalStrut(20));
		trackersPanel.add(row);
		

	    
		
		
	}
	
	private boolean countFieldIsValid(JTextField countField) {
		String str = countField.getText().trim();
		
		if ( str == null || str.equals("0")) {
            return false;
        }
		
		if (str.matches("[0-9 ]+")) {
			return true;
		}
			
	    return false;
		
	}
	
	private boolean actionFieldIsValid(JTextField actionField) {
		String str = actionField.getText().trim();
		
		if ( str.equals("Actions separted by commas")) {
			return false;
		}
		
		if ( str == null || str.equals(" ")) {
            return false;
        }
		
		if (str.matches("[A-Za-z, ]+")) {
			return true;
		}
		return false;
		
		
	}
	
	
	
}
