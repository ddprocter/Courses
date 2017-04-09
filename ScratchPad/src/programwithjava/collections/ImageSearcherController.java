package com.programwithjava.collections;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class ImageSearcherController {

  private ImageSearcherView view;
  private ImageSearcher model;  
  private boolean tagsSaved = true;  // keep track of changes
	
  public ImageSearcherController(ImageSearcherView v, ImageSearcher m) {  

  view = v;
  model = m;
	
  if (model.getSerializationFileName().exists()) {
    deserialize(model.getSerializationFileName());
    view.updateModel(model);
  } 

	
  view.addSubmitButtonListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if (view.isTagFieldEnabled()) {
        // extract the individual tags entered by user
        String userInput = view.getTags();
        if (!userInput.isEmpty()) {
          Collection<String> tags =  model.extractTags(userInput);
          File selectedFile = view.getCurrentImageFilename();
          Photo p = new Photo(selectedFile, tags);
          //update the hashmaps with the new photo
          model.addPhoto(selectedFile.getName(), p);
          // don't allow tags to be changed
          view.disableTagEntry();
          tagsSaved = false;
        }
      }
    }
  });
    
  // create and attach listeners to view
  view.addOpenPhotoMenuItemListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      view.openPhotoAndDisplayTags();
    }
  });
		
  view.addAllTagsMenuItemListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      displayPhotosWithGivenTagsAsThumbnails();
    }
  });
		
  view.addSerializeMenuItemListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    //model.serialize(model.getSerializationFileName());
      serialize(model.getSerializationFileName());
      tagsSaved = true;
    }
  });
		
  view.addExitMenuItemListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      closeApplication();
    }
  });
		
  view.getFrame().setVisible(true);
  }
	
  // displays photos that contain all tags when this menu item is selected
  public void displayPhotosWithGivenTagsAsThumbnails() {
    String userInput = JOptionPane.showInputDialog(view.getFrame(), "Enter tags", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
  if (userInput != null) { // if user has not pressed "cancel"
    // extract the tags and put them in a LinkedHashSet
    LinkedHashSet<String> tags = (LinkedHashSet<String>) model.extractTags(userInput);
    TreeSet<File> files = (TreeSet<File>) model.getPhotosContainingAllTags(tags);
    view.displayThumbnails(files, tags);
  }
  }
  
  // serialize the data structures and exit
  public void closeApplication() {
    if (tagsSaved == false) {
      int userInput = JOptionPane.showConfirmDialog(view.getFrame(), "Do you wish to save the new tags entered in PhotoFinder?");
      if (userInput == JOptionPane.YES_OPTION) {
        // serialize the hashmaps
        // model.serialize(model.getSerializationFileName());
        serialize(model.getSerializationFileName());
        System.exit(0);
      }
      else if (userInput == JOptionPane.NO_OPTION)
        System.exit(0);
      else ; // user pressed CANCEL, exit
    }
    else {
      System.exit(0); // no new tags to save, exit
    }
  }
  

  public void serialize(File filename) {
    FileOutputStream fileOut = null;
    ObjectOutputStream objectOut = null;
    try {
      fileOut = new FileOutputStream(filename);
      objectOut = new ObjectOutputStream(fileOut);
      objectOut.writeObject(model);
    } catch (FileNotFoundException e) {
      System.err.println("File could not be found" +e.getMessage());
    } catch (IOException e) {
      System.err.println("IOException" +e.getMessage());
    } finally {
      try {
        fileOut.close();
        objectOut.close();	
      } catch (IOException e) {
        System.err.println("IOException" +e.getMessage());
      }
    }
  }
	
  public void deserialize(File filename) {
    FileInputStream fileIn = null;
    ObjectInputStream objectIn = null;
		
    try {
      fileIn = new FileInputStream(filename);
      objectIn = new ObjectInputStream(fileIn);
      Object o = objectIn.readObject();
      model = (ImageSearcher) o;
    } catch (FileNotFoundException e) {
      System.err.println("File could not be found" +e.getMessage());
    } catch (IOException e) {
      System.err.println("IOException" +e.getMessage());
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found exception" + e.getMessage());
    } finally {
      try {
        fileIn.close();
        objectIn.close();	
      } catch (IOException e) {
        System.err.println("IOException" +e.getMessage());
      }
    }
  } 
}
