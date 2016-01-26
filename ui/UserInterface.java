package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import calc.*;

public class UserInterface {

	private JFrame frmScout;
	private ResultsWindow resultsWinbox;
	private JTextField lordPower;
	private JTextField lordCastleLevel;
	protected double version = 0.1;
	protected int build = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmScout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Main JFrame
		frmScout = new JFrame();
		Color background = Color.DARK_GRAY; // Dark Gray
		Color foreground = new Color(255, 69, 0); // Red/orange
		frmScout.getContentPane().setForeground(foreground);
		frmScout.getContentPane().setBackground(background);
		frmScout.setResizable(false);
		frmScout.setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/ui/nte.gif")));
		frmScout.setTitle("Scout");
		frmScout.getContentPane().setBackground(Color.DARK_GRAY);
		frmScout.setBounds(100, 100, 360, 160);
		frmScout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmScout.getContentPane().setLayout(springLayout);
		
		lordPower = new JTextField();
		lordPower.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.NORTH, lordPower, 15, SpringLayout.NORTH, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lordPower, 190, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordPower, -15, SpringLayout.EAST, frmScout.getContentPane());
		lordPower.setFont(new Font("Tahoma", Font.BOLD, 11));
		lordPower.setBackground(background);
		frmScout.getContentPane().add(lordPower);
		lordPower.setColumns(10);
		
		lordCastleLevel = new JTextField();
		lordCastleLevel.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.NORTH, lordCastleLevel, 5, SpringLayout.SOUTH, lordPower);
		springLayout.putConstraint(SpringLayout.WEST, lordCastleLevel, 190, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordCastleLevel, -15, SpringLayout.EAST, frmScout.getContentPane());
		lordCastleLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lordCastleLevel.setBackground(background);
		lordCastleLevel.setColumns(10);
		frmScout.getContentPane().add(lordCastleLevel);
		
		JLabel labelLordPower = new JLabel("Enter the Lord's Power");
		labelLordPower.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelLordPower.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.NORTH, labelLordPower, 3, SpringLayout.NORTH, lordPower);
		springLayout.putConstraint(SpringLayout.WEST, labelLordPower, 15, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, labelLordPower, -15, SpringLayout.WEST, lordPower);
		frmScout.getContentPane().add(labelLordPower);
		
		JLabel labelLordCastleLevel = new JLabel("Enter the Lord's Castle Level");
		labelLordCastleLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelLordCastleLevel.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.NORTH, labelLordCastleLevel, 3, SpringLayout.NORTH, lordCastleLevel);
		springLayout.putConstraint(SpringLayout.WEST, labelLordCastleLevel, 15, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, labelLordCastleLevel, -15, SpringLayout.WEST, lordCastleLevel);
		frmScout.getContentPane().add(labelLordCastleLevel);
		
		JButton btnCalculate = new JButton("Calculate");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCalculate, -15, SpringLayout.SOUTH, frmScout.getContentPane());
		btnCalculate.setBackground(background);
		btnCalculate.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.WEST, btnCalculate, 190, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnCalculate, 5, SpringLayout.SOUTH, lordCastleLevel);
		springLayout.putConstraint(SpringLayout.EAST, btnCalculate, -15, SpringLayout.EAST, frmScout.getContentPane());
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((lordPower.getText()).isEmpty() == true || (lordCastleLevel.getText()).isEmpty() == true) {
					JOptionPane.showMessageDialog(frmScout, "The lord power and castle level must be entered before anything can be calculated.");
				}
				else {
					// Results window
					Scout masterScout = new Scout(Double.parseDouble(lordPower.getText()),Double.parseDouble(lordCastleLevel.getText()));
					unitDB unitDB = new unitDB();
					if (resultsWinbox == null) resultsWinbox = new ResultsWindow();
					unitDB.initUnits(masterScout, unitDB, resultsWinbox);
				}
			}
		});
		frmScout.getContentPane().add(btnCalculate);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(background);
		frmScout.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(background);
		mnFile.setForeground(foreground);
		menuBar.add(mnFile);
		
		JMenuItem mntmClose = new JMenuItem("Exit");
		mntmClose.setBackground(background);
		mntmClose.setForeground(foreground);
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmClose);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setBackground(background);
		mnHelp.setForeground(foreground);
		menuBar.add(mnHelp);
		
		JMenuItem mntmHowToUse = new JMenuItem("How to use");
		mntmHowToUse.setBackground(background);
		mntmHowToUse.setForeground(foreground);
		mntmHowToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmScout, "Simply put the lord power and castle level of your target in and click"
						+ " calculate. \n\nIf you find any bugs please report them to Ridonk in Kingdom 850.");
			}
		});
		mnHelp.add(mntmHowToUse);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setBackground(background);
		mntmAbout.setForeground(foreground);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmScout, ""
						+ "Scout is a program written by George Dunbar (AKA Ridonk in Kingdom 850)\n"
						+ "Version: " + version + " Build: " + build +"\n"
						+ "Build date: Jan 25 2016\n"
						+ "Scout is open source. If used for any applications credit must be given.\n"
						+ "Released under GNU General Public License, V3");
			}
		});
		mnHelp.add(mntmAbout);
	}
}