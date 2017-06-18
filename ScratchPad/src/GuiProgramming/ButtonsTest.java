package GuiProgramming;

import java.awt.Dimension;

import javax.swing.*;

public class ButtonsTest extends JPanel {
	
	public ButtonsTest() {
	        setLayout(new java.awt.GridLayout(4, 4));
	        for (int i = 0; i < 16; ++i) {
	            JButton b = new JButton(String.valueOf(i));
	            b.setName(Integer.toString(i));
	            b.addActionListener(new java.awt.event.ActionListener() {
	                public void actionPerformed(java.awt.event.ActionEvent e) {
	                    System.out.println("Button " + b.getName() + " was pressed");
	                }
	                
	            });
	            add(b);
	        }
	  }

	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable(){
	            @Override
	            public void run(){
	                JFrame frame = new JFrame();
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setSize(new Dimension(300, 300));
	                frame.add(new ButtonsTest());
	                frame.setVisible(true);
	            }
	        });
	    }

}
