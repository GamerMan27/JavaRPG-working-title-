package mob;

/*
 * Programmer		Date		Changelog
 * Keith Davis		12/10/2022	Started implementing the Human class
 * 
 * This class is used to instantiate Human mobs and their subclasses.
 * The player character uses a generic Human.
 * Dead human NPCs that spawn dead are also generic Human.
 * Human NPCs that spawn can be generic Human or a subclass
 */


import java.util.Vector;
import item.*;
import app.Game;

public class Human extends Mob{

	public Human() {
		super();
		setCarryCapacity(35);
	}

	public Human(String n, boolean a, boolean i, double c, Vector<Item> in, Armor amr, int hp) {
		super();
		this.setName(n);
		this.setAlive(a);
		this.setInjured(i);
		this.setCarryCapacity(c);
		this.setInventory(in);
		this.setEquippedArmor(amr);
		this.setHealthPoints(hp);
		//This is a setter for a future system to be implemented
		//this.setInjuries(h);

	}

	public void checkInventory() {
		if(this.getInventory().isEmpty() != true) {
			for (int i = 0; i < this.getInventory().size(); i++) {
				System.out.print(this.getInventory().get(i).getName());
				System.out.println("   " + this.getInventory().get(i).getQuantity());
			}
		}
		else
			System.out.println("Inventory is empty");
	}


	public void useItem(Item it, Mob m) {
		if(it.getClass().equals(Gun.class)) {
			((Gun)it).fireGun(m);
		}
		else if(it.getClass().equals(Melee.class)) {
			((Melee)it).hitMob(m);
		}
		else if(it.getClass().equals(Armor.class)) {
			this.setEquippedArmor((Armor)it);
		}
		else if(it.getClass().equals(Consumable.class)) {
			for(int i = 0; i < Game.medList.length; i++) {
				if (it.equals(Game.medList[i])) {
					((Consumable)it).used();
					this.setHealthPoints(this.getHealthPoints() + 30);
					if(it.getQuantity() == 0) {
						this.removeInventory(it);
					}
				}
			}
			
		}
	}
	
}
