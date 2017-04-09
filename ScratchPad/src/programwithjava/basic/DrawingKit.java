package programwithjava.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

/** This class draws a window on the screen using
* the Swing classes JFrame and JPanel. Internally, it uses
* a BufferedImage of the same size as the window. All
* the drawing is done on this BufferedImage, which is
* rendered to the screen when the repaint method is invoked.
* This class provides Java 2D methods such as draw, fill etc. to 
* draw and color graphical shapes on the window.
*
* @author Radhika S. Grover
* @author programwithjava.com
*/

public class DrawingKit {
  private JFrame window;
  private JPanel drawingSheet;
  private BufferedImage bufferedImage;
  Graphics2D bufferedImageGraphics;

  /** Constructor to create a window with size 500 x 500.	
  */
  public DrawingKit() {
    this("", 500, 500);
  }
  
  /** Constructor to create a window with a 
  * title and default size of 500 by 500.	
  *
  * @param title the window title.
  */ 
  public DrawingKit(String title) {
    this(title, 500, 500);
  }
  
  /** Constructor to create a window of the specified width and height.
  *
  * @param width the window width.
  * @param height the window height.
  */
  public DrawingKit(int width, int height) {
    this("", width, height);
  }
  
  /** Constructor to create a window with the specified
   * title, width and height. A BufferedImage 
   * object called bufferedImage of the same size as the window is 
   * created internally. The window is cleared and the contents of       
   * BufferedImage are displayed on the window each time repaint 
   * is called. The window is positioned in the center of the screen.    
   *      
   * @param title the title on window.
   * @param width the window width. 
   * @param height the window height.
   */
  public DrawingKit(String title, int width, int height) {
    window = new JFrame(title);
    bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    bufferedImageGraphics = bufferedImage.createGraphics();
    bufferedImageGraphics.setPaint(Color.black);
    drawingSheet = new JPanel() {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D myGraphics = (Graphics2D) g;
      myGraphics.drawImage(bufferedImage, 0, 0, this);
      }
    }; 

    // display the coordinates of the mouse when it is clicked on the console
    addMouseEventHandler();

    window.setContentPane(drawingSheet);
    drawingSheet.setOpaque(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(width, height);
    window.setResizable(true);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    window.setLocation((screenSize.width - width)/2, (screenSize.height - height)/2);
    window.setVisible(true);
  }

   /** Method to display the (x, y) coordinates of a
   * point on the window when it is clicked  
   * with the mouse.
   * 
   */
  public void addMouseEventHandler() {
    drawingSheet.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        Point p = drawingSheet.getMousePosition();
        System.out.println("(" +p.getX() +", " +p.getY() +")");
	  }
    });
  }
  
  /** Method to draw a graphics shape on the window.
  *   
  * @param obj graphics shape to draw.
  */
  public void draw(Shape obj) { 
    bufferedImageGraphics.draw(obj);
    window.repaint();
  }

  /** Method to draw picture with specified width and height 
  * and display it in window at (x, y).
  *
  * @param picture the picture object to draw.
  * @param x the x-coordinate of the top left corner of picture.
  * @param y the y-coordinate of the top left corner of picture.
  * @param width the picture width
  * @param height the picture height 
  */
  public void drawPicture(BufferedImage picture, int x, int y, int width, int height) {
    bufferedImageGraphics.drawImage(picture, x, y, width, height, null);
    window.repaint();	
  }  

  /** Method to display a BufferedImage object
  * in window at a specified location.
  *
  * @param picture is a BufferedImage object.
  * @param x the picture is positioned at this x-coordinate.
  * @param y the picture is positioned at this y-coordinate.
  */	
  public void drawPicture(BufferedImage picture, int x, int y) {
    bufferedImageGraphics.drawImage(picture, x, y, picture.getWidth(), picture.getHeight(), null);
    window.repaint();	
  }

  /** Method to draw picture from given file on window.
  *
  * @param s the name of the file containing the picture.
  */	
  public void drawPicture(String s) {
    File filename = new File(s);
    BufferedImage picture = null;
    try {
      picture = ImageIO.read(filename); 
    } catch (IOException e) {    
      System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
       System.exit(1);
    }
    bufferedImageGraphics.drawImage(picture, 0, 0, picture.getWidth(), picture.getHeight(), null);
    window.repaint();	
  }

  /** Method to write text at the specified location
  * (x, y) in the window.
  *
  * @param s the text to be written.
  * @param x the x-coordinate of the starting position of the text.
  * @param y the y-coordinate of the starting position of the text.
  */	
  public void drawString(String s, float x, float y) {
    bufferedImageGraphics.drawString(s, x, y);
    window.repaint();
  }

  /** Method to fill an object with a color.
  *
  * @param obj the graphics object to be filled.
  */
  public void fill(Shape obj) {
    bufferedImageGraphics.fill(obj);
    window.repaint();
  }

  /** Method to return the graphics context associated 
  * with the window.
  *
  * @return the graphics context associated with 
  * the BufferedImage object called bufferedImage on 
  * which all the drawing is done before it is rendered
  * to the screen.
  */
  public Graphics2D getGraphics() {
    return bufferedImageGraphics;
  }
  
  /** Method to load picture from file into memory. This will 
  * store the picture in memory as type BufferedImage.
  *
  * @param f the name of the file from which to load 
  * the picture.
  * @return the reference to the BufferedImage object.
  */
  public  BufferedImage loadPicture(String f) {
    File filename = new File(f);
    BufferedImage picture = null;
    try {
      picture = ImageIO.read(filename);
    } catch (IOException e) {
      System.out.println("An error has occurred while reading image file. Check that file exists and is in the correct directory.");
       System.exit(1);
    }
    return picture;
  }

  /** Method to change the font.
  *
  * @param f the new font.
  */
  public void setFont(Font f) {
    bufferedImageGraphics.setFont(f);
  }

  /** Method to change the color.
  *
  * @param c the new color.
  */
  public void setPaint(Color c) {
    bufferedImageGraphics.setPaint(c);
  }

  /** Method to change the line thickness.
  *
  * @param s the new stroke.
  */
  public void setStroke(BasicStroke s) {
    bufferedImageGraphics.setStroke(s);
  }	
}
