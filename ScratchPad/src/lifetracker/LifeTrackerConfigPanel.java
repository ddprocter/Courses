package lifetracker;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


public class LifeTrackerConfigPanel extends JPanel {
	
	private UserTrackerMapController userTrackers;
	private LifeTracker parent;
	JTextField trackerNameField; 
	private boolean unsaved = false;
	JLabel saveStatusText = new JLabel();
	JPanel configPanel;
	JPanel currentTrackersPanel;
	JTextArea trackers;
	

	public LifeTrackerConfigPanel(LifeTracker parent) {
		
		this.parent = parent;
		userTrackers = parent.getUserTrackerMapContoller();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addConfigPanel();
		addClickerTrackerButton();
		addCountTrackerButton();
		addActionTrackerButton();
		this.add(Box.createVerticalStrut(20));
		addCurrentTrackersPanel();
		
	}
	
	public void addSaveButton(){
		JButton saveButton = new JButton("Save Changes");
		currentTrackersPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				if ( unsaved ) {
					success = userTrackers.commit();
					if (success)
						saveStatusText.setText("Changes Saved Successfully!");
					else 
						saveStatusText.setText( "Error saving changes") ; 
				}
				else {
					saveStatusText.setText("No changes to save");
				}
				
				
			}
			
			
		});
		
		
	}
	
	public void addCurrentTrackersPanel(){
		
		currentTrackersPanel = new JPanel();
		currentTrackersPanel.setLayout(new BoxLayout(currentTrackersPanel, BoxLayout.Y_AXIS));
		currentTrackersPanel.setMaximumSize(new Dimension(1000,500));
		currentTrackersPanel.add(new JLabel("Your Current Trackers"));
		currentTrackersPanel.add(Box.createVerticalStrut(10));
		currentTrackersPanel.add(saveStatusText);
		trackers = new JTextArea();
		trackers.setEditable(false);
		
		listCurrentTrackers();
		currentTrackersPanel.add(trackers);
		addSaveButton();
		this.add(currentTrackersPanel);
		
	}
	
	public void listCurrentTrackers(){
		
		trackers.setText(null);
		ArrayList<String> trackersList = userTrackers.getUserTrackerList();
		Iterator<String> i = trackersList.iterator();
		
		while ( i.hasNext() ) {
			String tracker = i.next();
			trackers.append(tracker);
			trackers.append("\n");
		
		}
		
	}
	
	public void addConfigPanel(){
		
		configPanel = new JPanel();
		configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.X_AXIS));
		JLabel configLabel = new JLabel("Add a new Tracker");
		configPanel.setMaximumSize(new Dimension(1000, 20));
		configPanel.add(configLabel);
		trackerNameField = new JFormattedTextField(createFormatter("******************"));
		trackerNameField.setMaximumSize(new Dimension(200,20));
		trackerNameField.setText("Enter tracker name");
		configPanel.add(trackerNameField);
	
		this.add(configPanel);
		
		
		
	}
	
	protected MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
	
	public void addCountTrackerButton(){
		JButton addCountTracker = new JButton("Add Count Tracker");
		configPanel.add(addCountTracker);
		addCountTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				Tracker newTracker = new Tracker(trackerNameField.getText(), TrackerEnum.COUNTTRACKER);
				
				success = userTrackers.addTracker(newTracker);
				if ( success) {
					parent.setStatusText("Successfully added Count Tracker " + trackerNameField.getText());
					unsaved = true;
					saveStatusText.setText("You have unsaved changes");
					listCurrentTrackers();
				}
				else {
					parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
				}
				
			}
			
			
		});
	}
	
	public void addClickerTrackerButton(){
		JButton addClickerTracker = new JButton("Add Clicker");
		configPanel.add(addClickerTracker);
		addClickerTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				Tracker newTracker = new Tracker(trackerNameField.getText(), TrackerEnum.CLICKER);
				
				success = userTrackers.addTracker(newTracker);
				if ( success) {
					parent.setStatusText("Successfully added Clicker " + trackerNameField.getText());
					unsaved = true;
					saveStatusText.setText("You have unsaved changes");
					listCurrentTrackers();
				}
				else {
					parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
				}
			}
			
			
		});
		
		
	}
	
	public void addActionTrackerButton(){
		JButton addActionTracker = new JButton("Add Action Tracker");
		configPanel.add(addActionTracker);
		addActionTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				Tracker newTracker = new Tracker(trackerNameField.getText(), TrackerEnum.ACTIONTRACKER);
				
				success = userTrackers.addTracker(newTracker);
				if ( success) { 
					parent.setStatusText("Successfully added Action Tracker " + trackerNameField.getText());
					unsaved = true;
					saveStatusText.setText("You have unsaved changes");
					listCurrentTrackers();
				}
				else {
					parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
				}
			}
			
			
		});
		
		
	}
	

}
