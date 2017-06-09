package lifetracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.*;

public class LifeTrackerEventPanel extends JPanel {
	
	private JPanel eventPanel, trackersPanel;
	private UserTrackerMapController userTrackers;
	User user;

	public LifeTrackerEventPanel(LifeTracker parent) {
		userTrackers = parent.getUserTrackerMapContoller();
		user = parent.getLoggedInUser();
		eventPanel = new JPanel();
		trackersPanel = new JPanel();
		eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
		JLabel eventPanelTitle = new JLabel("Your Trackers - Track Events");
		eventPanel.add(eventPanelTitle);
		eventPanel.add(trackersPanel);
		refreshTrackers();
		
	}
	
	public void refreshTrackers() {
		
		trackersPanel.removeAll();
	
		LinkedHashMap<String, Tracker> userTrackerMap = userTrackers.getUserTrackerMap();
		
		Set<String> keys = userTrackerMap.keySet();	
		Iterator<String> i = keys.iterator();
		
		while ( i.hasNext() ) {
			
			
		
		}
	
	}
}
