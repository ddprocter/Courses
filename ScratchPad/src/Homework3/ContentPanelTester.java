package Homework3;
import java.awt.Container;
import javax.swing.*;

public class ContentPanelTester {

		private JFrame window;
		
		public ContentPanelTester(){
			
			window = new JFrame();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setSize(600, 600);
			window.setTitle("Content Panel Tester");
			window.setVisible(true);
			
			JPanel panel = new JPanel();
			Container contentPane = window.getContentPane();
			contentPane.add(panel);
			
			
			
		}

		public static void main(String[] args) {
			new ContentPanelTester();

		}

	
	


}
