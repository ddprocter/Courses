package lifetracker;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class LifeTracker {
	
	public JFrame mainWindow, loginWindow;
	private JTabbedPane tabbedPane;
	private JPanel mainPanel;
	private LifeTrackerReportingPanel reportingPanel;
	private LifeTrackerConfigPanel configPanel;
	private LifeTrackerEventPanel eventPanel;
	private LifeTrackerLoginPanel loginPanel;
	private User loggedInUser;
	private JLabel statusTextLabel;
	private UserTrackerMapController userTrackerMapController; 
	
	public LifeTracker(){
		
		loginWindow = new JFrame();
		loginPanel = new LifeTrackerLoginPanel(this);
		loginWindow.setContentPane(loginPanel);
		loginWindow.setBounds(100,100,700, 100);
		loginWindow.setTitle("Please Login");
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setVisible(true);
	
	}
	
	public void initMainWindow(){
		mainWindow = new JFrame();
		userTrackerMapController = new UserTrackerMapController(loggedInUser);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainWindow.add(mainPanel);
		statusTextLabel = new JLabel();
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(new LeftJustifiedPanelContainer(statusTextLabel));
		mainPanel.add(Box.createVerticalStrut(10));
		createTabbedPanels();
		
		mainWindow.setContentPane(mainPanel);
		// to do: dynamic logic, if you have no config, welcome message, etc. 
		
		mainWindow.setSize(1000,1000);
		mainWindow.setTitle("Life Tracker v0");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		
		
		
	}
	
	public void setStatusText(String text){
		this.statusTextLabel.setText(text);
	}
	
	private void createTabbedPanels() {
		
		tabbedPane = new JTabbedPane( );
		
		configPanel = new LifeTrackerConfigPanel(this);
		tabbedPane.addTab("Configure Trackers", null, configPanel, "Add and Remove Trackers");
		eventPanel = new LifeTrackerEventPanel(this);
		tabbedPane.addTab("Log Events", null, eventPanel, "Track Stuff!");
		reportingPanel = new LifeTrackerReportingPanel(this);
		tabbedPane.addTab("View Reports", null, reportingPanel, "View Reports");
		
		tabbedPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() instanceof JTabbedPane) {
                	// to do - prompt to save if I leave config pane without saving
                	eventPanel.refreshTrackers();
                	reportingPanel.refreshReports();
                	setStatusText("");
                }
            }
        });
		
		mainPanel.add(tabbedPane);
		
	}

	public static void main(String[] args) {
		new LifeTracker();

	}

	
	public User getLoggedInUser(){
		return this.loggedInUser;
	}
	
	public void setLoggedInUser(User user){
		this.loggedInUser = user;
		
	}
	

	public UserTrackerMapController getUserTrackerMapContoller() {
	
		return userTrackerMapController;
	}

}
