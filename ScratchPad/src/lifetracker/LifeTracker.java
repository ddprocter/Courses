package lifetracker;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class LifeTracker {
	
	public JFrame mainWindow, loginWindow;
	private LifeTrackerReportingPanel reportingPanel;
	private LifeTrackerConfigPanel configPanel;
	private LifeTrackerEventPanel eventPanel;
	private LifeTrackerLoginPanel loginPanel;
	private JPanel mainPanel;
	private User loggedInUser;
	
	public LifeTracker(){
		
		mainWindow = new JFrame();
		createMainWindowPanels();
		
		mainWindow.setContentPane(mainPanel);
		// to do: dynamic logic, if you have no config, welcome message, etc. 
		
		mainWindow.setSize(1000,1000);
		mainWindow.setTitle("Life Tracker v0");
		mainWindow.setVisible(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setJMenuBar(createMenuBar());
		
		loginWindow = new JFrame();
		loginPanel = new LifeTrackerLoginPanel(this);
		loginWindow.setContentPane(loginPanel);
		loginWindow.setBounds(100,100,700, 100);
		loginWindow.setTitle("Please Login");
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setVisible(true);
	
	}
	
	public JMenuBar createMenuBar(){
		
		JMenuBar menuBar = new JMenuBar();
		JMenu eventMenu = new JMenu("Track Events");
		eventMenu.addMenuListener(new MenuListener() {
			@Override
	        public void menuSelected(MenuEvent e) {
	            // show event tracker 

	        }
			@Override
	        public void menuDeselected(MenuEvent e) {
	            // do nothing
	        }
			@Override
	        public void menuCanceled(MenuEvent e) {
	            // do nothing
	        }
			
		});
		menuBar.add(eventMenu);
		JMenu configMenu = new JMenu("Configure Trackers");
		configMenu.addMenuListener(new MenuListener() {
			@Override
	        public void menuSelected(MenuEvent e) {
	            // show config 

	        }
			@Override
	        public void menuDeselected(MenuEvent e) {
	            // do nothing
	        }
			@Override
	        public void menuCanceled(MenuEvent e) {
	            // do nothing
	        }
			
		});
		menuBar.add(configMenu);
		JMenu reportMenu = new JMenu("Reporting");
		reportMenu.addMenuListener(new MenuListener() {
			@Override
	        public void menuSelected(MenuEvent e) {
	            // show report panel

	        }
			@Override
	        public void menuDeselected(MenuEvent e) {
	            // do nothing
	        }
			@Override
	        public void menuCanceled(MenuEvent e) {
	            // do nothing
	        }
			
		});
		menuBar.add(reportMenu);
		
	
		
		
		return menuBar;
	}
	
	
	
	private void createMainWindowPanels() {
		mainPanel = new JPanel();
		configPanel = new LifeTrackerConfigPanel(loggedInUser);
		eventPanel = new LifeTrackerEventPanel(loggedInUser);
		reportingPanel = new LifeTrackerReportingPanel(loggedInUser);
		mainPanel.add(configPanel);
		
		
	}

	public static void main(String[] args) {
		new LifeTracker();

	}

	
	public void setLoggedInUser(User user){
		this.loggedInUser = user;
		
	}

}
