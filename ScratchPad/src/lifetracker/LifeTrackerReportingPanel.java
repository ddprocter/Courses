package lifetracker;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;



public class LifeTrackerReportingPanel extends JPanel {
	
	private UserTrackerMapController userTrackers;
	private LifeTracker parent;
	private User user;

	public LifeTrackerReportingPanel(LifeTracker parent) {
		this.parent = parent;
		this.userTrackers = parent.getUserTrackerMapContoller();
		///this.setLayout(???);
		JLabel reportingPanelTitle = new JLabel("Your Reports");
		this.add(reportingPanelTitle);
		refreshReports();
		
	}
	
	public void refreshReports(){
		// clear panel
		this.removeAll();
		
		LinkedHashMap<String,Tracker> trackerMap = userTrackers.getUserTrackerMap();
		
		// for each tracker
		for (Map.Entry<String, Tracker> entry : trackerMap.entrySet()) {
		    Report report = Tracker.reportByDay(entry.getValue());
		    renderChart(report); 
		}
		
		
		
		
		
	}
	

	private void renderChart(Report report) {
		ReportChart chart = new ReportChart(report);
		this.add(chart);
		
	}

}
