package com.programwithjava.animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame {
  // Components
  private JButton startButton;  // button to start the animation
  private JButton stopButton;   // button to stop the animation
	
  // Model
  private Vehicle model;
	
  public View(Vehicle m) {
    model = m;
    // Lay the components   
    JPanel panel = new JPanel() {
      public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D myGraphics = (Graphics2D) g;
      model.drawShape(myGraphics);
     }
   };
    // create the buttons
    startButton = new JButton("start");
    stopButton = new JButton("stop");
    // add the buttons to the panel
    panel.add(startButton);
    panel.add(stopButton);
    // add the panel to this window
    setContentPane(panel);
    panel.setOpaque(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setTitle("Animation");
  }
	
  // add a listener to the start button
  public void addStartListener(ActionListener listener) {
    startButton.addActionListener(listener);
  }
	
  // add a listener to the stop button
  public void addStopListener(ActionListener listener) {
    stopButton.addActionListener(listener);
  }	
}
