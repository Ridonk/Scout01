package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BaseFrame extends JFrame {
	
	BaseFrame() {
		
		// Set title of the window
		super("Scout V2 - By Ridonk");
		
		// Define local variables
		int h = 520;
		int w = 425;
		
		// Handle destruction of the window
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				BaseFrame.this.setVisible(false);
				BaseFrame.this.dispose();
			}
		});
		
		// Layout and frame items
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(w, h);
		
		// Create the items for the basic panel and add them to the Tabbed Pane
		
		this.add(new BuildTabbedPane());
	}
	
}