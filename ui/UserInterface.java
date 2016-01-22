package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
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

public class UserInterface {

	private JFrame frmScout;
	private JTextField lordPower;
	private JTextField lordCastleLevel;
	protected double version = 0.05;
	protected int build = 1;

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
		Color background = new Color(255, 255, 255);
		Color foreground = new Color(30, 144, 255);
		Color backgroundTextField = new Color(204,255,255);
		frmScout.setForeground(foreground);
		frmScout.getContentPane().setForeground(foreground);
		frmScout.setBackground(background);
		frmScout.setResizable(false);
		frmScout.setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/ui/nte.gif")));
		frmScout.setTitle("Scout");
		frmScout.getContentPane().setBackground(Color.WHITE);
		frmScout.setBounds(100, 100, 360, 370);
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
		
		JTextPane lordTroopBreakdown = new JTextPane();
		lordTroopBreakdown.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.WEST, lordTroopBreakdown, 15, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lordTroopBreakdown, -15, SpringLayout.SOUTH, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordTroopBreakdown, -15, SpringLayout.EAST, frmScout.getContentPane());
		frmScout.getContentPane().add(lordTroopBreakdown);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(foreground);
		springLayout.putConstraint(SpringLayout.WEST, btnCalculate, 190, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lordTroopBreakdown, 15, SpringLayout.SOUTH, btnCalculate);
		springLayout.putConstraint(SpringLayout.NORTH, btnCalculate, 5, SpringLayout.SOUTH, lordCastleLevel);
		springLayout.putConstraint(SpringLayout.EAST, btnCalculate, -15, SpringLayout.EAST, frmScout.getContentPane());
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scout masterScout = new Scout(Double.parseDouble(lordPower.getText()),Double.parseDouble(lordCastleLevel.getText()));	
				initUnits(masterScout, lordTroopBreakdown);
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
						+ "Version: " + version + "Build: " + build +"\n"
						+ "Build date: Jan 20 2016\n"
						+ "Scout is open source. If used for any applications credit must be given.\n"
						+ "Released under GNU General Public License, V3");
			}
		});
		mnHelp.add(mntmAbout);
	}
	
	private void initUnits(Scout masterScout, JTextPane lordTroopBreakdown) {
		
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
		
		breakdownUnits(unitDB, masterScout, lordTroopBreakdown);
		
	}
	
	private void breakdownUnits(unitDB unitDB, Scout masterScout, JTextPane lordTroopBreakdown) {
		
		double troopPow = masterScout.getOverPow() * Scout.troopPerc;
		
		if (masterScout.castleLevel <= 3) {
			
			// Militia, Shortbowman, rider, Bricole
			double quartPow = troopPow / 4;
			int troopLevel = 1;
			unitDB.Militia.setCount((int)(quartPow / unitDB.Militia.getPower()));
			unitDB.Shortbowman.setCount((int)(quartPow / unitDB.Shortbowman.getPower()));
			unitDB.Rider.setCount((int)(quartPow / unitDB.Rider.getPower()));
			unitDB.Bricole.setCount((int)(quartPow / unitDB.Bricole.getPower()));
			int totalTroops = unitDB.Militia.getCount() + unitDB.Shortbowman.getCount() + unitDB.Rider.getCount() + unitDB.Bricole.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Militia, unitDB.Shortbowman, unitDB.Rider, unitDB.Bricole, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 6) {
			
			// Infantry, Longbowman, Light Cavalry, Assault Cart
			double quartPow = troopPow / 4;
			int troopLevel = 2;
			unitDB.Infantry.setCount((int)(quartPow / unitDB.Infantry.getPower()));
			unitDB.Longbowman.setCount((int)(quartPow / unitDB.Longbowman.getPower()));
			unitDB.LightCavalry.setCount((int)(quartPow / unitDB.LightCavalry.getPower()));
			unitDB.AssaultCart.setCount((int)(quartPow / unitDB.AssaultCart.getPower()));
			int totalTroops = unitDB.Infantry.getCount() + unitDB.Longbowman.getCount() + unitDB.LightCavalry.getCount() + unitDB.AssaultCart.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Infantry, unitDB.Longbowman, unitDB.LightCavalry, unitDB.AssaultCart, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 9) {
			
			// Spearman, Crossbowman, Heavy Cavalry, Mangonel
			double quartPow = troopPow / 4;
			int troopLevel = 3;
			unitDB.Spearman.setCount((int)(quartPow / unitDB.Spearman.getPower()));
			unitDB.Crossbowman.setCount((int)(quartPow / unitDB.Crossbowman.getPower()));
			unitDB.HeavyCavalry.setCount((int)(quartPow / unitDB.HeavyCavalry.getPower()));
			unitDB.Mangonel.setCount((int)(quartPow / unitDB.Mangonel.getPower()));
			int totalTroops = unitDB.Spearman.getCount() + unitDB.Crossbowman.getCount() + unitDB.HeavyCavalry.getCount() + unitDB.Mangonel.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Infantry, unitDB.Longbowman, unitDB.LightCavalry, unitDB.AssaultCart, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);	
		}
		
		else if (masterScout.castleLevel <= 12) {

			// Swordsman, Arbalester, Mounted Archer, Battering Ram
			double quartPow = troopPow / 4;
			int troopLevel = 4;
			unitDB.Swordsman.setCount((int)(quartPow / unitDB.Swordsman.getPower()));
			unitDB.Arbalester.setCount((int)(quartPow / unitDB.Arbalester.getPower()));
			unitDB.MountedArcher.setCount((int)(quartPow / unitDB.MountedArcher.getPower()));
			unitDB.BatteringRam.setCount((int)(quartPow / unitDB.BatteringRam.getPower()));
			int totalTroops = unitDB.Spearman.getCount() + unitDB.Arbalester.getCount() + unitDB.MountedArcher.getCount() + unitDB.BatteringRam.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Swordsman, unitDB.Arbalester, unitDB.MountedArcher, unitDB.BatteringRam, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 15) {

			// Pikeman, Elite Longbowman, Cavalry Shooter, Heavy Mangonel
			double quartPow = troopPow / 4;
			int troopLevel = 5;
			unitDB.Pikeman.setCount((int)(quartPow / unitDB.Pikeman.getPower()));
			unitDB.EliteLongbowman.setCount((int)(quartPow / unitDB.EliteLongbowman.getPower()));
			unitDB.CavalryShooter.setCount((int)(quartPow / unitDB.CavalryShooter.getPower()));
			unitDB.HeavyMangonel.setCount((int)(quartPow / unitDB.HeavyMangonel.getPower()));
			int totalTroops = unitDB.Pikeman.getCount() + unitDB.EliteLongbowman.getCount() + unitDB.CavalryShooter.getCount() + unitDB.HeavyMangonel.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Pikeman, unitDB.EliteLongbowman, unitDB.CavalryShooter, unitDB.HeavyMangonel, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 18) {

			// Noble Swordsman, Archer Guard, Knights Templar, Demolisher
			double quartPow = troopPow / 4;
			int troopLevel = 6;
			unitDB.NobleSwordsman.setCount((int)(quartPow / unitDB.NobleSwordsman.getPower()));
			unitDB.ArcherGuard.setCount((int)(quartPow / unitDB.ArcherGuard.getPower()));
			unitDB.KnightsTemplar.setCount((int)(quartPow / unitDB.KnightsTemplar.getPower()));
			unitDB.Demolisher.setCount((int)(quartPow / unitDB.Demolisher.getPower()));
			int totalTroops = unitDB.NobleSwordsman.getCount() + unitDB.ArcherGuard.getCount() + unitDB.KnightsTemplar.getCount() + unitDB.Demolisher.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.NobleSwordsman, unitDB.ArcherGuard, unitDB.KnightsTemplar, unitDB.Demolisher, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 21) {

			// Guard, Heavy Crossbowman, Heavy Cavalry Archer, Trebuchet
			double quartPow = troopPow / 4;
			int troopLevel = 7;
			unitDB.Guard.setCount((int)(quartPow / unitDB.Guard.getPower()));
			unitDB.HeavyCrossbowman.setCount((int)(quartPow / unitDB.HeavyCrossbowman.getPower()));
			unitDB.HeavyCArcher.setCount((int)(quartPow / unitDB.HeavyCArcher.getPower()));
			unitDB.Trebuchet.setCount((int)(quartPow / unitDB.Trebuchet.getPower()));
			int totalTroops = unitDB.Guard.getCount() + unitDB.HeavyCrossbowman.getCount() + unitDB.HeavyCArcher.getCount() + unitDB.Trebuchet.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Guard, unitDB.HeavyCrossbowman, unitDB.HeavyCArcher, unitDB.Trebuchet, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 25) {

			// Heavy Pikeman, Eagle Archer, Royal Knight, Heavy Trebuchet
			double quartPow = troopPow / 4;
			int troopLevel = 8;
			unitDB.HeavyPikeman.setCount((int)(quartPow / unitDB.HeavyPikeman.getPower()));
			unitDB.EagleArcher.setCount((int)(quartPow / unitDB.EagleArcher.getPower()));
			unitDB.RoyalKnight.setCount((int)(quartPow / unitDB.RoyalKnight.getPower()));
			unitDB.HeavyTrebuchet.setCount((int)(quartPow / unitDB.HeavyTrebuchet.getPower()));
			int totalTroops = unitDB.HeavyPikeman.getCount() + unitDB.EagleArcher.getCount() + unitDB.RoyalKnight.getCount() + unitDB.HeavyTrebuchet.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.HeavyPikeman, unitDB.EagleArcher, unitDB.RoyalKnight, unitDB.HeavyTrebuchet, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 29) {

			// Halberdier, Windlassman, Strike Archer, Siege Tower
			double quartPow = troopPow / 4;
			int troopLevel = 9;
			unitDB.Halberdier.setCount((int)(quartPow / unitDB.Halberdier.getPower()));
			unitDB.Windlassman.setCount((int)(quartPow / unitDB.Windlassman.getPower()));
			unitDB.StrikeArcher.setCount((int)(quartPow / unitDB.StrikeArcher.getPower()));
			unitDB.SiegeTower.setCount((int)(quartPow / unitDB.SiegeTower.getPower()));
			int totalTroops = unitDB.Halberdier.getCount() + unitDB.EagleArcher.getCount() + unitDB.RoyalKnight.getCount() + unitDB.HeavyTrebuchet.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Halberdier, unitDB.Windlassman, unitDB.StrikeArcher, unitDB.SiegeTower, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
		else if (masterScout.castleLevel <= 30) {

			// Berserker, Marksman, Divine Knight, Mighty Trebuchet
			double quartPow = troopPow / 4;
			int troopLevel = 10;
			unitDB.Berserker.setCount((int)(quartPow / unitDB.Berserker.getPower()));
			unitDB.Marksman.setCount((int)(quartPow / unitDB.Marksman.getPower()));
			unitDB.DivineKnight.setCount((int)(quartPow / unitDB.DivineKnight.getPower()));
			unitDB.MightyTrebuchet.setCount((int)(quartPow / unitDB.MightyTrebuchet.getPower()));
			int totalTroops = unitDB.Berserker.getCount() + unitDB.Marksman.getCount() + unitDB.DivineKnight.getCount() + unitDB.MightyTrebuchet.getCount();
			// Tell the user the number of troops of each type.
			printTroops(unitDB.Berserker, unitDB.Marksman, unitDB.DivineKnight, unitDB.MightyTrebuchet, troopLevel, totalTroops, (int)troopPow, lordTroopBreakdown);
		}
		
	}
	
	private void printTroops(unit one, unit two, unit three, unit four, int troopLevel, int maxTroopCount, int troopPow, JTextPane lordTroopBreakdown) {
		
		lordTroopBreakdown.setText("The lord's estimated troop power is " + troopPow + "\n\n"
				+ "The lord should have an estimated total of " + maxTroopCount + " troops at their disposal.\n\n"
				+ one.count + " Level " + troopLevel + " " + one.getName()  + " \n\n" + two.count + " Level " + troopLevel +  " " + two.getName() + " \n\n"
				+ three.count + " Level " + troopLevel +  " " + three.getName() + " \n\n" + four.count + " Level " + troopLevel + " " + four.getName() + " \n\n");
		
	}
}