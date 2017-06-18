package lifetracker;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class LeftJustifiedPanelContainer extends JPanel {
		
	public LeftJustifiedPanelContainer (String labelTxt){
		super(new FlowLayout(FlowLayout.LEADING));
		JLabel label = new JLabel(labelTxt);
		this.add(label);
		this.setMaximumSize(new Dimension(1000,20));
		this.setMinimumSize(new Dimension(1000,20));	
	}
	
	public LeftJustifiedPanelContainer(JLabel label){
		super(new FlowLayout(FlowLayout.LEADING));
		this.add(label);
		this.setMaximumSize(new Dimension(1000,20));
		this.setMinimumSize(new Dimension(1000,20));	
	}
	
	public LeftJustifiedPanelContainer(JPanel panel){
		super(new FlowLayout(FlowLayout.LEADING));
		this.add(panel);
		this.setMaximumSize(new Dimension(1000,20));
		this.setMinimumSize(new Dimension(1000,20));	
	}

}
