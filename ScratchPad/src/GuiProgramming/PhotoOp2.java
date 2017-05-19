package GuiProgramming;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.*;


public class PhotoOp2 {
	
	private JFrame mainWindow, editWindow;
	private PhotoOpDrawingPanel drawingPanel;
	private JPanel topPanel, groupPanel, titlePanel, editTitlePanel, editPanel;
	private JLabel titleLabel;
	private JFileChooser chooser;
	private String fileName;
	private JCheckBox shearBox1;
	private JCheckBox shearBox2;
	
	
	public PhotoOp2(){
		
		mainWindow = new JFrame();
		createMainWindowPanels(); 
		
		groupPanel.add(createXYShiftPanel());
		mainWindow.setJMenuBar(createMenuBar());
		mainWindow.setContentPane(topPanel);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(600, 600);
		mainWindow.setTitle("Photo Op");;
		mainWindow.setVisible(true);	
		
		
		editWindow = new JFrame();
		createEditWindowPanels();
		editWindow.setContentPane(editPanel);
		editWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editWindow.setSize(300, 600);

		
	}
	
	

	public void showEditImageMenu(){
		editWindow.setVisible(true);
		
	}
	
	public void selectFile(){
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Select Photo files", "JPG", "JPEG");
		
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(mainWindow);
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			fileName = file.getPath();
			System.out.println(file.getPath()); // debug
			Image image = new ImageIcon(file.getPath()).getImage();
			drawingPanel.loadImage(image);
		}
		
		
	}
	
	public JPanel createXYShiftPanel(){
		
		JPanel XYShiftPanel = new JPanel();
		XYShiftPanel.setLayout(new BorderLayout());
		JButton shiftNorth = new JButton(new ImageIcon("image/up.png"));
		JButton shiftSouth = new JButton(new ImageIcon("image/down.png"));
		JButton shiftWest = new JButton(new ImageIcon("image/left.png"));
		JButton shiftEast = new JButton(new ImageIcon("image/right.png"));
		
		XYShiftPanel.add(shiftNorth, BorderLayout.NORTH);
		XYShiftPanel.add(shiftSouth, BorderLayout.SOUTH);
		XYShiftPanel.add(shiftEast, BorderLayout.EAST);
		XYShiftPanel.add(shiftWest, BorderLayout.WEST);
		
		shiftNorth.setToolTipText("Shift up by 10px");
		shiftSouth.setToolTipText("Shift down by 10px");
		shiftEast.setToolTipText("Shift right by 10px");
		shiftWest.setToolTipText("Shift left by 10px");
		
		shiftNorth.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawingPanel.shiftImage(Direction.NORTH);
			}
			
		});
		
		shiftSouth.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawingPanel.shiftImage(Direction.SOUTH);
			}
			
		});
		
		
		shiftEast.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawingPanel.shiftImage(Direction.EAST);
			}
			
		});
		
		shiftWest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawingPanel.shiftImage(Direction.WEST);
			}
			
		});
			
		
		return XYShiftPanel;
	}
	
	public JPanel createRotatePanel(){
		JPanel rotatePanel = new JPanel();
		JLabel rotateLabel = new JLabel("Set Rotation:");
		JTextField rotateAmountField = new JTextField("Rotation", 10);
		rotatePanel.add(rotateLabel);
		rotatePanel.add(rotateAmountField);
		rotateAmountField.setToolTipText("Enter the amount to rotate in degrees");
		rotatePanel.setMaximumSize(new Dimension(200,100));
		rotatePanel.setBackground(Color.lightGray);
		
		rotateAmountField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int degreesString = Integer.parseInt(rotateAmountField.getText());  
				drawingPanel.rotateImage(degreesString * Math.PI/180);
			}
			
		});
		
		return rotatePanel;
		
	}
	
	public JPanel createShearPanel(){
		
		JPanel shearPanel = new JPanel();
		shearPanel.setLayout(new BoxLayout(shearPanel, BoxLayout.Y_AXIS));
		JLabel shearVertLabel = new JLabel("Set Vertical Shear: 1-10");
		JTextField shearVertAmountField = new JTextField("0", 10);
		shearPanel.add(shearVertLabel);
		shearPanel.add(shearVertAmountField);
		
		JLabel shearHorizLabel = new JLabel("Set Horiz Shear: 1-10");
		JTextField shearHorizAmountField = new JTextField("0", 10);
		shearPanel.add(shearHorizLabel);
		shearPanel.add(shearHorizAmountField);
		shearPanel.setMaximumSize(new Dimension(200, 100));// to do not showing 
		
		
		shearVertAmountField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				float shearXVal = Float.parseFloat(shearHorizAmountField.getText());
				float shearYVal = Float.parseFloat(shearVertAmountField.getText());
				drawingPanel.shearImage(shearXVal/100.0f, shearYVal/100.0f);
			}
			
		});
		
		shearHorizAmountField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				float shearXVal = Float.parseFloat(shearHorizAmountField.getText());
				float shearYVal = Float.parseFloat(shearVertAmountField.getText());
				drawingPanel.shearImage(shearXVal/100.0f, shearYVal/100.0f);
			}
			
		});
		
		shearPanel.setBackground(Color.lightGray);
		shearPanel.setMaximumSize(new Dimension(200, 60)); // review this
		
		return shearPanel;
		
	}
	
	public JMenuBar createMenuBar(){
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem openImage = new JMenuItem("Open Image");
		fileMenu.add(openImage);
		
		openImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selectFile();
			}
			
		});
		
		JMenu imageMenu = new JMenu("Image");
		menuBar.add(imageMenu);
		JMenuItem menuRotateImage = new JMenuItem("Rotate");
		JMenuItem menuShearImage = new JMenuItem("Shear");
		JMenuItem menuScaleImage = new JMenuItem("Scale");
		imageMenu.add(menuRotateImage);
		imageMenu.add(menuShearImage);
		imageMenu.add(menuScaleImage);
		
		menuRotateImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				showEditImageMenu();
			}
			
		});
		
		menuShearImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				showEditImageMenu();
			}
			
		});
		
		menuScaleImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				showEditImageMenu();
			}
			
		});
		
		
		return menuBar;
	}
	
	public void createEditWindowPanels(){
		editPanel = new JPanel();
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
		editPanel.add(createRotatePanel());
		editPanel.add(createShearPanel());
		
		
		
	}
	
	public JPanel createTitlePanel(){
		JPanel titlePanel = new JPanel();
		topPanel.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		titlePanel.setBackground(Color.LIGHT_GRAY);
		
		return titlePanel;
		
		
		
	}
	
	public void createMainWindowPanels(){
		topPanel = new JPanel(new BorderLayout());
		drawingPanel = new PhotoOpDrawingPanel();
		groupPanel = new JPanel();
		titlePanel = createTitlePanel();
		
		topPanel.add(drawingPanel, BorderLayout.CENTER);
		topPanel.add(groupPanel, BorderLayout.EAST);
		
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
		groupPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		groupPanel.setBackground(Color.lightGray);
		
		titleLabel = new JLabel(fileName);	
		titlePanel.add(titleLabel);
		
	}
	
	public static void main(String[] args) {
		new PhotoOp2();

	}

}
