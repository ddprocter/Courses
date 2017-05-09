package JavaComprehensive;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Crystals {

  // constants
  public static final int WIDTH = 20;
  public static final int HEIGHT = 20;
  public static final int INITIAL = 0;
  public static final int RED = 1;
  public static final int YELLOW = 3;
  public static final int CHECKED = 4;
	
  private int turn = RED;	// to track which player should play next

  private int[][] playerGrid; 	// to record each player's move
  private int[][] shadowGrid; 	// to keep track of which atoms have been FOUND
  private int[][] crystalGrid; 	// to extract a single crystal from playerGrid
	
  private int row, column; 	      	// position of most recently added atom
  private int lowX, lowY, highX, highY; // corner coordinates of current crystal
  private int player1Score = 0;
  private int player2Score = 0;
	
  // GUI related fields
  private JButton[] buttonArray;
  private JTextField scoreField1;
  private JTextField scoreField2;
  private JLabel labelRED;   		// Label "Red" on GUI
  private JLabel labelYELLOW;   	// Label "Yellow" on GUI
  private JLabel labelTurn;   		// Label displays whose turn is next
	
  Crystals() {
    createGUIAndPlay();
  }
	
  private void createGUIAndPlay() {
    final JFrame f = new JFrame();
    // create the panels
    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel buttonPanel = new JPanel(new GridLayout(WIDTH, HEIGHT));
    JPanel labelPanel = new JPanel();
		
    // represents the 2D grid of buttons on the GUI
    buttonArray = new JButton[WIDTH * HEIGHT];
		
    // stores the positions of atoms in both player's crystals
    playerGrid = new int[WIDTH][HEIGHT];
    // shadowGrid keeps track of which atoms have been found 
    shadowGrid = new int[WIDTH][HEIGHT];
    // used to store a crystal to determine if it is a perfect crystal
    crystalGrid = new int[WIDTH][HEIGHT];
		

    JButton endGameButton = new JButton("End Game");
    labelRED = new JLabel("Red");
    scoreField1 = new JTextField(3);
    scoreField1.setEditable(false);
    labelYELLOW = new JLabel("Yellow");
    labelTurn = new JLabel("Red's turn", Label.LEFT);
    Dimension dim = labelTurn.getPreferredSize();
    labelTurn.setPreferredSize(new Dimension(dim.width+100, dim.height+10));
    scoreField2 = new JTextField(3);
    scoreField2.setEditable(false);
    scoreField1.setText("0");
    scoreField2.setText("0");

    // create the buttons on which players will make their moves
    for (int i = 0; i < HEIGHT * WIDTH; i++) {
      buttonArray[i] = new JButton();
      buttonPanel.add(buttonArray[i]);		
    }
	
    // add the action listener to the buttons
    for (int i = 0; i < HEIGHT * WIDTH; i++) {
      buttonArray[i].setActionCommand(Integer.toString(i));
      buttonArray[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton button = (JButton) e.getSource();
          if (turn == RED)
            button.setBackground(Color.red);
          else
            button.setBackground(Color.yellow);
          button.setEnabled(false);
          int buttonIndex = Integer.valueOf(button.getActionCommand());
          row = buttonIndex/WIDTH;
          column = buttonIndex % WIDTH;
          playMove();
          updateGUI();
         }
       });
    }
		
    endGameButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String s;
        if (player1Score > player2Score)
          s = "RED wins the game";
        else if(player1Score < player2Score)
          s = "YELLOW wins the game";
        else
          s = "Game is a draw";
        JOptionPane.showMessageDialog(f, s, "Game Over", JOptionPane.PLAIN_MESSAGE);
        System.exit(1);
       }
    });

    labelPanel.add(endGameButton);
    labelPanel.add(labelRED);
    labelPanel.add(scoreField1);
    labelPanel.add(labelYELLOW);
    labelPanel.add(scoreField2);
    labelPanel.add(labelTurn);
    topPanel.add(labelPanel, BorderLayout.NORTH);
    topPanel.add(buttonPanel, BorderLayout.CENTER);
    f.add(topPanel);
    f.setSize(500, 500);
    f.setTitle("Crystals");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
	
  // displays the score of the last player to move
  // and which player is to move next
  private void updateGUI() {
    if (turn == YELLOW) {
      scoreField1.setText(Integer.toString(player1Score));
      labelTurn.setText("Yellow's turn");		
    } else {
      scoreField2.setText(Integer.toString(player2Score));
      labelTurn.setText("Red's turn");
    }
  }
	
  // get the score for the current player and change turn to next player
  private void playMove() {
    playerGrid[row][column] = turn;
      // player1's turn
      if(turn == RED) {
        // get player1's  score
        player1Score = getScore();
			
        // player 2 plays next
        turn = YELLOW;		
      } else { 
        // player 2's turn; get player2's score
	player2Score = getScore();
			
	// player 1 plays next
	turn = RED;
       }
    }
	
  // this method finds the crystal that contains the
  // atom at row r column c and stores it in temporaryGrid
  private void findCrystal(int r, int c) {
    initialize(); // erase crystalGrid
    ArrayList atomsArray = new ArrayList(); // store that atom found in this array
    Point p1 = new Point(r, c);
    atomsArray.add(p1); 
    updateGrids(r, c); // used to build the crystal
	
	
    while ( !atomsArray.isEmpty()) {
      Point p = (Point) atomsArray.remove(0);
      int row = (int) p.getX();
      int column = (int) p.getY();
		
      // check this atom's north, south, east and west edges  for neighbors
      for (Direction dir : Direction.values()) {
        if ( (p = dir.index(row, column)) != null) {	
          if (playerGrid[(int)p.getX()][(int)p.getY()] == turn && shadowGrid[(int)p.getX()][(int)p.getY()] != CHECKED ) {
            atomsArray.add(p);
            updateGrids( (int) p.getX(), (int) p.getY());			
           }
         }
       }
    }
	
    // if crystal is not at origin, move it there 
    if ( !(lowX == 0 && lowY == 0))
      moveToOrigin();
  }

  private void initialize() {
    // erase crystalGrid to store a new crystal
    highX = highY = Integer.MIN_VALUE;
    lowX = lowY = Integer.MAX_VALUE;
    for (int row = 0; row < HEIGHT; row++)
      for (int column = 0; column < WIDTH; column++) {
        crystalGrid[row][column] = INITIAL;
      }
  }

  //to simplify the check for a perfect crystal 
  private void moveToOrigin() {
    // shift the crystal stored in temporary grid at (lowX, lowY) to the origin (0, 0)
    for (int row = 0; row <= highX - lowX; row++) {
      for (int column = 0; column <= highY - lowY; column++) {
        if (crystalGrid[row+lowX][column+lowY] == turn) {
          crystalGrid[row][column] = turn;
          crystalGrid[row+lowX][column+lowY] = INITIAL;
         }
       }	
    }
  }

  private void updateGrids(int row, int column) {
    // mark atom as seen on shadowGrid
    shadowGrid[row][column] = CHECKED;

    // mark atom on temporaryGrid to build crystal
    crystalGrid[row][column] = turn;

    // update crystal's lower and upper coordinates
    lowX = Math.min(lowX, row);
    highX = Math.max(highX, row);
    lowY = Math.min(lowY, column);
    highY = Math.max(highY, column);
  }

  // this method finds all of this player's valid crystals and 
  // returns the total number of atoms as the score
  private int getScore() {	
    int score = 0;
	
    // initialize shadowGrid
    for (int row = 0; row < HEIGHT; row++)
      for (int column = 0; column < WIDTH; column++) {
        shadowGrid[row][column] = INITIAL; 
      }

    // get all of this player's crystals
    for (int row = 0; row < WIDTH; row++) {
      for (int column = 0; column < HEIGHT; column++)  {
        if (playerGrid[row][column] == turn && shadowGrid[row][column] != CHECKED) {
 
          // find a crystal and store it crystalGrid
          findCrystal(row, column); 
				
          // if a perfect crystal is found, increment score
          if( Crystal.isPerfect(crystalGrid, highY-lowY, highX-lowX, turn)) {	
            score += Crystal.getNumberOfAtoms(); 
          }
         }
       }
    }
	
    return score;
}

  public static void main(String[] args) {
    new Crystals();		
  }
}