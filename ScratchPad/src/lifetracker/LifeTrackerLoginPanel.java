package lifetracker;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class LifeTrackerLoginPanel extends JPanel {
	

	private JTextField userField;
	private final JPasswordField passwordField;
	private JButton loginButton;
	private JLabel userFieldLabel;
	private JLabel passwordFieldLabel;
	private User user;
	private JLabel errorLabel;
	private JPanel userPasswordPanel;
	private LifeTracker parent;

	public LifeTrackerLoginPanel(LifeTracker parent){
		
		this.parent = parent;
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		userFieldLabel = new JLabel("User ID");
		userField = new JTextField("Enter User ID",20);
		passwordFieldLabel = new JLabel("Password");
		passwordField = new JPasswordField(20);
		loginButton = new JButton("Login");
		user = new User();

		this.setLayout(new BorderLayout() );
		this.add(errorLabel, BorderLayout.NORTH);
		userPasswordPanel = new JPanel();
		userPasswordPanel.add(userFieldLabel);
		userPasswordPanel.add(userField);
		userPasswordPanel.add(passwordFieldLabel);
		userPasswordPanel.add(passwordField);
		this.add(userPasswordPanel, BorderLayout.CENTER);
		this.add(loginButton, BorderLayout.SOUTH);

		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				login();
				
			}
		});
		
		
	}
	
	
	public void login() {
		boolean success = false;
		if (userField.getText() == "")
			errorLabel.setText("Error: Please enter a user");
		else if (passwordField.getPassword() == null)
			errorLabel.setText("Error: Please enter a password");
		else 
			success = user.login(userField.getText(), passwordField.getPassword());
		
		if (success == true) {
			parent.setLoggedInUser(user);			
			parent.initMainWindow();
			parent.setStatusText("Successfully logged in user " + user.getUserLogin() + "! What would you like to do?");
			parent.loginWindow.setVisible(false);
			
			
		} else {
			errorLabel.setText("Error: User or password value incorrect");
		}
		
	}

}
