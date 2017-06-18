package lifetracker;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


public class LifeTrackerConfigPanel extends JPanel {
	
	private UserTrackerMapController userTrackers;
	private LifeTracker parent;
	JTextField trackerNameField; 
	private boolean unsaved = false;
	JLabel saveStatusText = new JLabel();
	JPanel configButtonsPanel;
	JPanel currentTrackersPanel;
	JPanel trackers;
	

	public LifeTrackerConfigPanel(LifeTracker parent) {
		
		this.parent = parent;
		userTrackers = parent.getUserTrackerMapContoller();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new LeftJustifiedPanelContainer("Add New Trackers"));
		addConfigButtonsPanel();
		addClickerTrackerButton();
		addCountTrackerButton();
		addActionTrackerButton();
		this.add(Box.createVerticalStrut(20));
		addCurrentTrackersPanel();
		
	}
	
	
	
	public void addCurrentTrackersPanel(){
		
		currentTrackersPanel = new JPanel();
		currentTrackersPanel.setLayout(new BoxLayout(currentTrackersPanel, BoxLayout.Y_AXIS));
		JPanel titleSectionLabelPanel = new LeftJustifiedPanelContainer("Your Current Trackers"); 
		titleSectionLabelPanel.add(saveStatusText);
		currentTrackersPanel.add(titleSectionLabelPanel);
		currentTrackersPanel.add(Box.createVerticalStrut(5));
		
		trackers = new JPanel();
		trackers.setLayout(new BoxLayout(trackers, BoxLayout.Y_AXIS));
		trackers.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		listCurrentTrackers();
		currentTrackersPanel.add(trackers);
		addSaveButton();
		this.add(currentTrackersPanel);
		
	}
	
	public void listCurrentTrackers(){
		
		trackers.removeAll();
		JPanel header = new JPanel();
		header.setMaximumSize(new Dimension(1000,20));
		header.setLayout(new GridLayout(1,3));
		header.add(new JLabel("Tracker Name"));
		header.add(new JLabel("Tracker Type"));
		header.add(new JLabel("Actions"));
		
		trackers.add(header);
		
		int rowcount = 1;
		
		LinkedHashMap<String, Tracker> trackersList = userTrackers.getUserTrackerMap();
		for( Map.Entry<String,Tracker> entry : trackersList.entrySet()){
			JPanel row = new JPanel();
			row.setLayout(new GridLayout(1,3));
			row.setMaximumSize(new Dimension(1000,20));
			row.add(new JLabel(entry.getValue().getName())); // this is the friendly name with case, not the lowercase key
			row.add(new JLabel(entry.getValue().getType().toString()));
			JButton removeTrackerButton = new JButton("Remove Tracker");
			String trackerName = entry.getKey();
			removeTrackerButton.setName(trackerName); // key is lower case
			removeTrackerButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					boolean success;		
				
					success = userTrackers.removeTracker(trackerName);
					if ( success) { 
						parent.setStatusText("Removed tracker " + entry.getValue().getName()); // friendly name here
						unsaved = true;
						
						saveStatusText.setText(" -- You have unsaved changes");
						trackerNameField.setText("Enter tracker name");
						listCurrentTrackers();
					}
					else {
						parent.setStatusText("Error - Could not remove " + entry.getValue().getName() );
						listCurrentTrackers();
					}
				}
				
				
			});
			row.add(removeTrackerButton);
			trackers.add(row);
			
			
			  
			  
		}
		
		
		
	}
	
	public void addConfigButtonsPanel(){
		
		configButtonsPanel = new JPanel();
		configButtonsPanel.setLayout(new BoxLayout(configButtonsPanel, BoxLayout.X_AXIS));
		configButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		configButtonsPanel.setMaximumSize(new Dimension(1000, 40));
		
		trackerNameField = new JFormattedTextField(createFormatter("******************"));
		trackerNameField.setMaximumSize(new Dimension(200,20));
		trackerNameField.setText("Enter tracker name");
		configButtonsPanel.add(trackerNameField);
	
		this.add(configButtonsPanel);
		
		
		
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
		configButtonsPanel.add(addCountTracker);
		addCountTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				Tracker newTracker = new Tracker(trackerNameField.getText().trim(), parent.getLoggedInUser(), TrackerEnum.COUNTTRACKER);
				
				success = userTrackers.addTracker(newTracker);
				if ( success) {
					parent.setStatusText("Successfully added Count Tracker " + trackerNameField.getText());
					// to do reset field text
					unsaved = true;
					saveStatusText.setText(" -- You have unsaved changes");
					trackerNameField.setText("Enter tracker name");
					listCurrentTrackers();
				}
				else {
					parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
					// to do set red
				}
				
			}
			
			
		});
	}
	
	public void addClickerTrackerButton(){
		JButton addClickerTracker = new JButton("Add Clicker");
		configButtonsPanel.add(addClickerTracker);
		addClickerTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				Tracker newTracker = new Tracker(trackerNameField.getText().trim(), parent.getLoggedInUser(), TrackerEnum.CLICKER);
				
				success = userTrackers.addTracker(newTracker);
				if ( success) {
					parent.setStatusText("Successfully added Clicker " + trackerNameField.getText());
					// set color green here 
					unsaved = true;
					// to do reset field text
					saveStatusText.setText(" -- You have unsaved changes");
					trackerNameField.setText("Enter tracker name");
					listCurrentTrackers();
				}
				else {
					parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
					// to do set this red
				}
			}
			
			
		});
		
		
	}
	
	public void addActionTrackerButton(){
		JButton addActionTracker = new JButton("Add Action Tracker");
		configButtonsPanel.add(addActionTracker);
		addActionTracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				Tracker newTracker = new Tracker(trackerNameField.getText().trim(), parent.getLoggedInUser(), TrackerEnum.ACTIONTRACKER);
				
				success = userTrackers.addTracker(newTracker);
				if ( success) { 
					parent.setStatusText("Successfully added Action Tracker " + trackerNameField.getText());
					unsaved = true;
					// to do reset field text
					saveStatusText.setText(" -- You have unsaved changes");
					trackerNameField.setText("Enter tracker name");
					listCurrentTrackers();
				}
				else {
					parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
				}
			}
			
			
		});
		
		
	}
	
	public void addSaveButton(){
		JButton saveButton = new JButton("Save Changes");
		JPanel saveButtonPanel = new JPanel( new FlowLayout(FlowLayout.LEADING));
		saveButtonPanel.setMinimumSize(new Dimension(1000,20));
		saveButtonPanel.add(saveButton);
		currentTrackersPanel.add(saveButtonPanel);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				if ( unsaved ) {
					success = userTrackers.commit();
					if (success){
						saveStatusText.setText(" -- Changes Saved Successfully!");
						parent.setStatusText("Changes Saved Successfully");
					}
					else { 
						saveStatusText.setText( " -- Error saving changes") ;
					}
				}
				else {
					saveStatusText.setText(" -- No changes to save");
				}
				
				
			}
			
			
		});
		
		
	}

}
