package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings({ "unused", "serial" })
public class BuildAdvPanel extends JPanel {
	// Theme fonts
	private static Font f = new Font(Font.MONOSPACED, Font.BOLD, 12);
	
	String debug = "";
	int h = 450;
	int w = 400;
	
	BuildAdvPanel() {
		setOpaque(false);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(w, h));
		setFont(f);
		
		JLabel temp = new JLabel("Under construction.");
		this.add(temp);
	}
	
}