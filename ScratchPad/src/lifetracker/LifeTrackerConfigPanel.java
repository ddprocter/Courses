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
	JLabel addTrackersStatusText = new JLabel();
	JPanel configButtonsPanel;
	JPanel currentTrackersPanel;
	JPanel trackers;
	

	public LifeTrackerConfigPanel(LifeTracker parent) {
		
		this.parent = parent;
		userTrackers = parent.getUserTrackerMapContoller();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel addNewTrackersLabelPanel = new LeftJustifiedPanelContainer("Add New Trackers");
		addNewTrackersLabelPanel.add(addTrackersStatusText);
		this.add(addNewTrackersLabelPanel);
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
				createNewTracker(trackerNameField, TrackerEnum.COUNTTRACKER);
				
			}
			
			
		});
	}
	
	public void addClickerTrackerButton(){
		JButton addClickerTracker = new JButton("Add Clicker");
		configButtonsPanel.add(addClickerTracker);
		addClickerTracker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewTracker(trackerNameField, TrackerEnum.CLICKER);
				
			}			
		});
		
		
	}
	
	public void addActionTrackerButton(){
		JButton addActionTracker = new JButton("Add Action Tracker");
		configButtonsPanel.add(addActionTracker);
		addActionTracker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewTracker(trackerNameField, TrackerEnum.ACTIONTRACKER);
			}			
		});
		
		
	}
	
	private boolean trackerNameIsValid(JTextField trackerNameField) {
		String str = trackerNameField.getText().trim();
		
		if ( str.equals("Enter tracker name")) {
			return false;
		}
		
		if ( str == null || str.equals(" ")) {
            return false;
        }
		
		if (str.matches("[0-9A-Za-z ]+")) {
			return true;
		}
		return false;
	}
	
	private void createNewTracker(JTextField trackerNameField, TrackerEnum type) {

		if ( ! trackerNameIsValid(trackerNameField ) ){
			
			parent.setStatusText("Error - Invalid Tracker Name.");
			addTrackersStatusText.setText(" -- Error - Invalid Tracker Name - Only letters, numbers and spaces are allowed in Tracker names");
			// to do set this red
			trackerNameField.setText("Enter Tracker Name");
			return;
		}

		String scrubbedTrackerName = trackerNameField.getText().trim().replaceAll(" +", " ");
		Tracker newTracker = new Tracker(scrubbedTrackerName, parent.getLoggedInUser(), type);
	
		if ( userTrackers.addTracker(newTracker) ) {
			parent.setStatusText("Successfully added Clicker " + trackerNameField.getText());
			// set color green here 
			unsaved = true;
			// to do reset field text
			saveStatusText.setText(" -- You have unsaved changes");
			addTrackersStatusText.setText("");
			// to do set red
			trackerNameField.setText("Enter tracker name");
			listCurrentTrackers();
		}
		else {
			parent.setStatusText("Error - A tracker with the name " + trackerNameField.getText() + " already exists");
			// to do set this red
		}
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
						// to do make this red
					}
				}
				else {
					saveStatusText.setText(" -- No changes to save");
				}
				
				
			}
			
			
		});
		
		
	}

}
