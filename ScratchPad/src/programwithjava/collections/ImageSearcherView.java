package programwithjava.collections;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.util.*;

public class ImageSearcherView {
  private ImageSearcher model;
  private ImageSearcherDrawingPanel drawingPanel;
  private JPanel topPanel, tagPanel;
  private JFrame frame;
  private File selectedFile; // filename of photo currently displayed
  private String currentPath = null; // path name of working directory
  private JTextField tagField;  // user enters tags here
  private JLabel tagLabel;   // label for tag field
  private JButton submitButton; // submit the tags
  private JMenuItem openPhotoMenuItem; // to open a new photo
  private JMenuItem serializeMenuItem; //  to serialize data structures
  private JMenuItem allTagsMenuItem; // for user query
  private JMenuItem exitMenuItem; 
	
  public ImageSearcherView(ImageSearcher i) {
	// set the model, which implements the ImageSearcher interface, for this view. 
    model = i;
		
	// create window and Panels
	createPanels();

	// create menu bar
	frame.setJMenuBar(createMenuBar());
		
	// create text field and button to enter and display photo tags
	createTagPanel();
		
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(600, 600);
	  frame.setTitle("Photo Finder");
	} 
  
  // create a window with various panels for displaying images and tags
  private void createPanels() {
	frame = new JFrame();
	topPanel = new JPanel(new BorderLayout());
	tagPanel = new JPanel();
	drawingPanel = new ImageSearcherDrawingPanel();
	topPanel.add(tagPanel, BorderLayout.PAGE_END);
	topPanel.add(drawingPanel, BorderLayout.CENTER);
	JScrollPane scrollPane = new JScrollPane(topPanel);
	frame.getContentPane().add(scrollPane);
  }
	
  public JTextField getTagField() {
	return tagField;
  }
	
  public File getCurrentImageFilename() {
	return selectedFile;
  }
	
 public Frame getFrame() {
	return frame;
}
 // create a panel for entering user tags
  private void createTagPanel() {
	tagLabel = new JLabel("Photo Tags:");
	tagField = new JTextField(35);
	tagField.setEnabled(false);
	tagLabel.setEnabled(false);
	tagPanel.add(tagLabel);
	tagPanel.add(tagField);
	submitButton = new JButton("Submit");
	submitButton.setEnabled(false);
	tagPanel.add(submitButton);
	}
  
 // create a menu bar 
  public JMenuBar createMenuBar() {
	// create a menuBar
	JMenuBar menuBar = new JMenuBar();

	// add a menu called File to menuBar
	JMenu menu = new JMenu("File");
	menuBar.add(menu);
		
	// add a menu item called Open Photo to File
	openPhotoMenuItem = new JMenuItem("Open Photo");
	menu.add(openPhotoMenuItem);
		
	serializeMenuItem = new JMenuItem("Serialize");
	menu.add(serializeMenuItem);
		
	exitMenuItem = new JMenuItem("Exit");
	menu.add(exitMenuItem);
		
	// add a menu called FindPhotos to menuBar
	menu = new JMenu("Find Photos");
	menuBar.add(menu);
		
	// add a menu item called With all given tags
	allTagsMenuItem = new JMenuItem("With all given tags");
	menu.add(allTagsMenuItem);
		
	menuBar.setBackground(Color.lightGray);
	return menuBar;
  }
  
 // methods to add various listeners
  public void addTagFieldListener(ActionListener listener) {
	tagField.addActionListener(listener);
  }
  
  public void addOpenPhotoMenuItemListener(ActionListener listener) {
	openPhotoMenuItem.addActionListener(listener);
  }
  	
  public void addSerializeMenuItemListener(ActionListener listener) {
	serializeMenuItem.addActionListener(listener);
  }
	
  public void addExitMenuItemListener(ActionListener listener) {
	exitMenuItem.addActionListener(listener);
  }
			
  public void addAllTagsMenuItemListener(ActionListener listener) {
	allTagsMenuItem.addActionListener(listener);
  }

  public void addSubmitButtonListener(ActionListener listener) {
	submitButton.addActionListener(listener);
  }

  //displays files as thumbnails
   public void displayThumbnails(TreeSet<File> files, LinkedHashSet<String> tags) {
    drawingPanel.drawThumbnails(files);
	displayTags(tags);
   }
     
  // display tags contained in set in tagField. 
   // If set is null, allow user to enter tags for this photo.
  private void displayTags(Collection<String> set) {
    if (set != null) {
	  Iterator<String> i = set.iterator();
	  StringBuilder sb = new StringBuilder();
	  while (i.hasNext()) {
	    String s = i.next();
		sb.append(s);
		sb.append(" ");
	  }
		
	  tagField.setText(sb.toString());
	  disableTagEntry();
	} else {
	  // allow the user to add tags
	  tagField.setText("");
	  tagField.setEditable(true);
	  submitButton.setEnabled(true);
	 }
     tagField.setEnabled(true);
     tagLabel.setEnabled(true);
  }
 
  // create a file chooser to select a JPEG file and display its tags
  public void openPhotoAndDisplayTags() {
    final JFileChooser chooser = new JFileChooser(currentPath);
	// This file filter allows the user to select JPEG files only
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG files", "JPG", "JPEG");
    chooser.addChoosableFileFilter(filter);
	int returnVal = chooser.showOpenDialog(frame);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	  //open a dialog box to select files 
       selectedFile = chooser.getSelectedFile();
       // save the current directory 
       currentPath = selectedFile.getPath();
       // load the image from the file and display it in drawingPanel
       Image image =  new javax.swing.ImageIcon(currentPath).getImage();	
 	   drawingPanel.loadImage(image);
 	   // get the tags for this photo
 		Photo p = model.getPhoto(selectedFile.getName());	 
 		//LinkedHashSet<String> tags = null;
 		Collection<String> tags = null;
 		if (p != null) 
 		  tags = p.getTags();
 		// Show the tags for this photo, if any
 		displayTags(tags);
 			 
	}
  }
	
  // disallow new tags to be entered
  public void disableTagEntry() {
    tagField.setEditable(false);
	submitButton.setEnabled(false);
  }
	
  // return true if new tags can be entered in tagField
  public boolean isTagFieldEnabled() {
	return tagField.isEnabled();
  }
	
  // get the text entered by user in tagField
  public String getTags() {
	return tagField.getText();
  }

  //update the model after deserialization
  public void updateModel (ImageSearcher m) {
    model = m;
  }
}
