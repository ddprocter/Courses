package programwithjava.movie; 

import java.io.*;
import java.awt.*;
import javax.swing.*;

import quicktime.*;
import quicktime.io.*;
import quicktime.app.view.*;
import quicktime.std.clocks.*;
import quicktime.std.movies.*;
import quicktime.app.time.*;

public class MoviePlayer {
  JFrame window;

  // create a window and start a QuickTime session 
  public MoviePlayer(String title)  throws Exception {
    window = new JFrame(title);
    window.setLayout(new GridLayout(0, 1));
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    window.setLocation((screenSize.width)/2, (screenSize.height)/2);	
    QTSession.open();
  }

  // read the media stored in the given file into an object of type Movie 
  public Movie createMovie(String filename) throws Exception {
    QTFile f = new QTFile (new File(filename));
    OpenMovieFile omf = OpenMovieFile.asRead(f);
    Movie movie = Movie.fromFile(omf);
    return movie;
  } 

  // play video m inside the window 
  public void playVideo(Movie m) throws Exception {
    QTComponent QTPanel = QTFactory.makeQTComponent(m);
    Component drawingPanel = QTPanel.asComponent();  
    window.add(drawingPanel);
    window.pack();
    window.setVisible(true);
    m.start();
  }
	
  // play audio m 
  public void playAudio(Movie m) throws Exception {
    TaskAllMovies.addMovieAndStart();
    m.start();     
  }
	
  // stop the movie m 
  public void stop(Movie m) throws Exception {
    m.stop();
  }

  // unit of start time is seconds 
  public void setStartTime(Movie m, int startTime) throws Exception {
    int timeScale = m.getTimeScale();
    m.getTimeBase().setStartTime(new TimeRecord(timeScale, startTime * timeScale));
  }
	
  // unit of stop time is seconds 
  public void setStopTime(Movie m, int stopTime) throws Exception {
    int timeScale = m.getTimeScale();
    m.getTimeBase().setStopTime(new TimeRecord(m.getTimeScale(),  stopTime * timeScale));
  }	
	
  // get time when Movie stops
  public long getStopTime(Movie m) throws Exception {
    return m.getTimeBase().getStopTime();
  }
	
  // get time when Movie starts 
  public long getStartTime(Movie m) throws Exception {
    return m.getTimeBase().getStartTime();
  }
	
  // close the program 
  public void close() {
    System.exit(0);
  }
}
