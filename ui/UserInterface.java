package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import calc.Scout;
import calc.unit;
import calc.unitDB;
import ui.ResultsWindow;

public class UserInterface {

	private JFrame frmScout;
	private JFrame resultsFrame;
	private JTextField lordPower;
	private JTextField lordCastleLevel;
	protected double version = 0.07;
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
		frmScout = new JFrame();
		frmScout.setVisible(true);
		Color background = new Color(255, 255, 255); // White
		Color foreground = new Color(30, 144, 255); // Dodger Blue
		resultsFrame = new JFrame();
		resultsFrame.setVisible(true);
		resultsFrame.setBounds(100, 100, 360, 380);
		resultsFrame.setLocationRelativeTo(null);
		resultsFrame.setResizable(false);
		resultsFrame.setBackground(background);
		resultsFrame.setForeground(foreground);
		ResultsWindow resultsWinbox = new ResultsWindow(resultsFrame);
		Color backgroundTextField = new Color(204,255,255);
		frmScout.setForeground(foreground);
		frmScout.getContentPane().setForeground(foreground);
		frmScout.setBackground(background);
		frmScout.setResizable(false);
		frmScout.setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/ui/nte.gif")));
		frmScout.setTitle("Scout");
		frmScout.getContentPane().setBackground(Color.WHITE);
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
		lordPower.setBackground(backgroundTextField);
		frmScout.getContentPane().add(lordPower);
		lordPower.setColumns(10);
		
		lordCastleLevel = new JTextField();
		lordCastleLevel.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.NORTH, lordCastleLevel, 5, SpringLayout.SOUTH, lordPower);
		springLayout.putConstraint(SpringLayout.WEST, lordCastleLevel, 190, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordCastleLevel, -15, SpringLayout.EAST, frmScout.getContentPane());
		lordCastleLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lordCastleLevel.setBackground(backgroundTextField);
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
				Scout masterScout = new Scout(Double.parseDouble(lordPower.getText()),Double.parseDouble(lordCastleLevel.getText()));	
				initUnits(masterScout, resultsWinbox);
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
		
		JMenuItem mntmClose = new JMenuItem("Close");
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
						+ "Build date: Jan 22 2016\n"
						+ "Scout is open source. If used for any applications credit must be given.\n"
						+ "Released under GNU General Public License, V3");
			}
		});
		mnHelp.add(mntmAbout);
	}
	
	private void initUnits(Scout masterScout, ResultsWindow resultsWinbox) {
		
		unitDB unitDB = new unitDB();
		
		// Create infantry units
		unitDB.setMilitia(new unit(1, 1, 6, 14, 8, 8, 10.46, 1, 0.21, 1.0));
		unitDB.Militia.setName("Militia");
		unitDB.setInfantry(new unit(2, 4, 8, 19, 9, 8, 10.46, 1, 0.42, 1.4));
		unitDB.Infantry.setName("Infantry");
		unitDB.setSpearman(new unit(3, 7, 22, 13, 6, 9, 11.46, 1, 0.63, 1.9));
		unitDB.Spearman.setName("Spearman");
		unitDB.setSwordsman(new unit(4, 10, 15, 35, 15, 8, 11.46, 1, 0.83, 2.5));
		unitDB.Swordsman.setName("Swordsman");
		unitDB.setPikeman(new unit(5, 13, 38, 22, 15, 9, 13.07, 1, 1.04, 3.2));
		unitDB.Pikeman.setName("Pikeman");
		unitDB.setNobleSwordsman(new unit(6, 16, 24, 56, 22, 8, 13.07, 1, 1.25, 4.0));
		unitDB.NobleSwordsman.setName("Noble Swordsman");
		unitDB.setGuard(new unit(7, 19, 29, 68, 26, 8, 14.07, 1, 1.46, 4.9));
		unitDB.Guard.setName("Guard");
		unitDB.setHeavyPikeman(new unit(8, 22, 70, 41, 15, 9, 14.38, 1, 1.67, 5.9));
		unitDB.HeavyPikeman.setName("Heavy Pikeman");
		unitDB.setHalberdier(new unit(9, 26, 84, 49, 18, 9, 15.68, 1, 1.88, 7.0));
		unitDB.Halberdier.setName("Halberdier");
		unitDB.setBerserker(new unit(10, 30, 49, 114, 42, 8, 15.68, 1, 2.08, 8.2));
		unitDB.Berserker.setName("Berserker");
		
		// Create archer units
		unitDB.setShortbowman(new unit(1, 1, 8, 6, 3, 8, 10.46, 5, 0.21, 1.0));
		unitDB.Shortbowman.setName("Shortbowman");
		unitDB.setLongbowman(new unit(2, 4, 11, 8, 3, 8, 10.46, 5, 0.42, 1.4));
		unitDB.Longbowman.setName("Longbowman");
		unitDB.setCrossbowman(new unit(3, 7, 26, 13, 4, 8, 10.46, 8, 0.63, 1.9));
		unitDB.Crossbowman.setName("Crossbowman");
		unitDB.setArbalester(new unit(4, 10, 35, 17, 5, 8, 10.46, 8, 0.83, 2.5));
		unitDB.Arbalester.setName("Arbalester");
		unitDB.setEliteLongbowman(new unit(5, 13, 25, 19, 6, 8, 13.07, 5, 1.04, 3.2));
		unitDB.EliteLongbowman.setName("Elite Longbowman");
		unitDB.setArcherGuard(new unit(6, 16, 32, 24, 8, 8, 13.07, 5, 1.25, 4));
		unitDB.ArcherGuard.setName("Archer Guard");
		unitDB.setHeavyCrossbowman(new unit(7, 19, 68, 34, 10, 8, 13.07, 8, 1.46, 4.9));
		unitDB.HeavyCrossbowman.setName("Heavy Crossbowman");
		unitDB.setEagleArcher(new unit(8, 22, 47, 35, 11, 8, 14.38, 5, 1.67, 5.9));
		unitDB.EagleArcher.setName("Eagle Archer");
		unitDB.setWindlassman(new unit(9, 26, 98, 49, 13, 8, 14.38, 8, 1.88, 7.0));
		unitDB.Windlassman.setName("Windlassman");
		unitDB.setMarksman(new unit(10, 30, 65, 49, 15, 8, 15.68, 5, 2.08, 9.2));
		unitDB.Marksman.setName("Marksman");
		
		// Create cavalry units
		unitDB.setRider(new unit(1, 1, 11, 8, 4, 14, 7.84, 1, 0.21, 1.0));
		unitDB.Rider.setName("Rider");
		unitDB.setLightCavalry(new unit(2, 4, 15, 11, 4, 14, 7.84, 1, 0.42, 1.4));
		unitDB.LightCavalry.setName("Light Cavalry");
		unitDB.setHeavyCavalry(new unit(3, 7, 20, 15, 6, 14, 9.15, 1, 0.63, 1.9));
		unitDB.HeavyCavalry.setName("Heavy Cavalry");
		unitDB.setMountedArcher(new unit(4, 10, 32, 17, 7, 13, 9.15, 4, 0.83, 2.5));
		unitDB.MountedArcher.setName("Mounted Archer");
		unitDB.setCavalryShooter(new unit(5, 13, 41, 22, 9, 13, 10.46, 4, 1.04, 3.2));
		unitDB.CavalryShooter.setName("Cavalry Shooter");
		unitDB.setKnightsTemplar(new unit(6, 16, 44, 22, 9, 14, 10.46, 1, 1.25, 4.0));
		unitDB.KnightsTemplar.setName("Knights Templar");
		unitDB.setHeavyCArcher(new unit(7, 19, 63, 34, 13, 13, 11.76, 4, 1.46, 4.9));
		unitDB.HeavyCArcher.setName("Heavy Calvary Archer");
		unitDB.setRoyalKnight(new unit(8, 22, 64, 47, 15, 14, 11.76, 1, 1.67, 5.9));
		unitDB.RoyalKnight.setName("Royal Knight");
		unitDB.setStrikeArcher(new unit(9, 26, 91, 49, 18, 13, 13.07, 4, 1.88, 7.0));
		unitDB.StrikeArcher.setName("Strike Archer");
		unitDB.setDivineKnight(new unit(10, 30, 90, 65, 21, 14, 13.07, 1, 2.08, 8.2));
		unitDB.DivineKnight.setName("Divine Knight");
		
		// Create siege units
		unitDB.setBricole(new unit(1, 1, 20, 9, 5, 7, 16.99, 10, 0.21, 1.0));
		unitDB.Bricole.setName("Bricole");
		unitDB.setAssaultCart(new unit(2, 4, 9, 14, 8, 5, 26.14, 1, 0.42, 1.4));
		unitDB.AssaultCart.setName("Assault Cart");
		unitDB.setMangonel(new unit(3, 7, 38, 17, 7, 7, 18.30, 10, 0.63, 1.9));
		unitDB.Mangonel.setName("Mangonel");
		unitDB.setBatteringRam(new unit(4, 10, 17, 25, 13, 5, 27.45, 1, 0.83, 2.5));
		unitDB.BatteringRam.setName("Battering Ram");
		unitDB.setHeavyMangonel(new unit(5, 13, 64, 28, 11, 7, 19.61, 10, 1.04, 3.2));
		unitDB.HeavyMangonel.setName("Heavy Mangonel");
		unitDB.setDemolisher(new unit(6, 16, 28, 40, 19, 5, 28.75, 1, 1.25, 4.0));
		unitDB.Demolisher.setName("Demolisher");
		unitDB.setTrebuchet(new unit(7, 19, 98, 44, 16, 7, 20.91, 10, 1.46, 4.9));
		unitDB.Trebuchet.setName("Trebuchet");
		unitDB.setHeavyTrebuchet(new unit(8, 22, 118, 53, 19, 7, 20.91, 10, 1.67, 5.9));
		unitDB.HeavyTrebuchet.setName("Heavy Trebuchet");
		unitDB.setSiegeTower(new unit(9, 26, 49, 70, 32, 5, 31.37, 1, 1.88, 7.0));
		unitDB.SiegeTower.setName("Siege Tower");
		unitDB.setMightyTrebuchet(new unit(10, 30, 164, 73, 26, 7, 22.22, 10, 2.08, 8.2));
		unitDB.MightyTrebuchet.setName("Mighty Trebuchet");
		
		breakdownUnits(unitDB, masterScout, resultsWinbox);
		
	}
	
	private void breakdownUnits(unitDB unitDB, Scout masterScout, ResultsWindow resultsWinbox) {
		
		double maxTroopPow = masterScout.getOverPow() * Scout.troopPerc;
		double gatherPerc = 0.026;
		// Calculate estimated gathering troops (usually Bricoles or Assault Carts, assuming Bricoles as they're more efficient)
		double gatherTroop = ((maxTroopPow * gatherPerc) / unitDB.Bricole.getPower());
		double troopPow = (maxTroopPow - (unitDB.Bricole.getPower() * gatherTroop));
		double quartPow = (troopPow * 1.1) / 4;
		unit unitArr[] = new unit[8];
		if (masterScout.castleLevel <= 3) {
			
			// What are they?
			int troopLevel = 1;
			unitArr[0] = unitDB.Militia;
			unitArr[1] = unitDB.Shortbowman;
			unitArr[2] = unitDB.Rider;
			unitArr[3] = unitDB.Bricole;
			unitArr[4] = null;
			unitArr[5] = null;
			unitArr[6] = null;
			unitArr[7] = null;
			// How many of each are there?
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			// How many are there total?
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// int totalTroops = unitDB.Militia.getCount() + unitDB.Shortbowman.getCount() + unitDB.Rider.getCount() + unitDB.Bricole.getCount() - (int)gatherTroop;
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
			
		}
		
		else if (masterScout.castleLevel <= 6) {
			
			// Infantry, Longbowman, Light Cavalry, Assault Cart
			int troopLevel = 2;
			unitArr[0] = unitDB.Militia;
			unitArr[1] = unitDB.Shortbowman;
			unitArr[2] = null;
			unitArr[3] = unitDB.Bricole;
			unitArr[4] = unitDB.Infantry;
			unitArr[5] = unitDB.Longbowman;
			unitArr[6] = unitDB.LightCavalry;
			unitArr[7] = unitDB.AssaultCart;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 9) {
			
			// Spearman, Crossbowman, Heavy Cavalry, Mangonel
			int troopLevel = 3;
			unitArr[0] = unitDB.Infantry;
			unitArr[1] = unitDB.Longbowman;
			unitArr[2] = null;
			unitArr[3] = unitDB.AssaultCart;
			unitArr[4] = unitDB.Spearman;
			unitArr[5] = unitDB.Crossbowman;
			unitArr[6] = unitDB.HeavyCavalry;
			unitArr[7] = unitDB.Mangonel;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 12) {

			// Swordsman, Arbalester, Mounted Archer, Battering Ram
			int troopLevel = 4;
			unitArr[0] = unitDB.Spearman;
			unitArr[1] = unitDB.Longbowman;
			unitArr[2] = unitDB.HeavyCavalry;
			unitArr[3] = unitDB.Mangonel;
			unitArr[4] = unitDB.Swordsman;
			unitArr[5] = unitDB.Arbalester;
			unitArr[6] = unitDB.MountedArcher;
			unitArr[7] = unitDB.BatteringRam;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 15) {

			// Pikeman, Elite Longbowman, Cavalry Shooter, Heavy Mangonel
			int troopLevel = 5;
			unitArr[0] = unitDB.Swordsman;
			unitArr[1] = unitDB.Arbalester;
			unitArr[2] = unitDB.HeavyCavalry;
			unitArr[3] = unitDB.BatteringRam;
			unitArr[4] = unitDB.Pikeman;
			unitArr[5] = unitDB.EliteLongbowman;
			unitArr[6] = unitDB.CavalryShooter;
			unitArr[7] = unitDB.HeavyMangonel;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 18) {

			// Noble Swordsman, Archer Guard, Knights Templar, Demolisher
			int troopLevel = 6;
			unitArr[0] = unitDB.Pikeman;
			unitArr[1] = unitDB.Arbalester;
			unitArr[2] = unitDB.CavalryShooter;
			unitArr[3] = unitDB.HeavyMangonel;
			unitArr[4] = unitDB.NobleSwordsman;
			unitArr[5] = unitDB.ArcherGuard;
			unitArr[6] = unitDB.KnightsTemplar;
			unitArr[7] = unitDB.Demolisher;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 21) {

			// Guard, Heavy Crossbowman, Heavy Cavalry Archer, Trebuchet
			int troopLevel = 7;
			unitArr[0] = unitDB.Pikeman;
			unitArr[1] = unitDB.ArcherGuard;
			unitArr[2] = unitDB.KnightsTemplar;
			unitArr[3] = unitDB.Demolisher;
			unitArr[4] = unitDB.Guard;
			unitArr[5] = unitDB.HeavyCrossbowman;
			unitArr[6] = unitDB.HeavyCArcher;
			unitArr[7] = unitDB.Trebuchet;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 25) {

			// Heavy Pikeman, Eagle Archer, Royal Knight, Heavy Trebuchet
			int troopLevel = 8;
			unitArr[0] = unitDB.Guard;
			unitArr[1] = unitDB.HeavyCrossbowman;
			unitArr[2] = unitDB.HeavyCArcher;
			unitArr[3] = unitDB.Demolisher;
			unitArr[4] = unitDB.HeavyPikeman;
			unitArr[5] = unitDB.EagleArcher;
			unitArr[6] = unitDB.RoyalKnight;
			unitArr[7] = unitDB.HeavyTrebuchet;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 29) {

			// Halberdier, Windlassman, Strike Archer, Siege Tower
			int troopLevel = 9;
			unitArr[0] = unitDB.Guard;
			unitArr[1] = unitDB.EagleArcher;
			unitArr[2] = unitDB.RoyalKnight;
			unitArr[3] = unitDB.HeavyTrebuchet;
			unitArr[4] = unitDB.Halberdier;
			unitArr[5] = unitDB.Windlassman;
			unitArr[6] = unitDB.StrikeArcher;
			unitArr[7] = unitDB.SiegeTower;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
		else if (masterScout.castleLevel <= 30) {

			// Berserker, Marksman, Divine Knight, Mighty Trebuchet
			int troopLevel = 10;
			unitArr[0] = unitDB.Halberdier;
			unitArr[1] = unitDB.Windlassman;
			unitArr[2] = unitDB.StrikeArcher;
			unitArr[3] = unitDB.SiegeTower;
			unitArr[4] = unitDB.Berserker;
			unitArr[5] = unitDB.Marksman;
			unitArr[6] = unitDB.DivineKnight;
			unitArr[7] = unitDB.MightyTrebuchet;
			quartPow = quartPow / 2;
			unitArr[0].setCount((int)(quartPow / unitArr[0].getPower()));
			unitArr[1].setCount((int)(quartPow / unitArr[1].getPower()));
			unitArr[2].setCount((int)(quartPow / unitArr[2].getPower()));
			unitArr[3].setCount((int)(quartPow / unitArr[3].getPower()));
			unitArr[4].setCount((int)(quartPow / unitArr[4].getPower()));
			unitArr[5].setCount((int)(quartPow / unitArr[5].getPower()));
			unitArr[6].setCount((int)(quartPow / unitArr[6].getPower()));
			unitArr[7].setCount((int)(quartPow / unitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (unitArr[i] != null) totalTroops = totalTroops + unitArr[i].getCount();
			// Tell the user the number of troops of each type.
			String value = printTroops(unitArr, troopLevel, totalTroops, (int)maxTroopPow, (int)gatherTroop);
			resultsWinbox.setResultsBox(value);
		}
		
	}
	
	private String printTroops(unit unitArr[], int troopLevel, int maxTroopCount, int maxTroopPow, int gatherTroop) {
		String value;
		if (unitArr[4] != null && unitArr[2] != null) value = ("The lord's estimated troop power is " + maxTroopPow + "\n"
					+ "The lord should have an estimated total of " + maxTroopCount + " troops" + "\n" + "at their disposal.\n"
					+ "Of these troops, there is an estimated total of " + gatherTroop + "\ngathering troops in "
					+ "their army.\n" 
					+ unitArr[0].count + " Level " + unitArr[0].level + " " + unitArr[0].getName() + "\n" 
					+ unitArr[1].count + " Level " + unitArr[1].level + " " + unitArr[1].getName() + "\n"
					+ unitArr[2].count + " Level " + unitArr[2].level + " " + unitArr[2].getName() + "\n" 
					+ unitArr[3].count + " Level " + unitArr[3].level + " " + unitArr[3].getName() + "\n"
					+ unitArr[4].count + " Level " + unitArr[4].level + " " + unitArr[4].getName() + "\n" 
					+ unitArr[5].count + " Level " + unitArr[5].level + " " + unitArr[5].getName() + "\n"
					+ unitArr[6].count + " Level " + unitArr[6].level + " " + unitArr[6].getName() + "\n" 
					+ unitArr[7].count + " Level " + unitArr[7].level + " " + unitArr[7].getName() + "\n\n");
		else if (unitArr[2] == null) value = ("The lord's estimated troop power is " + maxTroopPow + "\n"
				+ "The lord should have an estimated total of " + maxTroopCount + " troops" + "\n" + "at their disposal.\n"
				+ "Of these troops, there is an estimated total of " + gatherTroop + "\ngathering troops in "
				+ "their army.\n" 
				+ unitArr[0].count + " Level " + unitArr[0].level + " " + unitArr[0].getName() + "\n" 
				+ unitArr[1].count + " Level " + unitArr[1].level + " " + unitArr[1].getName() + "\n" 
				+ unitArr[3].count + " Level " + unitArr[3].level + " " + unitArr[3].getName() + "\n"
				+ unitArr[4].count + " Level " + unitArr[4].level + " " + unitArr[4].getName() + "\n" 
				+ unitArr[5].count + " Level " + unitArr[5].level + " " + unitArr[5].getName() + "\n"
				+ unitArr[6].count + " Level " + unitArr[6].level + " " + unitArr[6].getName() + "\n" 
				+ unitArr[7].count + " Level " + unitArr[7].level + " " + unitArr[7].getName() + "\n\n");
		else value = ("The lord's estimated troop power is " + maxTroopPow + "\n"
				+ "The lord should have an estimated total of " + maxTroopCount + " troops" + "\n" + "at their disposal.\n"
				+ "Of these troops, there is an estimated total of " + gatherTroop + "\ngathering troops in "
				+ "their army.\n" 
				+ unitArr[0].count + " Level " + unitArr[0].level + " " + unitArr[0].getName() + "\n" 
				+ unitArr[1].count + " Level " + unitArr[1].level + " " + unitArr[1].getName() + "\n"
				+ unitArr[2].count + " Level " + unitArr[2].level + " " + unitArr[2].getName() + "\n" 
				+ unitArr[3].count + " Level " + unitArr[3].level + " " + unitArr[3].getName() + "\n\n");
		
		return value;
		
	}
}