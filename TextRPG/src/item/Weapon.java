package item;
/*
 * Programmer		Date		Changelog
 * Keith Davis		12/10/2022	Implementation
 */
public abstract class Weapon extends Item{
	
	private double damage;
	private double range;
	
	//Default constructor
	public Weapon() {
		super();
		setDamage(1);
		setRange(10);
	}
	
	//Weapon constructor with only superclass variables specified
	public Weapon(int ID, String n, double w, double v, String dd, int c, boolean s) {
		super(ID, n, w, v, dd, c, s);
	}
	
	//Weapon constructor with all parameters
	public Weapon(int ID, String n, double w, double v, String dd, int c, boolean s, double dam, double r) {
		super(ID, n, w, v, dd, c, s);
		setDamage(dam);
		setRange(r);
	}
	
	//Method to get Damage value
	public double getDamage() {
		return damage;
	}
	
	//Method to set Damage value
	public void setDamage(double damage) {
		this.damage = damage;
	}
	
	//Method to get Range value
	public double getRange() {
		return range;
	}
	
	//Method to set Range value
	public void setRange(double range) {
		this.range = range;
	}
}
