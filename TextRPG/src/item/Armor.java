package item;

public class Armor extends Item{
	private double damageReduct;
	
	public Armor(int ID, String n, double w, double v, String dd, int q, boolean s, double dmgrd) {
		super(ID, n, w, v, dd, q, s);
		setDamageReduct(dmgrd);
	}
	
	public double getDamageReduct() {
		return damageReduct;
	}
	
	public void setDamageReduct(double damageReduct) {
		this.damageReduct = damageReduct;
	}
	
	public double armorHit(double dmg) {
		double reduced;
		reduced = dmg * this.getDamageReduct();
		return dmg - reduced;
	}
}
