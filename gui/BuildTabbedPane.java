package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class BuildTabbedPane extends JTabbedPane {
	
	BuildTabbedPane() {
		this.addTab("Basic",new BuildBasicPanel());
		this.setMnemonicAt(0, KeyEvent.VK_1);
		
		this.addTab("Advanced",new BuildAdvPanel());
		this.setMnemonicAt(1, KeyEvent.VK_2);
	}
	
}