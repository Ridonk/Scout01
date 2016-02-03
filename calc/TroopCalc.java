package calc;

public class TroopCalc {
	
	// Percentages based on survey results of alliance members. To be tweaked as more information comes in.
	public static double troopPerc = 0.5141;
	
	// Actual containers for the strings.
	private String percString;
	private String troopString;
	public String resultsString;

	public TroopCalc(int power, int castleLevel) {
		resultsString = createPercString(power, castleLevel);
	}
	
	private String createPercString(int pow, int cas) {
		percString = null;
		int trPow = ((int)(pow * troopPerc));
		System.out.println("Troop Power = " + trPow);
		percString = "Estimated Troop Power: " + trPow + "\n\n";
		return percString + createTroopString(trPow / 4, cas);
	}
	
	private String createTroopString(int power, int castleLevel) {
		troopString = null;
		Unit[] UnitArr = initUnitArr(initUnitDB(), castleLevel, power);
		
		// How many are there total?
		int totalTroops = 0;
		for (int i = 0; i < 8; i++) {
			if (UnitArr[i] != null) {
				totalTroops = totalTroops + UnitArr[i].getCount();
				System.out.println("Pass " + (i + 1) + ": " + totalTroops + " troops.");
			}
			else if (UnitArr[i] == null) System.out.println("Empty slot, skipping pass " + (i + 1) + ".");
		}
		
		// Build and return the string
		for (int i = 0; i < 8; i++) {
			if (UnitArr[i] != null && i != 7) {
				if (troopString == null) troopString = "";
				troopString = troopString + UnitArr[i].getCount() + " " + UnitArr[i].getName() + "\n";
//				System.out.println(troopString);
			}
			else if (UnitArr[i] != null && i == 7) {
				troopString = troopString + UnitArr[i].getCount() + " " + UnitArr[i].getName() + "\n\n";
//				System.out.println(troopString);
			}
		}
		System.out.println(troopString);
		return troopString;
	}
	
	public Unit[] initUnitArr(UnitDB UnitDB, int castleLevel, int quartPow) {
		Unit[] UnitArr = new Unit[8];
		
		if (castleLevel <= 3) {
			
			UnitArr[0] = UnitDB.Militia;
			UnitArr[1] = UnitDB.Shortbowman;
			UnitArr[2] = UnitDB.Rider;
			UnitArr[3] = UnitDB.Bricole;
			UnitArr[4] = null;
			UnitArr[5] = null;
			UnitArr[6] = null;
			UnitArr[7] = null;
			// How many of each are there?
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			
		}
		
		else if (castleLevel <= 6) {
			
			UnitArr[0] = UnitDB.Militia;
			UnitArr[1] = UnitDB.Shortbowman;
			UnitArr[2] = null;
			UnitArr[3] = UnitDB.Bricole;
			UnitArr[4] = UnitDB.Infantry;
			UnitArr[5] = UnitDB.Longbowman;
			UnitArr[6] = UnitDB.LightCavalry;
			UnitArr[7] = UnitDB.AssaultCart;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 9) {
			
			UnitArr[0] = UnitDB.Infantry;
			UnitArr[1] = UnitDB.Longbowman;
			UnitArr[2] = null;
			UnitArr[3] = UnitDB.AssaultCart;
			UnitArr[4] = UnitDB.Spearman;
			UnitArr[5] = UnitDB.Crossbowman;
			UnitArr[6] = UnitDB.HeavyCavalry;
			UnitArr[7] = UnitDB.Mangonel;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 12) {

			UnitArr[0] = UnitDB.Spearman;
			UnitArr[1] = UnitDB.Longbowman;
			UnitArr[2] = UnitDB.HeavyCavalry;
			UnitArr[3] = UnitDB.Mangonel;
			UnitArr[4] = UnitDB.Swordsman;
			UnitArr[5] = UnitDB.Arbalester;
			UnitArr[6] = UnitDB.MountedArcher;
			UnitArr[7] = UnitDB.BatteringRam;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 15) {

			UnitArr[0] = UnitDB.Swordsman;
			UnitArr[1] = UnitDB.Arbalester;
			UnitArr[2] = UnitDB.HeavyCavalry;
			UnitArr[3] = UnitDB.BatteringRam;
			UnitArr[4] = UnitDB.Pikeman;
			UnitArr[5] = UnitDB.EliteLongbowman;
			UnitArr[6] = UnitDB.CavalryShooter;
			UnitArr[7] = UnitDB.HeavyMangonel;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 18) {

			UnitArr[0] = UnitDB.Pikeman;
			UnitArr[1] = UnitDB.Arbalester;
			UnitArr[2] = UnitDB.CavalryShooter;
			UnitArr[3] = UnitDB.HeavyMangonel;
			UnitArr[4] = UnitDB.NobleSwordsman;
			UnitArr[5] = UnitDB.ArcherGuard;
			UnitArr[6] = UnitDB.KnightsTemplar;
			UnitArr[7] = UnitDB.Demolisher;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 21) {

			UnitArr[0] = UnitDB.Pikeman;
			UnitArr[1] = UnitDB.ArcherGuard;
			UnitArr[2] = UnitDB.KnightsTemplar;
			UnitArr[3] = UnitDB.Demolisher;
			UnitArr[4] = UnitDB.Guard;
			UnitArr[5] = UnitDB.HeavyCrossbowman;
			UnitArr[6] = UnitDB.HeavyCArcher;
			UnitArr[7] = UnitDB.Trebuchet;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 25) {

			UnitArr[0] = UnitDB.Guard;
			UnitArr[1] = UnitDB.HeavyCrossbowman;
			UnitArr[2] = UnitDB.HeavyCArcher;
			UnitArr[3] = UnitDB.Demolisher;
			UnitArr[4] = UnitDB.HeavyPikeman;
			UnitArr[5] = UnitDB.EagleArcher;
			UnitArr[6] = UnitDB.RoyalKnight;
			UnitArr[7] = UnitDB.HeavyTrebuchet;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		else if (castleLevel <= 29) {

			UnitArr[0] = UnitDB.Guard;
			UnitArr[1] = UnitDB.EagleArcher;
			UnitArr[2] = UnitDB.RoyalKnight;
			UnitArr[3] = UnitDB.HeavyTrebuchet;
			UnitArr[4] = UnitDB.Halberdier;
			UnitArr[5] = UnitDB.Windlassman;
			UnitArr[6] = UnitDB.StrikeArcher;
			UnitArr[7] = UnitDB.SiegeTower;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
			
		}
		
		else if (castleLevel <= 30) {

			UnitArr[0] = UnitDB.Halberdier;
			UnitArr[1] = UnitDB.Windlassman;
			UnitArr[2] = UnitDB.StrikeArcher;
			UnitArr[3] = UnitDB.SiegeTower;
			UnitArr[4] = UnitDB.Berserker;
			UnitArr[5] = UnitDB.Marksman;
			UnitArr[6] = UnitDB.DivineKnight;
			UnitArr[7] = UnitDB.MightyTrebuchet;
			quartPow = quartPow / 2;
			UnitArr[0].setCount((int)(quartPow / UnitArr[0].getPower()));
			UnitArr[1].setCount((int)(quartPow / UnitArr[1].getPower()));
			UnitArr[2].setCount((int)(quartPow / UnitArr[2].getPower()));
			UnitArr[3].setCount((int)(quartPow / UnitArr[3].getPower()));
			UnitArr[4].setCount((int)(quartPow / UnitArr[4].getPower()));
			UnitArr[5].setCount((int)(quartPow / UnitArr[5].getPower()));
			UnitArr[6].setCount((int)(quartPow / UnitArr[6].getPower()));
			UnitArr[7].setCount((int)(quartPow / UnitArr[7].getPower()));
			int totalTroops = 0;
			for (int i = 0; i < 8; i++) if (UnitArr[i] != null) totalTroops = totalTroops + UnitArr[i].getCount();
			
		}
		
		return UnitArr;
	}
	
	public UnitDB initUnitDB() {
		
		// Init UnitDB
		UnitDB UnitDB = new UnitDB();
		
		// Create infantry Units
		UnitDB.setMilitia(new Unit(1, 1, 6, 14, 8, 8, 10.46, 1, 0.21, 1.0));
		UnitDB.Militia.setName("Militia");
		UnitDB.setInfantry(new Unit(2, 4, 8, 19, 9, 8, 10.46, 1, 0.42, 1.4));
		UnitDB.Infantry.setName("Infantry");
		UnitDB.setSpearman(new Unit(3, 7, 22, 13, 6, 9, 11.46, 1, 0.63, 1.9));
		UnitDB.Spearman.setName("Spearman");
		UnitDB.setSwordsman(new Unit(4, 10, 15, 35, 15, 8, 11.46, 1, 0.83, 2.5));
		UnitDB.Swordsman.setName("Swordsman");
		UnitDB.setPikeman(new Unit(5, 13, 38, 22, 15, 9, 13.07, 1, 1.04, 3.2));
		UnitDB.Pikeman.setName("Pikeman");
		UnitDB.setNobleSwordsman(new Unit(6, 16, 24, 56, 22, 8, 13.07, 1, 1.25, 4.0));
		UnitDB.NobleSwordsman.setName("Noble Swordsman");
		UnitDB.setGuard(new Unit(7, 19, 29, 68, 26, 8, 14.07, 1, 1.46, 4.9));
		UnitDB.Guard.setName("Guard");
		UnitDB.setHeavyPikeman(new Unit(8, 22, 70, 41, 15, 9, 14.38, 1, 1.67, 5.9));
		UnitDB.HeavyPikeman.setName("Heavy Pikeman");
		UnitDB.setHalberdier(new Unit(9, 26, 84, 49, 18, 9, 15.68, 1, 1.88, 7.0));
		UnitDB.Halberdier.setName("Halberdier");
		UnitDB.setBerserker(new Unit(10, 30, 49, 114, 42, 8, 15.68, 1, 2.08, 8.2));
		UnitDB.Berserker.setName("Berserker");
		
		// Create archer Units
		UnitDB.setShortbowman(new Unit(1, 1, 8, 6, 3, 8, 10.46, 5, 0.21, 1.0));
		UnitDB.Shortbowman.setName("Shortbowman");
		UnitDB.setLongbowman(new Unit(2, 4, 11, 8, 3, 8, 10.46, 5, 0.42, 1.4));
		UnitDB.Longbowman.setName("Longbowman");
		UnitDB.setCrossbowman(new Unit(3, 7, 26, 13, 4, 8, 10.46, 8, 0.63, 1.9));
		UnitDB.Crossbowman.setName("Crossbowman");
		UnitDB.setArbalester(new Unit(4, 10, 35, 17, 5, 8, 10.46, 8, 0.83, 2.5));
		UnitDB.Arbalester.setName("Arbalester");
		UnitDB.setEliteLongbowman(new Unit(5, 13, 25, 19, 6, 8, 13.07, 5, 1.04, 3.2));
		UnitDB.EliteLongbowman.setName("Elite Longbowman");
		UnitDB.setArcherGuard(new Unit(6, 16, 32, 24, 8, 8, 13.07, 5, 1.25, 4));
		UnitDB.ArcherGuard.setName("Archer Guard");
		UnitDB.setHeavyCrossbowman(new Unit(7, 19, 68, 34, 10, 8, 13.07, 8, 1.46, 4.9));
		UnitDB.HeavyCrossbowman.setName("Heavy Crossbowman");
		UnitDB.setEagleArcher(new Unit(8, 22, 47, 35, 11, 8, 14.38, 5, 1.67, 5.9));
		UnitDB.EagleArcher.setName("Eagle Archer");
		UnitDB.setWindlassman(new Unit(9, 26, 98, 49, 13, 8, 14.38, 8, 1.88, 7.0));
		UnitDB.Windlassman.setName("Windlassman");
		UnitDB.setMarksman(new Unit(10, 30, 65, 49, 15, 8, 15.68, 5, 2.08, 9.2));
		UnitDB.Marksman.setName("Marksman");
		
		// Create cavalry Units
		UnitDB.setRider(new Unit(1, 1, 11, 8, 4, 14, 7.84, 1, 0.21, 1.0));
		UnitDB.Rider.setName("Rider");
		UnitDB.setLightCavalry(new Unit(2, 4, 15, 11, 4, 14, 7.84, 1, 0.42, 1.4));
		UnitDB.LightCavalry.setName("Light Cavalry");
		UnitDB.setHeavyCavalry(new Unit(3, 7, 20, 15, 6, 14, 9.15, 1, 0.63, 1.9));
		UnitDB.HeavyCavalry.setName("Heavy Cavalry");
		UnitDB.setMountedArcher(new Unit(4, 10, 32, 17, 7, 13, 9.15, 4, 0.83, 2.5));
		UnitDB.MountedArcher.setName("Mounted Archer");
		UnitDB.setCavalryShooter(new Unit(5, 13, 41, 22, 9, 13, 10.46, 4, 1.04, 3.2));
		UnitDB.CavalryShooter.setName("Cavalry Shooter");
		UnitDB.setKnightsTemplar(new Unit(6, 16, 44, 22, 9, 14, 10.46, 1, 1.25, 4.0));
		UnitDB.KnightsTemplar.setName("Knights Templar");
		UnitDB.setHeavyCArcher(new Unit(7, 19, 63, 34, 13, 13, 11.76, 4, 1.46, 4.9));
		UnitDB.HeavyCArcher.setName("Heavy Calvary Archer");
		UnitDB.setRoyalKnight(new Unit(8, 22, 64, 47, 15, 14, 11.76, 1, 1.67, 5.9));
		UnitDB.RoyalKnight.setName("Royal Knight");
		UnitDB.setStrikeArcher(new Unit(9, 26, 91, 49, 18, 13, 13.07, 4, 1.88, 7.0));
		UnitDB.StrikeArcher.setName("Strike Archer");
		UnitDB.setDivineKnight(new Unit(10, 30, 90, 65, 21, 14, 13.07, 1, 2.08, 8.2));
		UnitDB.DivineKnight.setName("Divine Knight");
		
		// Create siege Units
		UnitDB.setBricole(new Unit(1, 1, 20, 9, 5, 7, 16.99, 10, 0.21, 1.0));
		UnitDB.Bricole.setName("Bricole");
		UnitDB.setAssaultCart(new Unit(2, 4, 9, 14, 8, 5, 26.14, 1, 0.42, 1.4));
		UnitDB.AssaultCart.setName("Assault Cart");
		UnitDB.setMangonel(new Unit(3, 7, 38, 17, 7, 7, 18.30, 10, 0.63, 1.9));
		UnitDB.Mangonel.setName("Mangonel");
		UnitDB.setBatteringRam(new Unit(4, 10, 17, 25, 13, 5, 27.45, 1, 0.83, 2.5));
		UnitDB.BatteringRam.setName("Battering Ram");
		UnitDB.setHeavyMangonel(new Unit(5, 13, 64, 28, 11, 7, 19.61, 10, 1.04, 3.2));
		UnitDB.HeavyMangonel.setName("Heavy Mangonel");
		UnitDB.setDemolisher(new Unit(6, 16, 28, 40, 19, 5, 28.75, 1, 1.25, 4.0));
		UnitDB.Demolisher.setName("Demolisher");
		UnitDB.setTrebuchet(new Unit(7, 19, 98, 44, 16, 7, 20.91, 10, 1.46, 4.9));
		UnitDB.Trebuchet.setName("Trebuchet");
		UnitDB.setHeavyTrebuchet(new Unit(8, 22, 118, 53, 19, 7, 20.91, 10, 1.67, 5.9));
		UnitDB.HeavyTrebuchet.setName("Heavy Trebuchet");
		UnitDB.setSiegeTower(new Unit(9, 26, 49, 70, 32, 5, 31.37, 1, 1.88, 7.0));
		UnitDB.SiegeTower.setName("Siege Tower");
		UnitDB.setMightyTrebuchet(new Unit(10, 30, 164, 73, 26, 7, 22.22, 10, 2.08, 8.2));
		UnitDB.MightyTrebuchet.setName("Mighty Trebuchet");
		
		return UnitDB;
		
	}
	
}