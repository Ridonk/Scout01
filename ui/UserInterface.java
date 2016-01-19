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

public class UserInterface {

	private JFrame frmScout;
	private JTextField lordPower;
	private JTextField lordCastleLevel;

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
		frmScout.setResizable(false);
		frmScout.setIconImage(Toolkit.getDefaultToolkit().getImage(UserInterface.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frmScout.setTitle("Scout");
		frmScout.getContentPane().setBackground(Color.WHITE);
		frmScout.setBounds(100, 100, 315, 357);
		frmScout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmScout.getContentPane().setLayout(springLayout);
		
		lordPower = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lordPower, 15, SpringLayout.NORTH, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lordPower, 179, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordPower, -15, SpringLayout.EAST, frmScout.getContentPane());
		lordPower.setFont(new Font("Tahoma", Font.BOLD, 11));
		lordPower.setBackground(Color.LIGHT_GRAY);
		frmScout.getContentPane().add(lordPower);
		lordPower.setColumns(10);
		
		lordCastleLevel = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lordCastleLevel, 5, SpringLayout.SOUTH, lordPower);
		springLayout.putConstraint(SpringLayout.WEST, lordCastleLevel, 179, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordCastleLevel, -15, SpringLayout.EAST, frmScout.getContentPane());
		lordCastleLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lordCastleLevel.setBackground(Color.LIGHT_GRAY);
		lordCastleLevel.setColumns(10);
		frmScout.getContentPane().add(lordCastleLevel);
		
		JLabel labelLordPower = new JLabel("Enter the Lord's Power");
		springLayout.putConstraint(SpringLayout.NORTH, labelLordPower, 3, SpringLayout.NORTH, lordPower);
		springLayout.putConstraint(SpringLayout.WEST, labelLordPower, 15, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, labelLordPower, -15, SpringLayout.WEST, lordPower);
		frmScout.getContentPane().add(labelLordPower);
		
		JLabel labelLordCastleLevel = new JLabel("Enter the Lord's Castle Level");
		springLayout.putConstraint(SpringLayout.NORTH, labelLordCastleLevel, 3, SpringLayout.NORTH, lordCastleLevel);
		springLayout.putConstraint(SpringLayout.WEST, labelLordCastleLevel, 15, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, labelLordCastleLevel, -15, SpringLayout.WEST, lordCastleLevel);
		frmScout.getContentPane().add(labelLordCastleLevel);
		
		JTextPane lordTroopBreakdown = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, lordTroopBreakdown, 15, SpringLayout.WEST, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lordTroopBreakdown, -15, SpringLayout.SOUTH, frmScout.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lordTroopBreakdown, -15, SpringLayout.EAST, frmScout.getContentPane());
		frmScout.getContentPane().add(lordTroopBreakdown);
		
		JButton btnCalculate = new JButton("Calculate");
		springLayout.putConstraint(SpringLayout.NORTH, lordTroopBreakdown, 15, SpringLayout.SOUTH, btnCalculate);
		springLayout.putConstraint(SpringLayout.NORTH, btnCalculate, 5, SpringLayout.SOUTH, lordCastleLevel);
		springLayout.putConstraint(SpringLayout.WEST, btnCalculate, 179, SpringLayout.WEST, frmScout.getContentPane());
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
		frmScout.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmClose);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHowToUse = new JMenuItem("How to use");
		mntmHowToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmScout, "Simply put the lord power and castle level of your target in and click"
						+ " calculate. \n\nIf you find any bugs please report them to Ridonk in Kingdom 850.");
			}
		});
		mnHelp.add(mntmHowToUse);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmScout, ""
						+ "Scout is a program written by George Dunbar (AKA Ridonk in Kingdom 850)\n"
						+ "Version: 0.03 - Build 1\n"
						+ "Build date: Jan 17 2016\n"
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
		unitDB.setInfantry(new unit(2, 4, 8, 19, 9, 8, 10.46, 1, 0.42, 1.4));
		unitDB.setSpearman(new unit(3, 7, 22, 13, 6, 9, 11.46, 1, 0.63, 1.9));
		unitDB.setSwordsman(new unit(4, 10, 15, 35, 15, 8, 11.46, 1, 0.83, 2.5));
		unitDB.setPikeman(new unit(5, 13, 38, 22, 15, 9, 13.07, 1, 1.04, 3.2));
		unitDB.setNobleSwordsman(new unit(6, 16, 24, 56, 22, 8, 13.07, 1, 1.25, 4.0));
		unitDB.setGuard(new unit(7, 19, 29, 68, 26, 8, 14.07, 1, 1.46, 4.9));
		unitDB.setHeavyPikeman(new unit(8, 22, 70, 41, 15, 9, 14.38, 1, 1.67, 5.9));
		unitDB.setHalberdier(new unit(9, 26, 84, 49, 18, 9, 15.68, 1, 1.88, 7.0));
		unitDB.setBerserker(new unit(10, 30, 49, 114, 42, 8, 15.68, 1, 2.08, 8.2));
		
		// Create archer units
		unitDB.setShortbowman(new unit(1, 1, 8, 6, 3, 8, 10.46, 5, 0.21, 1.0));
		unitDB.setLongbowman(new unit(2, 4, 11, 8, 3, 8, 10.46, 5, 0.42, 1.4));
		unitDB.setCrossbowman(new unit(3, 7, 26, 13, 4, 8, 10.46, 8, 0.63, 1.9));
		unitDB.setArbalester(new unit(4, 10, 35, 17, 5, 8, 10.46, 8, 0.83, 2.5));
		unitDB.setEliteLongbowman(new unit(5, 13, 25, 19, 6, 8, 13.07, 5, 1.04, 3.2));
		unitDB.setArcherGuard(new unit(6, 16, 32, 24, 8, 8, 13.07, 5, 1.25, 4));
		unitDB.setHeavyCrossbowman(new unit(7, 19, 68, 34, 10, 8, 13.07, 8, 1.46, 4.9));
		unitDB.setEagleArcher(new unit(8, 22, 47, 35, 11, 8, 14.38, 5, 1.67, 5.9));
		unitDB.setWindlassman(new unit(9, 26, 98, 49, 13, 8, 14.38, 8, 1.88, 7.0));
		unitDB.setMarksman(new unit(10, 30, 65, 49, 15, 8, 15.68, 5, 2.08, 9.2));
		
		// Create cavalry units
		unitDB.setRider(new unit(1, 1, 11, 8, 4, 14, 7.84, 1, 0.21, 1.0));
		unitDB.setLightCavalry(new unit(2, 4, 15, 11, 4, 14, 7.84, 1, 0.42, 1.4));
		unitDB.setHeavyCavalry(new unit(3, 7, 20, 15, 6, 14, 9.15, 1, 0.63, 1.9));
		unitDB.setMountedArcher(new unit(4, 10, 32, 17, 7, 13, 9.15, 4, 0.83, 2.5));
		unitDB.setCavalryShooter(new unit(5, 13, 41, 22, 9, 13, 10.46, 4, 1.04, 3.2));
		unitDB.setKnightsTemplar(new unit(6, 16, 44, 22, 9, 14, 10.46, 1, 1.25, 4.0));
		unitDB.setHeavyCArcher(new unit(7, 19, 63, 34, 13, 13, 11.76, 4, 1.46, 4.9));
		unitDB.setRoyalKnight(new unit(8, 22, 64, 47, 15, 14, 11.76, 1, 1.67, 5.9));
		unitDB.setStrikeArcher(new unit(9, 26, 91, 49, 18, 13, 13.07, 4, 1.88, 7.0));
		unitDB.setDivineKnight(new unit(10, 30, 90, 65, 21, 14, 13.07, 1, 2.08, 8.2));
		
		// Create siege units
		unitDB.setBricole(new unit(1, 1, 20, 9, 5, 7, 16.99, 10, 0.21, 1.0));
		unitDB.setAssaultCart(new unit(2, 4, 9, 14, 8, 5, 26.14, 1, 0.42, 1.4));
		unitDB.setMangonel(new unit(3, 7, 38, 17, 7, 7, 18.30, 10, 0.63, 1.9));
		unitDB.setBatteringRam(new unit(4, 10, 17, 25, 13, 5, 27.45, 1, 0.83, 2.5));
		unitDB.setHeavyMangonel(new unit(5, 13, 64, 28, 11, 7, 19.61, 10, 1.04, 3.2));
		unitDB.setDemolisher(new unit(6, 16, 28, 40, 19, 5, 28.75, 1, 1.25, 4.0));
		unitDB.setTrebuchet(new unit(7, 19, 98, 44, 16, 7, 20.91, 10, 1.46, 4.9));
		unitDB.setHeavyTrebuchet(new unit(8, 22, 118, 53, 19, 7, 20.91, 10, 1.67, 5.9));
		unitDB.setSiegeTower(new unit(9, 26, 49, 70, 32, 5, 31.37, 1, 1.88, 7.0));
		unitDB.setMightyTrebuchet(new unit(10, 30, 164, 73, 26, 7, 22.22, 10, 2.08, 8.2));
		
		breakdownUnits(unitDB, masterScout, lordTroopBreakdown);
		
	}
	
	private void breakdownUnits(unitDB unitDB, Scout masterScout, JTextPane lordTroopBreakdown) {
		
		double troopPow = masterScout.getOverPow() * Scout.troopPerc;
		
		if (masterScout.castleLevel <= 3) {
			
			// Militia, Shortbowman, rider, Bricole
			double quartPow = troopPow / 4;
			double troopCountMilitia = quartPow / unitDB.Militia.getPower();
			double troopCountShortbowman = quartPow / unitDB.Shortbowman.getPower();
			double troopCountRider = quartPow / unitDB.Rider.getPower();
			double troopCountBricole = quartPow / unitDB.Bricole.getPower();
			double totalTroops = (troopCountMilitia + troopCountShortbowman + troopCountRider + troopCountBricole);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
				+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
				+ "each of level " + unitDB.Militia.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 6) {
			
			// Infantry, Longbowman, Light Cavalry, Assault Cart
			double quartPow = troopPow / 4;
			double troopCountInfantry = quartPow / unitDB.Infantry.getPower();
			double troopCountLongbowman = quartPow / unitDB.Longbowman.getPower();
			double troopCountLightCavalry = quartPow / unitDB.LightCavalry.getPower();
			double troopCountAssaultCart = quartPow / unitDB.AssaultCart.getPower();
			double totalTroops = (troopCountInfantry + troopCountLongbowman + troopCountLightCavalry + troopCountAssaultCart);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
				+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
				+ "each of level " + unitDB.Infantry.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 9) {
			
			// Spearman, Crossbowman, Heavy Cavalry, Mangonel
			double quartPow = troopPow / 4;
			double troopCountSpearman = quartPow / unitDB.Spearman.getPower();
			double troopCountCrossbowman = quartPow / unitDB.Crossbowman.getPower();
			double troopCountHeavyCavalry = quartPow / unitDB.HeavyCavalry.getPower();
			double troopCountMangonel = quartPow / unitDB.Mangonel.getPower();
			double totalTroops = (troopCountSpearman + troopCountCrossbowman + troopCountHeavyCavalry + troopCountMangonel);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.Spearman.level + " infantry, archer, cavalry, and siege units.");			
		}
		
		else if (masterScout.castleLevel <= 12) {

			// Swordsman, Arbalester, Mounted Archer, Battering Ram
			double quartPow = troopPow / 4;
			double troopCountSwordsman = quartPow / unitDB.Swordsman.getPower();
			double troopCountArbalester = quartPow / unitDB.Arbalester.getPower();
			double troopCountMountedArcher = quartPow / unitDB.MountedArcher.getPower();
			double troopCountBatteringRam = quartPow / unitDB.BatteringRam.getPower();
			double totalTroops = (troopCountSwordsman + troopCountArbalester + troopCountMountedArcher + troopCountBatteringRam);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.Swordsman.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 15) {

			// Pikeman, Elite Longbowman, Cavalry Shooter, Heavy Mangonel
			double quartPow = troopPow / 4;
			double troopCountPikeman = quartPow / unitDB.Pikeman.getPower();
			double troopCountEliteLongbowman = quartPow / unitDB.EliteLongbowman.getPower();
			double troopCountCavalryShooter = quartPow / unitDB.CavalryShooter.getPower();
			double troopCountHeavyMangonel = quartPow / unitDB.HeavyMangonel.getPower();
			double totalTroops = (troopCountPikeman + troopCountEliteLongbowman + troopCountCavalryShooter + troopCountHeavyMangonel);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.Pikeman.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 18) {

			// Noble Swordsman, Archer Guard, Knights Templar, Demolisher
			double quartPow = troopPow / 4;
			double troopCountNobleSwordsman = quartPow / unitDB.NobleSwordsman.getPower();
			double troopCountArcherGuard = quartPow / unitDB.ArcherGuard.getPower();
			double troopCountKnightsTemplar = quartPow / unitDB.KnightsTemplar.getPower();
			double troopCountDemolisher = quartPow / unitDB.Demolisher.getPower();
			double totalTroops = (troopCountNobleSwordsman + troopCountArcherGuard + troopCountKnightsTemplar + troopCountDemolisher);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.NobleSwordsman.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 21) {

			// Guard, Heavy Crossbowman, Heavy Cavalry Archer, Trebuchet
			double quartPow = troopPow / 4;
			double troopCountGuard = quartPow / unitDB.Guard.getPower();
			double troopCountHeavyCrossbowman = quartPow / unitDB.HeavyCrossbowman.getPower();
			double troopCountHeavyCArcher = quartPow / unitDB.HeavyCArcher.getPower();
			double troopCountTrebuchet = quartPow / unitDB.Trebuchet.getPower();
			double totalTroops = (troopCountGuard + troopCountHeavyCrossbowman + troopCountHeavyCArcher + troopCountTrebuchet);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.Guard.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 25) {

			// Heavy Pikeman, Eagle Archer, Royal Knight, Heavy Trebuchet
			double quartPow = troopPow / 4;
			double troopCountHeavyPikeman = quartPow / unitDB.HeavyPikeman.getPower();
			double troopCountEagleArcher = quartPow / unitDB.EagleArcher.getPower();
			double troopCountRoyalKnight = quartPow / unitDB.RoyalKnight.getPower();
			double troopCountHeavyTrebuchet = quartPow / unitDB.HeavyTrebuchet.getPower();
			double totalTroops = (troopCountHeavyPikeman + troopCountEagleArcher + troopCountRoyalKnight + troopCountHeavyTrebuchet);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.HeavyPikeman.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 29) {

			// Halberdier, Windlassman, Strike Archer, Siege Tower
			double quartPow = troopPow / 4;
			double troopCountHalberdier = quartPow / unitDB.Halberdier.getPower();
			double troopCountWindlassman = quartPow / unitDB.Windlassman.getPower();
			double troopCountStrikeArcher = quartPow / unitDB.StrikeArcher.getPower();
			double troopCountSiegeTower = quartPow / unitDB.SiegeTower.getPower();
			double totalTroops = (troopCountHalberdier + troopCountWindlassman + troopCountStrikeArcher + troopCountSiegeTower);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.Halberdier.level + " infantry, archer, cavalry, and siege units.");
		}
		
		else if (masterScout.castleLevel <= 30) {

			// Berserker, Marksman, Divine Knight, Mighty Trebuchet
			double quartPow = troopPow / 4;
			double troopCountBerserker = quartPow / unitDB.Berserker.getPower();
			double troopCountMarksman = quartPow / unitDB.Marksman.getPower();
			double troopCountDivineKnight = quartPow / unitDB.DivineKnight.getPower();
			double troopCountMightyTrebuchet = quartPow / unitDB.MightyTrebuchet.getPower();
			double totalTroops = (troopCountBerserker + troopCountMarksman + troopCountDivineKnight + troopCountMightyTrebuchet);
			// Tell the user the number of troops of each type.
			lordTroopBreakdown.setText("The Lord's likely troop power is: " + (int)masterScout.getTroopPow(masterScout) + "\n" 
					+ "\nThe lord should have " + (int)totalTroops + " troops in his/her army.\n\nThere should be " + (int)(totalTroops / 4) + " " 
					+ "each of level " + unitDB.Berserker.level + " infantry, archer, cavalry, and siege units.");
		}
		
	}
}
