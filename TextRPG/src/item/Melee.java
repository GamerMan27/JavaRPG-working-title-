package item;

import mob.Mob;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/15/2022	Implementation
 * 
 * Melee is a class that includes any close quarters weapon, from a tree branch
 * to a sword with a magnetically contained plasma blade.
 */
public class Melee extends Weapon{
	private double attackSpeed;
	
	public Melee() {
		super();
		setAttackSpeed(1);
	}
	public Melee(int ID, String n, double w, double v, String dd, int c, boolean s, double dam, double r, double atk) {
		super(ID, n, w, v, dd, c, s, dam, r);
		setAttackSpeed(atk);
	}
	
	//Method to get attack speed of a Melee weapon.
	public double getAttackSpeed() {
		return attackSpeed;
	}
	
	//Method to set Attack speed of a Melee weapon.
	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	public void hitMob(Mob m) {
		m.tookDamage(this.getDamage());
	}
}
