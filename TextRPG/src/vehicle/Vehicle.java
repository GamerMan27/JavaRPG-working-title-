package vehicle;

import mob.Mob;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/16/2022	Implementation
 * Keith Davis		12/17/2022	Added health and damage systems to the generic vehicle class
 */

public class Vehicle {
	private String name;
	private String engine;
	private String fuel;
	private int seats;
	private double hull;
	private boolean hasWeapons;
	private int weaponPoints;
	private double weaponDamage;
	private int team = 0;
	
	public Vehicle() {
		setName("Generic Vehicle");
		setEngine(null);
		setFuel(null);
		setSeats(0);
		setHull(1000);
		setHasWeapons(false);
		setWeaponPoints(0);
		setWeaponDamage(0);
		setTeam(0);
		
	}
	public Vehicle(String n, String eng, String f, int s, double h, boolean hw, int wp, double wd) {
		setName(n);
		setEngine(eng);
		setFuel(f);
		setSeats(s);
		setHull(h);
		setHasWeapons(hw);
		setWeaponPoints(wp);
		setWeaponDamage(wd);
		setTeam(0);
	}
	public Vehicle(String n, String eng, String f, int s, double h, boolean hw, int wp, double wd, int t) {
		setName(n);
		setEngine(eng);
		setFuel(f);
		setSeats(s);
		setHull(h);
		setHasWeapons(hw);
		setWeaponPoints(wp);
		setWeaponDamage(wd);
		setTeam(t);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public double getHull() {
		return hull;
	}

	public void setHull(double hull) {
		this.hull = hull;
	}

	public boolean isHasWeapons() {
		return hasWeapons;
	}

	public void setHasWeapons(boolean hasWeapons) {
		this.hasWeapons = hasWeapons;
	}

	public int getWeaponPoints() {
		return weaponPoints;
	}

	public void setWeaponPoints(int weaponPoints) {
		this.weaponPoints = weaponPoints;
	}
	
	public double getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(double weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
	
	public void tookDamage(double dmg) {
		this.setHull(this.getHull() - dmg);
		if (this.getHull() <= 0) {
			System.out.println("The ship explodes!");
			this.setName("Lifeboat");
			this.setEngine("Primary battery bank");
			this.setFuel("Electricity");
			this.setSeats(1);
			this.setHasWeapons(false);
			this.setWeaponPoints(0);
			this.setWeaponDamage(0);
		}
	}

	public void fireWeapon(Mob m) {
		m.tookDamage(this.getWeaponDamage());
	}
	
	public void fireWeapon(Vehicle v) {
		v.tookDamage(this.getWeaponDamage());
	}
	
	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}
}
