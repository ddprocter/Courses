package GuiProgramming;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.*;


public class PhotoOp {
	
	private JFrame window;
	private PhotoOpDrawingPanel drawingPanel;
	private JPanel topPanel, groupPanel, titlePanel;
	private JLabel titleLabel;
	private JFileChooser chooser;
	private String fileName;
	private JCheckBox shearBox1;
	private JCheckBox shearBox2;
	
	
	public PhotoOp(){
		
		window = new JFrame();
		createPanels(); 
		groupPanel.add(createRotatePanel());
		groupPanel.add(createShearPanel());
		window.setJMenuBar(createMenuBar());
		window.setContentPane(topPanel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 600);
		window.setTitle("Photo Op");;
		window.setVisible(true);	
		
	}
	
	public JMenuBar createMenuBar(){
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem menuItem = new JMenuItem("Open Image");
		menu.add(menuItem);
		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				selectFile();
			}
			
		});
		return menuBar;
	}

	
	public void selectFile(){
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Select Photo files", "JPG", "JPEG");
		
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(window);
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			fileName = file.getPath();
			System.out.println(file.getPath()); // debug
			Image image = new ImageIcon(file.getPath()).getImage();
			drawingPanel.loadImage(image);
		}
		
		
	}
	
	
	public JPanel createRotatePanel(){
		JPanel rotatePanel = new JPanel();
		JButton rotateRight = new JButton(new ImageIcon("image/rightButton.jpg"));
		JButton rotateLeft = new JButton(new ImageIcon("image/leftButton.jpg"));
		rotatePanel.add(rotateLeft);
		rotatePanel.add(rotateRight);
		
		rotateLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				drawingPanel.rotateImage(-Math.PI/4);
			}
			
		});
		
		rotateRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawingPanel.rotateImage(Math.PI/4);
			}
			
		});
		
		rotateRight.setToolTipText("Rotate right by 45 degrees");
		rotateLeft.setToolTipText("Rotate left by 45 degrees");
		rotatePanel.setMaximumSize(new Dimension(200,60));
		rotatePanel.setBackground(Color.lightGray);
		
		return rotatePanel;
		
	}
	
	public JPanel createTitlePanel(){
		JPanel titlePanel = new JPanel();
		topPanel.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		titlePanel.setBackground(Color.LIGHT_GRAY);
		
		return titlePanel;
		
		
		
	}
	
	public void createPanels(){
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

	public JPanel createShearPanel(){
		
		JPanel shearPanel = new JPanel();
		shearPanel.setLayout(new BoxLayout(shearPanel, BoxLayout.Y_AXIS));
		JPanel shearPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 6,6));
		JPanel shearPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 6,6));
		shearPanel.add(shearPanel1);
		shearPanel.add(shearPanel2);
		
		JLabel shearLabel = new JLabel("Shear:");
		shearPanel1.add(shearLabel);
		shearBox1 = new JCheckBox("Horiz");
		shearPanel1.add(shearBox1);
		
		
		shearBox2 = new JCheckBox("Vert  ");
		shearPanel2.add(Box.createHorizontalStrut(37)); 
		shearPanel2.add(shearBox2);
		
		shearBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				shearAction();
			}
			
		});
		
		shearBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e){
				shearAction();
			}
			
		});
		
		shearPanel.setBackground(Color.lightGray);
		shearBox1.setBackground(Color.lightGray);
		shearBox2.setBackground(Color.lightGray);
		shearPanel1.setBackground(Color.lightGray);
		shearPanel2.setBackground(Color.lightGray);
		shearPanel.setMaximumSize(new Dimension(200, 60));
		
		
		return shearPanel;
		
	}
	
	public void shearAction(){
		Random r = new Random();
		int value = r.nextInt(100);
		
		if (shearBox1.isSelected() && shearBox2.isSelected() ) {
			drawingPanel.shearImage(value/100.0f, value/100.0f);
		}
		else if (shearBox1.isSelected()) {
			drawingPanel.shearImage(value/100.0f, 0);
		}
		else if (shearBox2.isSelected()){
			drawingPanel.shearImage(0, value/100.0f);
		}
		else {
			drawingPanel.shearImage(0,0);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new PhotoOp();

	}

}
