package calc;

//import javax.swing.JTextField;

public class Scout {
	
	// Variable for storing overall power
	public double overPow;
		
	// Variable for storing castle level
	public double castleLevel;
	
	// Percentages based on survey results of alliance members. To be tweaked as more information comes in.
	public static double lordPerc = 0.1115;
	public static double troopPerc = 0.5141;
	public static double buildPerc = 0.2012;
	public static double sciPerc = 0.0637;
	public static double trapPerc = 0.0876;
	public static double equipPerc = 0.0219;

	/**
	 * @param overPow
	 * @param castleLevel
	 */
	public Scout(double overPow, double castleLevel) {
		this.overPow = overPow;
		this.castleLevel = castleLevel;
	}
	
	// Get overall power
	public double getOverPow() {
		return overPow;
	}
	// Set overall power
	public void setOverPow(double overPow) {
		this.overPow = overPow;
	}
	// Get Castle Level
	public double getCastleLevel() {
		return castleLevel;
	}
	// Set Castle Level
	public void setCastleLevel(double castleLevel) {
		this.castleLevel = castleLevel;
	}
	// Get Lord Power
	public double getLordPow(Scout masterScout) {
		
		double lordPow = masterScout.getOverPow() * lordPerc;
		return lordPow;
		
	}
	// Get Troop Power
	public double getTroopPow(Scout masterScout) {
		
		double troopPow = masterScout.getOverPow() * troopPerc;
		return troopPow;
		
	}
	// Get Building Power
	public double getBuildPow(Scout masterScout) {
		
		double buildPow = masterScout.getOverPow() * buildPerc;
		return buildPow;
		
	}
	// Get Science Power
	public double getSciPow(Scout masterScout) {
		
		double sciPow = masterScout.getOverPow() * sciPerc;
		return sciPow;
		
	}
	// Get Trap Power
	public double getTrapPow(Scout masterScout) {
		
		double trapPow = masterScout.getOverPow() * trapPerc;
		return trapPow;
		
	}
	// Get Equipment power
	public double getEquipPow(Scout masterScout) {
	
		double equipPow = masterScout.getOverPow() * equipPerc;
		return equipPow;
		
	}

}