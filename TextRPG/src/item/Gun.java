package item;

import mob.Mob;
import java.util.Random;

public class Gun extends Weapon{
	private int magazine;
	
	//Amount of bullets fired per turn
	private int shotsFired;
	private int accuracy;
	
	public Gun() {
		super();
		magazine = 12;
		shotsFired = 1;
		accuracy = 50;
	}
	public Gun(int ID, String n, double w, double v, String dd, int c, boolean s, double dam, double r, int mag, int shots, int acc) {
		super(ID, n, w, v, dd, c, s, dam, r);
		magazine = mag;
		shotsFired = shots;
		accuracy = acc;
	}

	//Method to get the magazine size of the gun
	public int getMagazine() {
		return magazine;
	}

	//Method to set the magazine size of the gun
	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}

	//Method to get the amount of rounds fired per use
	public int getShotsFired() {
		return shotsFired;
	}

	//Method to set the amount of rounds fired per use
	public void setShotsFired(int shotsFired) {
		this.shotsFired = shotsFired;
	}

	//Method to get the accuracy of the gun
	public double getAccuracy() {
		return accuracy;
	}

	//Method to set the accuracy of the gun
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	//Method to fire a gun at an enemy. Using a random number generator, it calculates a number from 1 to 100.
	//If the value is below the accuracy stat, the shot misses. If it is the same as the stat, damage is increased by 50%
	//If it is larger than the stat, it misses.
	public void fireGun(Mob m) {
		Random shot = new Random();
		for(int i = 0; i < this.getShotsFired(); i++) {
		if(shot.nextDouble(100) < accuracy)
			m.tookDamage(this.getDamage());
		else if(shot.nextDouble(100) == accuracy)
			m.tookDamage(this.getDamage() * 1.5);
		else
			System.out.println("Your shot missed!");
	}
	}
}
