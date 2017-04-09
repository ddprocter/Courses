package programwithjava.animation;

import java.awt.event.*;
import javax.swing.*;

public class Controller implements  ActionListener {
  // List the models and views that the controller interacts with
  private Vehicle model; // object being animated
  private View view;   
  private Timer timer; // create a swing timer to run periodically
	
  public Controller(Vehicle m, View v) {
    model = m;
    view = v;
    timer = new Timer(30, this);
		
    // add listeners to view
    view.addStartListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      // when the start button is pressed timer starts running
        timer.start();
      }
    });
		
    // add listeners to view
    view.addStopListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // when the stop button is pressed timer stops running
        timer.stop();
      }
    });	
  }
	
  // action performed by timer
  public void actionPerformed(ActionEvent e) {
    // move the model by one step
    model.step();	   
    // call the paintComponent method in view
    view.repaint();	
  }
}
