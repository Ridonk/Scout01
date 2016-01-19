package ui;
public class unit extends UserInterface {
	int level;
	int casLevel;
	int attack;
	int defense;
	int hp;
	int speed;
	double load;
	int range;
	double upkeep;
	double power;
	
	public unit(int level, int casLevel, int attack, int defense, int hp, int speed, double load, int range, double upkeep, double power) {
		this.level = level;
		this.casLevel = casLevel;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.speed = speed;
		this.load = load;
		this.range = range;
		this.upkeep = upkeep;
		this.power = power;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCasLevel() {
		return casLevel;
	}
	public void setCasLevel(int casLevel) {
		this.casLevel = casLevel;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getLoad() {
		return load;
	}
	public void setLoad(double load) {
		this.load = load;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getUpkeep() {
		return upkeep;
	}
	public void setUpkeep(double upkeep) {
		this.upkeep = upkeep;
	}
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	
	
}
